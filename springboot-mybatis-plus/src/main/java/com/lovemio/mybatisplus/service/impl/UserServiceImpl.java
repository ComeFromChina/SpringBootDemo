package com.lovemio.mybatisplus.service.impl;

import com.lovemio.mybatisplus.entity.User;
import com.lovemio.mybatisplus.mapper.UserMapper;
import com.lovemio.mybatisplus.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lwj
 * @since 2021-04-25
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
