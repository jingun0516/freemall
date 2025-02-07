package com.estsoft.freemall.controller.api;

import com.estsoft.freemall.dto.request.MembershipRequest;
import com.estsoft.freemall.entity.Membership;
import com.estsoft.freemall.service.MembershipService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/membership")
@RequiredArgsConstructor
public class MembershipApiController {
    private final MembershipService membershipService;

    @PostMapping
    public ResponseEntity<Membership> register(@RequestBody MembershipRequest reuqest) {
        return ResponseEntity.ok(membershipService.addMembership(reuqest));
    }
}
