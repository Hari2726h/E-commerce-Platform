package com.hari.ecommerce.service.interf;

import com.hari.ecommerce.dto.LoginRequest;
import com.hari.ecommerce.dto.Response;
import com.hari.ecommerce.dto.UserDto;
import com.hari.ecommerce.entity.User;

public interface UserService {
    Response registerUser(UserDto registrationRequest);
    Response loginUser(LoginRequest loginRequest);
    Response getAllUsers();
    User getLoginUser();
    Response getUserInfoAndOrderHistory();
}