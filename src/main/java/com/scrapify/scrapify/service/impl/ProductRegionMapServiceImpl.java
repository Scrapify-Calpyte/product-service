package com.scrapify.scrapify.service.impl;

import com.scrapify.scrapify.entity.ProductRegionMap;
import com.scrapify.scrapify.repository.ProductRegionMapRepository;
import com.scrapify.scrapify.service.ProductRegionMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductRegionMapServiceImpl implements ProductRegionMapService {

    @Autowired
    private ProductRegionMapRepository productRegionMapRepository;

    @Override
    public ProductRegionMap save(ProductRegionMap productRegionMap) {
        return productRegionMapRepository.save(productRegionMap);
    }

    @Override
    public List<ProductRegionMap> findByRegion(String id) {
        return productRegionMapRepository.findAllByRegionId(id);
    }

    @Override
    public List<ProductRegionMap> findByProduct(String id) {
        return productRegionMapRepository.findAllByProductId(id);
    }
}
