package com.hari.ecommerce.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.hari.ecommerce.entity.OrderItem;
import com.hari.ecommerce.enums.UserRole;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDto {
     private Long id;
    
    private String name;

    private String email;


    private String password;
    
    private String phonenumber;

    private UserRole role;
    private List<OrderItem> orderItemList;

    private AddressDto address;

    private final LocalDateTime createdAt= LocalDateTime.now();


}
