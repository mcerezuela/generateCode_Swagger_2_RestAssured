package com.smashtik.petstore.client.api.test.utils;

import java.util.Random;

public class CommonUtils {
    static boolean debug = true;

    public static int generateCommonRandomNumber(int max, int min) {
        Random random = new Random();
        int num = random.nextInt((max - min));
        if(debug)System.out.println("NUMBER: "+num);
        return num;

    }
}
