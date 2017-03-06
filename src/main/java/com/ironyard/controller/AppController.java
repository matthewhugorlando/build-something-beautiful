package com.ironyard.controller;

import com.ironyard.api.TMBDHelper;
import com.ironyard.dto.MADetailsDTO;
import com.ironyard.dto.MovieActorDTO;
import com.ironyard.dto.ResultsDTO;
import com.ironyard.repo.MADetailsDTORepo;
import com.ironyard.repo.MovieActorDTORepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

/**
 * Created by matthewhug on 3/3/17.
 */
@RestController
public class AppController {

    @Autowired
    MovieActorDTORepo movieActorDTORepo;

    @Autowired
    MADetailsDTORepo maDetailsDTORepo;

    /**
     *
     * @param who Name of the Actor to search the Movie Database API for
     * @return All the actors that fit the who parameter
     */
    @RequestMapping(path = "/movieactor/search", method = RequestMethod.GET)
    public ResultsDTO search(@RequestParam String who){
        TMBDHelper tmbdh = new TMBDHelper();
        return tmbdh.newSearch(who);
    }

    /**
     *
     * @param ma_id The ID corresponding to that actor in the Movie Database API
     * @return The Movie Actor saved in my database.
     */
    @RequestMapping(path = "/movieactor/add", method = RequestMethod.GET)
    public MovieActorDTO addActorToDB(@RequestParam Long ma_id){
        TMBDHelper tmbdh = new TMBDHelper();
        MADetailsDTO maD = tmbdh.actorDetails(ma_id);
        maDetailsDTORepo.save(maD);
        MovieActorDTO ma = tmbdh.addActor(ma_id, maD);
        movieActorDTORepo.save(ma);
        return ma;
    }

    /**
     *
     * @param id The ID corresponding to that actor in the Movie Database API
     * @return The details of the movie actor from the Movie Database API.
     */
    @RequestMapping(path = "/movieactor/details", method = RequestMethod.GET)
    public MADetailsDTO getActorDetails(@RequestParam Long id){
        TMBDHelper tmbdh = new TMBDHelper();
        return tmbdh.actorDetails(id);
    }

    /**
     * Starts a new game by randomly choosing an actor that has been saved to my database
     * @return A random actor from my database
     */
    @RequestMapping(path = "/moviegame/newgame")
    public MovieActorDTO newGame(){
        if(!movieActorDTORepo.findAll().iterator().hasNext()){
            return null;
        }
        Random r = new Random();
        int randomInt = r.nextInt(TMBDHelper.myDBSize)+50;
        return movieActorDTORepo.findOne((long)randomInt);
    }


}
