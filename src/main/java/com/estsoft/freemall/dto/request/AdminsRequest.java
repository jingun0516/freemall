package com.estsoft.freemall.dto.request;

import com.estsoft.freemall.entity.Admins;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminsRequest {
    private Long userId;

    public Admins toEntity() {
        return new Admins();
    }
}
