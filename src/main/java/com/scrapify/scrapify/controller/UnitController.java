package com.scrapify.scrapify.controller;

import com.scrapify.scrapify.entity.Unit;
import com.scrapify.scrapify.service.UnitService;
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
@RequestMapping("/unit")
public class UnitController {

    @Autowired
    private UnitService unitService;

    @PostMapping("/save")
    public ResponseEntity<Unit> save(@RequestBody Unit unit){
        return new ResponseEntity<>(unitService.save(unit), HttpStatus.CREATED);
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<Unit>> getAll(){
        return new ResponseEntity<>(unitService.getAll(),HttpStatus.OK);
    }
}
