package com.ironyard.repo;

import com.ironyard.dto.MADetailsDTO;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by matthewhug on 3/6/17.
 */
public interface MADetailsDTORepo extends PagingAndSortingRepository<MADetailsDTO, Long> {
    public MADetailsDTO findById(long id);
}
