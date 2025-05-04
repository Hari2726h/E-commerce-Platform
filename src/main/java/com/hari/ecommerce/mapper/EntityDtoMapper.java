package com.hari.ecommerce.mapper;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.hari.ecommerce.dto.AddressDto;
import com.hari.ecommerce.dto.CategoryDto;
import com.hari.ecommerce.dto.OrderItemDto;
import com.hari.ecommerce.dto.ProductDto;
import com.hari.ecommerce.dto.UserDto;
import com.hari.ecommerce.entity.Address;
import com.hari.ecommerce.entity.Category;
import com.hari.ecommerce.entity.OrderItem;
import com.hari.ecommerce.entity.Product;
import com.hari.ecommerce.entity.User;

@Component
public class EntityDtoMapper {
    
    public UserDto mapUserToDtoBasic(User user){
        UserDto userDto=new UserDto();
        userDto.setId(user.getId());
        userDto.setPhonenumber(user.getPhonenumber());
        userDto.setEmail(user.getEmail());
        userDto.setRole(user.getRole().name());
        userDto.setName(user.getName());
        return userDto;
    }
    public AddressDto  mapAddressToDtoBasic(Address address){
        AddressDto addressDto=new AddressDto();
        addressDto.setId(address.getId());
        addressDto.setCity(address.getCity());
        addressDto.setState(address.getState());
        addressDto.setStreet(address.getStreet());
        addressDto.setCountry(address.getCountry());
        addressDto.setZipCode(address.getZipCode());
        return addressDto;
    }

    public CategoryDto mapCategoryToDtoBasic(Category category){
        CategoryDto categoryDto=new CategoryDto();
        categoryDto.setId(categoryDto.getId());
        categoryDto.setName(categoryDto.getName());
        return categoryDto;
    }

    public OrderItemDto mapOrderToItemDtoBasic(OrderItem orderItem){
        OrderItemDto orderItemDto=new OrderItemDto();
        orderItemDto.setId(orderItem.getId());
        orderItemDto.setQuantity(orderItem.getQuantity());
        orderItemDto.setPrice(orderItem.getPrice());
        orderItemDto.setStatus(orderItem.getStatus());
        orderItemDto.setCreatedAt(orderItem.getCreatedAt());
        return orderItemDto;
    }

    public ProductDto mapProductToDtoBasic(Product product){
        ProductDto productDto=new ProductDto();
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setDescription(product.getDescription());
        productDto.setPrice(product.getPrice());
        productDto.setImageUrl(product.getImageUrl());
        return productDto;
    }

    public UserDto mapUserToDtoPlusAddress(User user){
        UserDto userDto=mapUserToDtoBasic(user);
        if(user.getAddress()!=null){
            AddressDto addressDto=mapAddressToDtoBasic(user.getAddress());
            userDto.setAddress(addressDto);
        }
        return userDto;
    }
    
    public OrderItemDto mapOrderItemToDtoPlusProduct(OrderItem orderItem){
        OrderItemDto orderItemDto=mapOrderToItemDtoBasic(orderItem);
        if(orderItemDto.getProduct()!=null){
            ProductDto productDto=mapProductToDtoBasic(orderItem.getProduct());
            orderItemDto.setProduct(productDto);
        }
        return orderItemDto;
    }
    
    
    public OrderItemDto mapOrderItemToDtoPlusProductAndUser(OrderItem orderItem){
        OrderItemDto orderItemDto=mapOrderItemToDtoPlusProduct(orderItem);
        if(orderItemDto.getUser()!=null){
            UserDto userDto=mapUserToDtoBasic(orderItem.getUser());
            orderItemDto.setUser(userDto);
        }
        return orderItemDto;
    }
    
    public UserDto mapUserToDtoPlusAddressAndOrderHistory(User user){
        UserDto userDto=mapUserToDtoPlusAddress(user);
        if(user.getOrderItemList()!=null && !user.getOrderItemList().isEmpty()){
            userDto.setOrderItemList(user.getOrderItemList()
            .stream()
            .map(this::mapOrderItemToDtoPlusProduct)
            .collect(Collectors.toList()));
        }
        return userDto;
    }

}
