package com.ironyard.api;

import com.ironyard.dto.MADetailsDTO;
import com.ironyard.dto.MovieActorDTO;
import com.ironyard.dto.ResultsDTO;
import com.ironyard.repo.MADetailsDTORepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

/**
 * Class to proxy the Movie Database API
 * Created by matthewhug on 3/3/17.
 */
public class TMBDHelper {

    public static int myDBSize = 0;

    @Autowired
    MADetailsDTORepo maDetailsDTORepo;

    /**
     *
     * @param search Name of the Actor to search the Movie Database API for
     * @return All the actors that fit the who parameter
     */
    public ResultsDTO newSearch(String search){
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.add("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.95 Safari/537.36");

        HttpEntity entity = new HttpEntity(headers);

        HttpEntity response = restTemplate.exchange("https://api.themoviedb.org/3/search/person?api_key=e183b088b988a41428420b9703890913&language=en-US&query=" + search, HttpMethod.GET, entity, ResultsDTO.class);
        ResultsDTO r = (ResultsDTO) response.getBody();

        return r;
    }

    /**
     *
     * @param id id of the Actor to find in the Movie Database API for
     * @param maD Details of that specific movie actor to be saved to my database.
     * @return
     */
        public MovieActorDTO addActor(long id, MADetailsDTO maD){
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.add("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.95 Safari/537.36");

        HttpEntity entity = new HttpEntity(headers);

        HttpEntity response = restTemplate.exchange("https://api.themoviedb.org/3/person/" + Long.toString(id) + "/movie_credits?api_key=e183b088b988a41428420b9703890913&language=en-US", HttpMethod.GET, entity, MovieActorDTO.class);
        MovieActorDTO ma = (MovieActorDTO) response.getBody();

        ma.setMADetails(maD);
        myDBSize = myDBSize + 1;

        return ma;
    }

    /**
     *
     * @param id The ID corresponding to that actor in the Movie Database API
     * @return The details of the movie actor from the Movie Database API.
     */
    public MADetailsDTO actorDetails(long id){
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.add("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.95 Safari/537.36");

        HttpEntity entity = new HttpEntity(headers);

        HttpEntity response = restTemplate.exchange("https://api.themoviedb.org/3/person/" + Long.toString(id) + "?api_key=e183b088b988a41428420b9703890913&language=en-US", HttpMethod.GET, entity, MADetailsDTO.class);
        MADetailsDTO maD = (MADetailsDTO) response.getBody();

        return maD;
    }

}
