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

    public Manufacturers updateEntity(Manufacturers manufacturers) {
        if(name != null) {
            manufacturers.setName(name);
        }
        if(description != null) {
            manufacturers.setDescription(description);
        }
        return manufacturers;
    }
}
