package com.estsoft.freemall.dto.request;

import com.estsoft.freemall.entity.OrderHistory;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class OrderHistoryRequest {
    // 결제수단
    private Long userPaymentMethodId;
    // 배송지
    private String shippingAddress;
    // 배송비
    private BigDecimal shippingCost;
    // 송장 번호 (배송중일 시)
    private String trackingNumber;
    // 교환 환불 정보
    private String cancellationRefundInfo;
    // 주문자 연락처
    private String contactInfo;
    // 주문 메모
    private String orderNotes;

    public OrderHistory toEntity() {
        return OrderHistory.builder()
                .shippingAddress(shippingAddress)
                .shippingCost(shippingCost)
                .trackingNumber(trackingNumber)
                .cancellationRefundInfo(cancellationRefundInfo)
                .contactInfo(contactInfo)
                .orderNotes(orderNotes)
                .build();
    }

    public void updateEntity(OrderHistory orderHistory) {
        orderHistory.update(shippingAddress, shippingCost, trackingNumber, cancellationRefundInfo, contactInfo, orderNotes);
    }
}
