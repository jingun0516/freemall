package com.estsoft.freemall.service;

import com.estsoft.freemall.dto.request.MembershipRequest;
import com.estsoft.freemall.entity.Membership;

public interface MembershipService {
    Membership addMembership(MembershipRequest request);
    Membership getMembership(String level);
    Membership getMembershipById(Long id);
    Membership updateMembership(Long id, MembershipRequest request);
    boolean deleteMembership(Long id);
}
