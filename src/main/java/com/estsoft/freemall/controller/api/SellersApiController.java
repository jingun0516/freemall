package com.estsoft.freemall.controller.api;

import com.estsoft.freemall.dto.request.SellersRequest;
import com.estsoft.freemall.entity.Sellers;
import com.estsoft.freemall.service.SellersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sellers")
@RequiredArgsConstructor
public class SellersApiController {
    private final SellersService sellersService;

    @PostMapping
    public ResponseEntity<Sellers> register(Long userId, @RequestBody SellersRequest request) {
        return ResponseEntity.ok(sellersService.registerSeller(userId, request));
    }
}
