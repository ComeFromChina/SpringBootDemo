package com.lovemio.knife4j.entity;

import com.lovemio.knife4j.annotation.Phone11;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * @author liwenjin
 * @date 2021年04月12日 10:13
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Accessors(chain = true)
@ApiModel(value = "UserInfo",description = "用户信息表")
public class UserInfo {
    @ApiModelProperty(value = "id")
    private Long id;

    @NotBlank(message = "用户名不能为空")
    @Size(max = 3,message = "用户名不能超过3")
    @ApiModelProperty(value = "用户名")
    private String userName;

    @NotBlank(message = "昵称不能为空")
    @ApiModelProperty(value = "昵称")
    private String nickName;//

    @Email(message = "邮箱格式不正确")
    @ApiModelProperty(value = "邮箱")
    private String email;

    //校验11位手机号
    @Phone11
    private String phone;

    @Valid
    private Department department;

}
