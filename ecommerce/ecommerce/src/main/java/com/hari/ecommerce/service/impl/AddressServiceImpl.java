package com.hari.ecommerce.service.impl;

import org.springframework.stereotype.Service;

import com.hari.ecommerce.dto.AddressDto;
import com.hari.ecommerce.dto.Response;
import com.hari.ecommerce.entity.Address;
import com.hari.ecommerce.entity.User;
import com.hari.ecommerce.repository.AddressRepo;
import com.hari.ecommerce.service.interf.AddressService;
import com.hari.ecommerce.service.interf.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepo addressRepo;
    private final UserService userService;


    @Override
    public Response saveAndUpdateAddress(AddressDto addressDto) {
        User user = userService.getLoginUser();
        Address address = user.getAddress();

        if (address == null){
            address = new Address();
            address.setUser(user);
        }
        if (addressDto.getStreet() != null) address.setStreet(addressDto.getStreet());
        if (addressDto.getCity() != null) address.setCity(addressDto.getCity());
        if (addressDto.getState() != null) address.setState(addressDto.getState());
        if (addressDto.getZipCode() != null) address.setZipCode(addressDto.getZipCode());
        if (addressDto.getCountry() != null) address.setCountry(addressDto.getCountry());

        addressRepo.save(address);

        String message = (user.getAddress() == null) ? "Address successfully created" : "Address successfully updated";
        return Response.builder()
                .status(200)
                .message(message)
                .build();
    }
}