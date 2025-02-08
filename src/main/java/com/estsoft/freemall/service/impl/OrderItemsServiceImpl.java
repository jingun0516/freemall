package com.estsoft.freemall.service.impl;

import com.estsoft.freemall.dto.request.OrderItemsRequest;
import com.estsoft.freemall.entity.Discounts;
import com.estsoft.freemall.entity.OrderHistory;
import com.estsoft.freemall.entity.OrderItems;
import com.estsoft.freemall.entity.Products;
import com.estsoft.freemall.repository.OrderItemsRepository;
import com.estsoft.freemall.service.DiscountsService;
import com.estsoft.freemall.service.OrderHistoryService;
import com.estsoft.freemall.service.OrderItemsService;
import com.estsoft.freemall.service.ProductsService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderItemsServiceImpl implements OrderItemsService {
    private final OrderItemsRepository orderItemsRepository;
    private final ProductsService productsService;
    private final OrderHistoryService orderHistoryService;
    private final DiscountsService discountsService;

    @Override
    public OrderItems addOrderItem(Long orderHistoryId, OrderItemsRequest request) {
        Products product = productsService.getProductById(request.getProductId());
        OrderHistory orderHistory = orderHistoryService.getOrderHistoryById(orderHistoryId);
        List<Discounts> discounts = discountsService.getDiscounts(request.getProductId());

        if(product == null || orderHistory == null){
            throw new EntityNotFoundException("product or orderHistory not found");
        }

        BigDecimal price = product.getPrice();
        OrderItems orderItem = request.toEntity();
        orderItem.setOrderHistory(orderHistory);
        orderItem.setUnitPrice(price);

        if(!discounts.isEmpty()) {
            price = discountsService.calculateDiscountedPrice(price, discounts);
        }
        BigDecimal totalPrice = price.multiply(BigDecimal.valueOf(orderItem.getQuantity()));

        orderItem.setTotalPrice(totalPrice);

        return orderItem;
    }
}
