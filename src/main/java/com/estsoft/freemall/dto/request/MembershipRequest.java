package com.estsoft.freemall.dto.request;

import com.estsoft.freemall.entity.Membership;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MembershipRequest {
    private String level;
    private String benefits;

    public Membership toEntity() {
        return new Membership(level, benefits);
    }
    public void updateEntity(Membership membership) {
        membership.update(level, benefits);
    }
}
