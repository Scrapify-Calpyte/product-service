package com.scrapify.scrapify.repository;

import com.scrapify.scrapify.entity.ProductRegionMap;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRegionMapRepository extends JpaRepository<ProductRegionMap,String> {

    List<ProductRegionMap> findByRegion(String id);

    List<ProductRegionMap> findByProduct(String id);
}
