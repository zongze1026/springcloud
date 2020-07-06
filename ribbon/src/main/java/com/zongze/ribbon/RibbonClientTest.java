package com.zongze.ribbon;

/**
 * @Date 2020/7/4 22:49
 * @Created by xzz
 */
public class RibbonClientTest {


    public static void main(String[] args) {

        RibbonClient ribbonClient = new RibbonClient();
        for (int i=0;i<5;i++){
            String result = ribbonClient.call();
            System.out.println(result);

        }
    }


}
