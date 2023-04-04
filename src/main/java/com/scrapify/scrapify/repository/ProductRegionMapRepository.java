package com.scrapify.scrapify.repository;

import com.scrapify.scrapify.entity.ProductRegionMap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRegionMapRepository extends JpaRepository<ProductRegionMap,String> {

    List<ProductRegionMap> findByRegion(@Param("region") String id);

    List<ProductRegionMap> findByProduct(@Param("product") String id);
}
