package com.leej.privacy.entity;

/**
 * @author jin
 * @date 2023/12/4
 * @Note
 */
import com.leej.privacy.PrivacyEncrypt;
import com.leej.privacy.PrivacyTypeEnum;
import lombok.Data;


@Data
public class People {

    private Integer id;

    private String name;

    private Integer sex;

    private Integer age;

    @PrivacyEncrypt(type = PrivacyTypeEnum.PHONE) // 隐藏手机号
    private String phone;

    @PrivacyEncrypt(type = PrivacyTypeEnum.EMAIL) // 隐藏邮箱
    private String email;

    private String sign;
}