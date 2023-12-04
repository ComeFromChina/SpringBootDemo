package com.leej.privacy;

import cn.hutool.json.JSONUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.leej.privacy.entity.People;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootPrivacyApplicationTests {

    @Test
    void contextLoads() throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();
        People p = new People();
        p.setId(123);
        p.setAge(22);
        p.setPhone("13820199108");
        p.setEmail("455193135@qq.com");
        String valueAsString = objectMapper.writeValueAsString(p);
        System.out.println(valueAsString);
        //{"id":123,"name":null,"sex":null,"age":22,"phone":"138****9108","email":"4****5@qq.com","sign":null}
    }

}
