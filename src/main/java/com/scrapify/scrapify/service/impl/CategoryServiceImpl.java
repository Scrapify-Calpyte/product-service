package com.scrapify.scrapify.service.impl;

import com.scrapify.scrapify.entity.Category;
import com.scrapify.scrapify.repository.CategoryRepository;
import com.scrapify.scrapify.service.CategoryService;
import com.scrapify.scrapify.specification.CategorySpecification;
import com.scrapify.scrapify.utils.Mapper;
import com.scrapify.scrapify.utils.PaginationDTO;
import com.scrapify.scrapify.utils.SearchCriteria;
import com.scrapify.scrapify.utils.TableResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category save(Category category) {
        Mapper.setAuditable(category);
        categoryRepository.save(category);
        return category;
    }

    @Override
    public Category findById(String id) {
        Optional<Category> category = categoryRepository.findById(id);
        return category.orElse(null);
    }

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public TableResponse getCategories(PaginationDTO pagination) {
        TableResponse response;
        Pageable paging = PageRequest.of(pagination.getPageNo()-1, pagination.getPageSize());
        Page<Category> categoryPage = categoryRepository.findAll(getSpecifications(pagination), paging);
        if (categoryPage.hasContent()) {
            List<Category> eCategoryList = categoryPage.getContent();
            response = new TableResponse(pagination.getDraw(), (int) categoryPage.getTotalElements(), (int) categoryPage.getTotalElements(), eCategoryList);
        } else {
            response = new TableResponse(pagination.getDraw(), (int) categoryPage.getTotalElements(), (int) categoryPage.getTotalElements(), new ArrayList<>());
        }
        return response;
    }

    private Specification<Category> getSpecifications(PaginationDTO pagination) {
        List<SearchCriteria> params = new ArrayList<>(pagination.getFilter());
        if (params.size() == 0) {
            return null;
        }
        List<Specification<Category>> specs = params.stream().map(CategorySpecification::new).collect(Collectors.toList());
        Specification<Category> result = specs.get(0);
        for (int i = 1; i < params.size(); i++) {
            result = params.get(i).isOrPredicate() ? Specification.where(result).or(specs.get(i)) : Specification.where(result).and(specs.get(i));
        }
        return result;
    }
}
