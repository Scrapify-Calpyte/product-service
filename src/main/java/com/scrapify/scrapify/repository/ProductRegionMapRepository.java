package com.scrapify.scrapify.repository;

import com.scrapify.scrapify.entity.ProductRegionMap;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRegionMapRepository extends JpaRepository<ProductRegionMap,String> {

    @EntityGraph(attributePaths = {"product","region"})
    List<ProductRegionMap> findAllByRegionId(String id);

    @EntityGraph(attributePaths = {"product","region"})
    List<ProductRegionMap> findAllByProductId(String id);
}
