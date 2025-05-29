package com.hari.ecommerce.service.interf;

import com.hari.ecommerce.dto.AddressDto;
import com.hari.ecommerce.dto.Response;

public interface AddressService {
    Response saveAndUpdateAddress(AddressDto addressDto);
}