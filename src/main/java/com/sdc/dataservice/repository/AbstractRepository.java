package com.sdc.dataservice.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.sdc.data.repository.BaseRepository;
import com.sdc.dataservice.model.AbstractProduct;

public interface AbstractRepository <T extends AbstractProduct, String> extends BaseRepository <T, String> {
    Page<T> findByStockTrue(Pageable pageable);
}
