package com.estsoft.freemall.controller.api;

import com.estsoft.freemall.dto.request.SellersRequest;
import com.estsoft.freemall.entity.Sellers;
import com.estsoft.freemall.service.SellersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sellers")
@RequiredArgsConstructor
public class SellersApiController {
    private final SellersService sellersService;

    @PostMapping
    public ResponseEntity<Sellers> register(Long userId, @RequestBody SellersRequest request) {
        return ResponseEntity.ok(sellersService.registerSeller(userId, request));
    }

    @GetMapping("/{sellerId}")
    public ResponseEntity<Sellers> getSeller(@PathVariable Long sellerId) {
        return ResponseEntity.ok(sellersService.getSellerById(sellerId));
    }

    @DeleteMapping("/{sellerId}")
    public ResponseEntity<Void> deleteSeller(@PathVariable Long sellerId) {
        sellersService.deleteSeller(sellerId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{sellerId}")
    public ResponseEntity<Sellers> updateSeller(@PathVariable Long sellerId, @RequestBody SellersRequest request) {
        return ResponseEntity.ok(sellersService.updateSller(sellerId, request));
    }
}
