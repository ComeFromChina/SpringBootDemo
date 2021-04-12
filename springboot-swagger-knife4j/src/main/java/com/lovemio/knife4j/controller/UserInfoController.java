package com.lovemio.knife4j.controller;

import cn.hutool.core.util.IdUtil;
import com.lovemio.knife4j.entity.UserInfo;
import com.lovemio.knife4j.exception.ResultInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author liwenjin
 * @date 2021年04月12日 10:10
 */
@Validated
@RestController
@Api(value = "用户信息接口",tags = "用户接口tags")
public class UserInfoController {
    @ApiOperation(value = "添加用户")
    @PostMapping("/addUserInfo")
    public ResultInfo addUserInfo(@Validated UserInfo userInfo, BindingResult result) {
        List<FieldError> fieldErrors = result.getFieldErrors();
        if(!fieldErrors.isEmpty()){
            List<String> collect = fieldErrors.stream().map(s->s.getDefaultMessage()).collect(Collectors.toList());
            return ResultInfo.success(HttpStatus.BAD_REQUEST.value(),"字段校验不通过",collect);
        }
        return ResultInfo.success(HttpStatus.OK.value(),"成功");
    }

    @ApiOperation(value = "添加用户2")
    @PostMapping("/addUserInfo2")
    public ResultInfo addUserInfo2(@Validated UserInfo userInfo) {
        return ResultInfo.success(HttpStatus.OK.value(),"成功",userInfo);
    }

    @ApiOperation(value = "添加用户3")
    @PostMapping("/addUserInfo3")
    public ResultInfo addUserInfo3(@RequestBody @Validated UserInfo userInfo) {
        return ResultInfo.success(HttpStatus.OK.value(),"成功",userInfo);
    }

    @ApiOperation(value = "查询所有用户")
    @GetMapping("/getAll")
    public UserInfo getAll(){
        UserInfo userInfo = new UserInfo()
                .setId(IdUtil.createSnowflake(1,1).nextId())
                .setUserName("张三")
                .setNickName("昵称")
                .setEmail("10085@qq.com");
        return userInfo;

    }

    /**
     * 对实体属性进行参数校验
     * @param userInfo
     * @return
     */
    @ApiOperation(value = "根据用户名查询")
    @ApiImplicitParam(name = "userName",value = "姓名")
    @PostMapping("/getByName")
    public UserInfo getUserInfoByUserName(@RequestBody @Validated UserInfo userInfo){

        return userInfo;

    }

    /**
     * 对单个参数进行校验
     * @param name
     * @return
     */

    //@ApiImplicitParam(paramType = "query参数",dataType = "String",name = "name",value = "姓名",required = true)
    @ApiOperation(value = "打招呼-Hello")
    @GetMapping("/hello")
    public ResponseEntity<String> hello(@RequestParam(value = "name",required = false) @NotBlank(message = "name不能为空") String name){
        return ResponseEntity.ok("Hello:"+name);
    }
}
