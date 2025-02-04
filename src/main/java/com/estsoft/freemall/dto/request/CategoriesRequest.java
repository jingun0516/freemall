package com.estsoft.freemall.dto.request;

import com.estsoft.freemall.entity.Categories;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoriesRequest {
    private String name;
    private String description;
    private String parentCategoryName;

    public Categories toEntity() {
        return new Categories(name, description);
    }
}
