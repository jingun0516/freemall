package com.estsoft.freemall.controller.api;

import com.estsoft.freemall.dto.request.CategoriesRequest;
import com.estsoft.freemall.entity.Categories;
import com.estsoft.freemall.service.CategoriesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoriesApiController {
    private final CategoriesService categoriesService;

    @PostMapping
    public ResponseEntity<Categories> addCategory(@RequestBody CategoriesRequest request) {
        return ResponseEntity.ok(categoriesService.addCategory(request));
    }
}
