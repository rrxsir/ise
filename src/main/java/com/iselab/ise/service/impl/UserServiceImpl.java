package com.iselab.ise.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.crypto.digest.BCrypt;
import com.iselab.ise.common.ErrorCode;
import com.iselab.ise.exception.BusinessException;
import com.iselab.ise.model.DTO.user.LoginDTO;
import com.iselab.ise.model.POJO.User;
import com.iselab.ise.repository.UserRepository;
import com.iselab.ise.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public boolean register(LoginDTO loginDTO) {
        if(userRepository.findByUsername(loginDTO.getUsername()) != null){
            throw new BusinessException(ErrorCode.OPERATION_ERROR,"用户名已存在");
        }
        User user = new User();
        BeanUtils.copyProperties(loginDTO, user);
        String pwd = BCrypt.hashpw(loginDTO.getPassword());
        user.setPassword(pwd);
        userRepository.save(user);
        return true;
    }

    @Override
    public boolean login(LoginDTO loginDTO) {
        User user = userRepository.findByUsername(loginDTO.getUsername());
        if(user == null){
            throw new BusinessException(ErrorCode.NOT_FOUND_ERROR,"用户不存在");
        }
        if(!BCrypt.checkpw(loginDTO.getPassword(),user.getPassword())){
            throw new BusinessException(ErrorCode.PARAMS_ERROR,"密码错误");
        }
        StpUtil.login(user.getId());
        return true;
    }


}
