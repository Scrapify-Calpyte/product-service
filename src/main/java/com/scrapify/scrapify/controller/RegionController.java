package com.scrapify.scrapify.controller;

import com.scrapify.scrapify.entity.Region;
import com.scrapify.scrapify.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/region")
public class RegionController {

    @Autowired
    private RegionService regionService;


    @PostMapping("/save")
    public ResponseEntity<Region> save(@RequestBody Region region){
        return new ResponseEntity<>(regionService.save(region), HttpStatus.CREATED);
    }

    @GetMapping("/get_all")
    public ResponseEntity<List<Region>> getAll(){
        return new ResponseEntity<>(regionService.getAll(),HttpStatus.OK);
    }
}
