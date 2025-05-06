package com.hari.ecommerce.service.interf;

import com.hari.ecommerce.dto.AddressDto;
import com.hari.ecommerce.dto.Response;

// import com.amazonaws.Response;

public interface AddressService {
    Response saveAndupdateAddress(AddressDto addressDto);
}
