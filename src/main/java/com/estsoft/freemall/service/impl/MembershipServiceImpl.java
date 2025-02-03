package com.estsoft.freemall.service.impl;

import com.estsoft.freemall.dto.request.MembershipRequest;
import com.estsoft.freemall.entity.Membership;
import com.estsoft.freemall.repository.MembershipRepository;
import com.estsoft.freemall.service.MembershipService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MembershipServiceImpl implements MembershipService {
    private final MembershipRepository membershipRepository;

    @Override
    public Membership register(MembershipRequest request) {
        return membershipRepository.save(request.toEntity());
    }

    @Override
    public Membership getMembership(String level) {
        return membershipRepository.findByLevel(level);
    }
}
