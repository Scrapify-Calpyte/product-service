package com.scrapify.scrapify.controller;

import com.scrapify.scrapify.entity.SubCategory;
import com.scrapify.scrapify.service.SubCategoryService;
import com.scrapify.scrapify.utils.PaginationDTO;
import com.scrapify.scrapify.utils.TableResponse;
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
@RequestMapping("/sub_category")
public class SubCategoryController {

    @Autowired
    private SubCategoryService subCategoryService;

    @PostMapping("/save")
    public ResponseEntity<SubCategory> save(@RequestBody SubCategory subCategory){
        return new ResponseEntity<>(subCategoryService.save(subCategory), HttpStatus.CREATED);
    }

    @GetMapping("/by_id")
    public ResponseEntity<SubCategory> findById(@RequestParam String id){
        return new ResponseEntity<>(subCategoryService.findById(id),HttpStatus.OK);
    }

    @GetMapping("/find_all")
    public ResponseEntity<List<SubCategory>> getAll(){
        return new ResponseEntity<>(subCategoryService.getAll(),HttpStatus.OK);
    }

    @PostMapping(value = "/get_all")
    public ResponseEntity<TableResponse> getSubCategories(@RequestBody PaginationDTO pagination){
        return new ResponseEntity<>(subCategoryService.getSubCategories(pagination), HttpStatus.FOUND);
    }
}
