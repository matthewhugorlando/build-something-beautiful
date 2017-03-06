package com.ironyard.repo;

import com.ironyard.data.MACastIn;
import com.ironyard.dto.MACastInDTO;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by matthewhug on 3/5/17.
 */
public interface MACastInDTORepo extends PagingAndSortingRepository<MACastInDTO, Long> {
}
