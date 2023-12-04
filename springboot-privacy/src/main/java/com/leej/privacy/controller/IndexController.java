package com.leej.privacy.controller;

/**
 * @author jin
 * @date 2023/12/4
 * @Note
 */
import com.leej.privacy.entity.People;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @RequestMapping("/test")
    public People test() {
        People p = new People();
        p.setId(123);
        p.setAge(22);
        p.setPhone("13820199108");
        p.setEmail("455193135@qq.com");
        System.out.println(p.toString());
        return p;
    }
}