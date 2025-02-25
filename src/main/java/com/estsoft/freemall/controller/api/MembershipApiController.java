package com.estsoft.freemall.controller.api;

import com.estsoft.freemall.dto.request.MembershipRequest;
import com.estsoft.freemall.entity.Membership;
import com.estsoft.freemall.service.MembershipService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/membership")
@RequiredArgsConstructor
public class MembershipApiController {
    private final MembershipService membershipService;

    @PostMapping
    public ResponseEntity<Membership> register(@RequestBody MembershipRequest reuqest) {
        return ResponseEntity.ok(membershipService.addMembership(reuqest));
    }

    @GetMapping("/{membershipId}")
    public ResponseEntity<Membership> getMembership(@PathVariable Long membershipId) {
        return ResponseEntity.ok(membershipService.getMembershipById(membershipId));
    }

    @PutMapping("/{membershipId}")
    public ResponseEntity<Membership> updateMembership(@PathVariable Long membershipId, @RequestBody MembershipRequest reuqest) {
        return ResponseEntity.ok(membershipService.updateMembership(membershipId, reuqest));
    }

    @DeleteMapping("/{membershipId}")
    public ResponseEntity<Void> deleteMembership(@PathVariable Long membershipId) {
        boolean isDeleted = membershipService.deleteMembership(membershipId);

        if (!isDeleted) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}
