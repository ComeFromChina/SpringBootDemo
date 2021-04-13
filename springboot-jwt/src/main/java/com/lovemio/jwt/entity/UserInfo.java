package com.lovemio.jwt.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author liwenjin
 * @date 2021年04月13日 11:30
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {
    private Long id;//
    private String userName;
    private String niceName;

}
