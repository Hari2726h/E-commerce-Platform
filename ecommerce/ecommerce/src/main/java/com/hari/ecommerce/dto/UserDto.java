package com.hari.ecommerce.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

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
    
    private String phoneNumber;

    private String role;
    private List<OrderItemDto> orderItemList;

    private AddressDto address;

    // private final LocalDateTime createdAt= LocalDateTime.now();


  


}
