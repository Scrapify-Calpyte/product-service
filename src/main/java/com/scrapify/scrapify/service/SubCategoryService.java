package com.scrapify.scrapify.service;

import com.scrapify.scrapify.entity.SubCategory;
import com.scrapify.scrapify.utils.PaginationDTO;
import com.scrapify.scrapify.utils.TableResponse;

import java.util.List;

public interface SubCategoryService {

    SubCategory save(SubCategory subCategory);

    SubCategory findById(String id);

    List<SubCategory> getAll();

    TableResponse getSubCategories(PaginationDTO pagination);
}
