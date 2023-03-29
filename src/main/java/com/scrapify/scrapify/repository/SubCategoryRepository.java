package com.scrapify.scrapify.repository;

import com.scrapify.scrapify.entity.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SubCategoryRepository extends JpaRepository<SubCategory,String> , JpaSpecificationExecutor<SubCategory> {
}
