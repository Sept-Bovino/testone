package com.allinpay.autotest;

import com.allinpay.autotest.util.PropertiesUtil;

import java.io.File;
import java.io.InputStream;
import java.util.Properties;

/**
 * 快捷支付，要绑卡，本人授权
 */
public class FastPay {


    public static void main(String[] args) {
        InputStream conf = PropertiesUtil.class.getResourceAsStream("/conf2.properties");
        Properties confProps = PropertiesUtil.getSpecificProperties(conf);
        String input2Path = confProps.getProperty("inputpath");
        File file = new File(input2Path);

        if (file.isDirectory()) {
            File[] inputs = file.listFiles();
            for (int i = 0; i < inputs.length; i++) {
                File inputData = inputs[i];
                String fileName = inputData.getName();
                System.out.println("suit file name is "+fileName);

            }
        }
    }
}
