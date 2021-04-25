package com.lovemio.jwt.controller;

import com.lovemio.jwt.entity.UserInfo;
import com.lovemio.jwt.util.JwtUtil;
import com.lovemio.jwt.util.ResultInfo;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liwenjin
 * @date 2021年04月13日 11:26
 */
@RestController
public class LoginController {


    @GetMapping(value = "/getToken")
    public ResultInfo getToken(){
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> map = new HashMap<>();
        UserInfo userInfo = new UserInfo(1l,"李长生","最靓的崽");
        map.put("userInfo",userInfo);
        String token = JwtUtil.generateToken(map, "用户信息");

        Object userInfo1 = JwtUtil.getVal(token, "userInfo");

        result.put("解析前",userInfo);
        result.put("token",token);
        result.put("解析后",userInfo1);

        return ResultInfo.success(HttpStatus.OK.value(),"获取token成功",result);
    }

    @GetMapping(value = "/parseToken")
    public ResultInfo parseToken(String token){
        Map<String,Object> result = new HashMap<>();
        Object userInfo = null;
        if (!JwtUtil.isExpiration(token)){
            userInfo = JwtUtil.getVal(token, "userInfo");
        }else {
            result.put("message","token 已过期");
        }
        result.put("userInfo",userInfo);
        result.put("token",token);
        return ResultInfo.success(HttpStatus.OK.value(),"解析token",result);
    }

}
