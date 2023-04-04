package com.scrapify.scrapify.controller;

import com.scrapify.scrapify.entity.ProductRegionMap;
import com.scrapify.scrapify.service.ProductRegionMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product_region")
public class ProductRegionMapController {

    @Autowired
    private ProductRegionMapService productRegionMapService;


    @PostMapping("/save")
    public ResponseEntity<ProductRegionMap> save(@RequestBody ProductRegionMap productRegionMap){
        return new ResponseEntity<>(productRegionMapService.save(productRegionMap), HttpStatus.CREATED);
    }

    @GetMapping("/by_region")
    public ResponseEntity<List<ProductRegionMap>> findByRegion(@RequestParam("region") String id){
        return new ResponseEntity<>(productRegionMapService.findByRegion(id),HttpStatus.OK);
    }

    @GetMapping("/by_product")
    public ResponseEntity<List<ProductRegionMap>> findByProduct(@RequestParam("product") String id){
        return new ResponseEntity<>(productRegionMapService.findByProduct(id),HttpStatus.OK);
    }
}
