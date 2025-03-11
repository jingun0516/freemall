package com.estsoft.freemall.dto.request;

import com.estsoft.freemall.entity.Manufacturers;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ManufacturersRequest {
    private String name;
    private String description;

    public Manufacturers toEntity() {
        return new Manufacturers(name, description);
    }

    public void updateEntity(Manufacturers manufacturers) {
        manufacturers.update(name, description);
    }
}
