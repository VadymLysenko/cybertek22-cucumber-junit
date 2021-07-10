package com.cybertek.utilities;

public class BrowserUtils {
    //copy whatever you have from previous project
    public static void sleep(int second)  {
        second*=1000;

        try {
            Thread.sleep(second);
        } catch (InterruptedException e) {

            System.out.println("Something happened in the sleep method");
        }
    }
}
