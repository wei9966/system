package com.qs.insurance.system.common.nacos.utils;

import java.util.Random;

public class PortUtil {
    public static String getRandomPort(){
        int start = 10000;
        int end =65000;
        Random r=new Random();
        int nextInt = r.nextInt(end - start + 1);
        System.out.println("端口为"+(nextInt+start)+"");
        return nextInt+start+"";
    }
}
