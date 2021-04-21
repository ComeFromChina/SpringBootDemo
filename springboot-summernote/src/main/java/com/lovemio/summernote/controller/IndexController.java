package com.lovemio.summernote.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author liwenjin
 * @date 2021年04月21日 15:04
 */
@Controller

public class IndexController {

    @GetMapping("/index")
    public String index(){
        return "index";
    }
}
