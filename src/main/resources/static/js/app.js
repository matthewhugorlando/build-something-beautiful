angular.module("somethingBeautiful", [])

    .controller('mainCtrl', function($scope, dataService) {
        $scope.mySearch = function(searchParam) {
            $scope.playingGame = false;
            $scope.correctGuess = false;
            $scope.incorrectGuess = false;
            $scope.searchP = searchParam;
            dataService.setSearch($scope.searchP);
            dataService.getSearchResults(function (response) {
                console.log(response.data);
                $scope.searchResults = response.data.results;
            });
        }

        $scope.addActorToDB = function(actor){
            dataService.dBAddActor(actor.id);
        }

        $scope.newGame = function(){
            $scope.searchResults = null;
            $scope.correctGuess = false;
            $scope.incorrectGuess = false;
            dataService.newGameService(function(response){
                $scope.actorInGame = response.data;
                $scope.movies = [response.data.cast[Math.floor(Math.random() * response.data.cast.length)],
                                response.data.cast[Math.floor(Math.random() * response.data.cast.length)],
                                response.data.cast[Math.floor(Math.random() * response.data.cast.length)]]
            });
            $scope.playingGame = true;
        }

        $scope.guessActor = function(g){
            console.log($scope.actorInGame.madetails.name);
            console.log(g);
            console.log($scope.actorInGame.madetails.name === g);
            if($scope.actorInGame.madetails.name === g){
                $scope.correctGuess = true;
                $scope.incorrectGuess = false;
            } else{
                $scope.correctGuess = false;
                $scope.incorrectGuess = true;
            }
        }
    })

    .service('dataService', function($http){
        var search;
        this.getSearchResults = function(callback){
            $http.get('/movieactor/search?who=' + search)
                .then(callback)
        };

        this.setSearch = function(searchP){
            search = searchP;
        };

        this.dBAddActor = function(id){
            $http.get('/movieactor/add?ma_id='+id);
        }

        this.newGameService = function(callback){
            $http.get('/moviegame/newgame').then(callback);
        }

    });
