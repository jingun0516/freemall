package com.estsoft.freemall.controller.api;

import com.estsoft.freemall.dto.request.OrderHistoryRequest;
import com.estsoft.freemall.entity.OrderHistory;
import com.estsoft.freemall.service.OrderHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/order")
public class OrderApiController {
    private final OrderHistoryService orderHistoryService;

    @PostMapping
    public ResponseEntity<OrderHistory> addOrder(@RequestBody OrderHistoryRequest request) {
        return ResponseEntity.ok(orderHistoryService.addOrderHistory(8L, request));
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<OrderHistory> getOrder(@PathVariable Long orderId) {
        return ResponseEntity.ok(orderHistoryService.getOrderHistoryById(orderId));
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long orderId) {
        orderHistoryService.deleteOrderHistoryById(orderId);
        return ResponseEntity.noContent().build();
    }
}
