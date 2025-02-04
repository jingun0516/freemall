package com.estsoft.freemall.service;

import com.estsoft.freemall.dto.request.CategoriesRequest;
import com.estsoft.freemall.entity.Categories;

public interface CategoriesService {
    Categories addCategory(CategoriesRequest request);
    Categories getCategoryByName(String name);
}
