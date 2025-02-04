package com.estsoft.freemall.service.impl;

import com.estsoft.freemall.dto.request.CategoriesRequest;
import com.estsoft.freemall.entity.Categories;
import com.estsoft.freemall.repository.CategoriesRepository;
import com.estsoft.freemall.service.CategoriesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoriesServiceImpl implements CategoriesService {
    private final CategoriesRepository categoriesRepository;

    @Override
    public Categories addCategory(CategoriesRequest request) {
        Categories category = request.toEntity();
        String parentCategoryName = request.getParentCategoryName();
        if(!parentCategoryName.isEmpty()) {
            Categories parentCategory = findCategoryByName(parentCategoryName);
            if(parentCategory != null) {
                category.setCategories(parentCategory);
            }
        }

        return categoriesRepository.save(category);
    }

    @Override
    public Categories findCategoryByName(String name) {
        return categoriesRepository.findByName(name);
    }
}
