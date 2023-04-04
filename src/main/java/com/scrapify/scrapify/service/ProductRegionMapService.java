package com.scrapify.scrapify.service;

import com.scrapify.scrapify.entity.ProductRegionMap;

import java.util.List;

public interface ProductRegionMapService {

    ProductRegionMap save(ProductRegionMap productRegionMap);

    List<ProductRegionMap> findByRegion(String id);

    List<ProductRegionMap> findByProduct(String id);
}
