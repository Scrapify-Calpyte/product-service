package com.scrapify.scrapify.repository;

import com.scrapify.scrapify.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,String> {
}
