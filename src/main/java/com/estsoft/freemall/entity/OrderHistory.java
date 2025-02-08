package com.estsoft.freemall.entity;

import com.estsoft.freemall.enums.OrderStatus;
import com.estsoft.freemall.enums.PaymentStatus;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

    @Column(name = "order_date")
    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    // 배송지
    @Column(name = "shipping_address")
    private String shippingAddress;

    @OneToOne
    @JoinColumn(name = "user_payment_method_id")
    private UserPaymentMethods userPaymentMethod;

    @Column(name = "total_amount")
    private BigDecimal totalAmount;

    // 배송비
    @Column(name = "shipping_cost")
    private BigDecimal shippingCost;

    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;

    @Column(name = "tracking_number")
    private String trackingNumber;

    @Column(name = "cancellation_refund_info")
    private String cancellationRefundInfo;

    // 주문자 연락처
    @Column(name = "contact_info")
    private String contactInfo;

    @Column(name = "order_notes")
    private String orderNotes;

    @OneToMany(mappedBy = "orderHistory", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItems> orderItems;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        this.orderStatus = OrderStatus.PREPARING;
        this.paymentStatus = PaymentStatus.BEFORE_PAYMENT;
        this.totalAmount = BigDecimal.ZERO;
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
