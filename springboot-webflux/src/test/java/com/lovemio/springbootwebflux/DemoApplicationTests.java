package com.lovemio.springbootwebflux;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.math.RoundingMode;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads(){

        try {
            System.out.println(div(10d,3d,-1));
        } catch (MyException e) {
            e.printStackTrace();
        }
    }

    /**
     * 加法
     * @param value1
     * @param value2
     * @return
     */
    public static double add(double value1, double value2) {
        BigDecimal b1 = new BigDecimal(Double.toString(value1));
        BigDecimal b2 = new BigDecimal(Double.toString(value2));
        return b1.add(b2).doubleValue();
    }

    public static double add2(double value1, double value2) {
        BigDecimal b1 = BigDecimal.valueOf(value1);
        BigDecimal b2 = BigDecimal.valueOf(value2);
        return b1.add(b2).doubleValue();
    }

    public static double sub(double value1, double value2) {
        BigDecimal b1 = BigDecimal.valueOf(value1);
        BigDecimal b2 = BigDecimal.valueOf(value2);
        return b1.subtract(b2).doubleValue();
    }

    public static double mul(double value1,double value2){
        BigDecimal b1 = BigDecimal.valueOf(value1);
        BigDecimal b2 = BigDecimal.valueOf(value2);
        return b1.multiply(b2).doubleValue();
    }

    public static double div(double value1,double value2) {

        return div(value1,value2,10);
    }

    /**
 　　* 精确除法
 　　*
 　　* @param scale
 　　* 精度
 　　*/
    public static double div(double value1, double value2, int scale) {
        if (scale < 0) {
            throw new MyException("精确度不能小于0");
        }
        BigDecimal b1 = BigDecimal.valueOf(value1);
        BigDecimal b2 = BigDecimal.valueOf(value2);
        return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    //自定义异常处理
    public static class MyException extends RuntimeException{
        public MyException(String message) {
            super(message);
        }
    }
}
