package com.ironyard.repo;

import com.ironyard.data.MovieActor;
import com.ironyard.dto.MovieActorDTO;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by matthewhug on 3/5/17.
 */
public interface MovieActorDTORepo extends PagingAndSortingRepository<MovieActorDTO, Long>{
}
