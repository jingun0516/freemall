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
    public Membership addMembership(MembershipRequest request) {
        return membershipRepository.save(request.toEntity());
    }

    @Override
    public Membership getMembership(String level) {
        return membershipRepository.findByLevel(level);
    }

    @Override
    public Membership getMembershipById(Long id) {
        return membershipRepository.findById(id).orElse(null);
    }

    @Override
    public Membership updateMembership(Long id, MembershipRequest request) {
        Membership membership = getMembershipById(id);
        if(membership == null) {
            return null;
        }
        return membershipRepository.save(request.updateEntity(membership));
    }

    @Override
    public boolean deleteMembership(Long id) {
        Membership membership = getMembershipById(id);
        if(membership == null) {
            return false;
        }
        membershipRepository.delete(membership);
        return true;
    }
}
