package com.hari.ecommerce.service.interf;

// import java.awt.print.Pageable;
// import java.time.LocalDateTime;


// /package com.phegondev.Phegon.Eccormerce.service.interf;


import com.hari.ecommerce.dto.OrderRequest;
import com.hari.ecommerce.dto.Response;
import com.hari.ecommerce.enums.OrderStatus;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;

public interface OrderItemService {
    Response placeOrder(OrderRequest orderRequest);
    Response updateOrderItemStatus(Long orderItemId, String status);
    Response filterOrderItems(OrderStatus status, LocalDateTime startDate, LocalDateTime endDate, Long itemId, Pageable pageable);
}