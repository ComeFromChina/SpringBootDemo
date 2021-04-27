package com.lovemio.mybatisplus.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author lwj
 * @since 2021-04-25
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class User extends Model {

    private static final long serialVersionUID = 1L;

    private String username;

    private String password;

    private String nickname;

    private Integer userStatus;

    private Integer depId;


}
