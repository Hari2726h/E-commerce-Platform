package com.hari.ecommerce.service.interf;

import com.hari.ecommerce.dto.CategoryDto;
import com.hari.ecommerce.dto.Response;

// import com.amazonaws.Response;

public interface CategoryService {
    Response createCategory(CategoryDto categoryRequest);

    Response updateCategory(Long categoryId, CategoryDto categoryRequest);

    Response getAllCategories();

    Response getCategoryById(Long categoryId);

    Response deletedCategory(Long categoryId);
}
