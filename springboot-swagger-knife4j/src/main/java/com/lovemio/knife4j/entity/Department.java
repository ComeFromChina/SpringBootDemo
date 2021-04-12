package com.lovemio.knife4j.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author liwenjin
 * @date 2021年04月12日 17:20
 */
@Data
@ApiModel(value = "UserInfo",description = "用户部门表")
public class Department {
    @ApiModelProperty(value = "id")
    private Long id;

    @NotBlank(message = "部门名不能为空")
    @ApiModelProperty(value = "部门名")
    private String deptName;

}
