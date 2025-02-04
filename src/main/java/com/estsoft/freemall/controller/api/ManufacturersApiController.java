package com.estsoft.freemall.controller.api;

import com.estsoft.freemall.dto.request.ManufacturersRequest;
import com.estsoft.freemall.entity.Manufacturers;
import com.estsoft.freemall.service.ManufacturersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/manufacturers")
@RequiredArgsConstructor
public class ManufacturersApiController {
    private final ManufacturersService manufacturersService;

    @PostMapping
    public ResponseEntity<Manufacturers> addManufacturer(@RequestBody ManufacturersRequest request) {
        return ResponseEntity.ok(manufacturersService.addManufacturer(request));
    }
}
