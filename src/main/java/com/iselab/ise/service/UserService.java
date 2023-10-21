package com.iselab.ise.service;

import com.iselab.ise.model.DTO.user.LoginDTO;

public interface UserService {

    boolean register(LoginDTO loginDTO);

    boolean login(LoginDTO loginDTO);
}
