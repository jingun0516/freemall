package com.estsoft.freemall.dto.request;

import com.estsoft.freemall.entity.Admins;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminsRequest {
    Long userId;

    public Admins toEntity() {
        return new Admins();
    }
}
