package org.westos.crm.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Author: ShenMouMou
 * @CreateTime: 2019-12-27 10:28
 * @Company:西部开源教育科技有限公司
 * @Description:爱生活，爱Java!
 */
public class MD5Utils {
    public static String getMD5(String pwd) throws NoSuchAlgorithmException {
        //获取MD5加密的一个类
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        byte[] digest = md5.digest(pwd.getBytes());
        StringBuffer stringBuffer = new StringBuffer();
        for (byte by : digest) {
            int i = by & 0xff;
            //再把运算完的结果转成16进制
            String string = Integer.toHexString(i);
            if (string.length() < 2) {
                string = string + "0";
            }
            // System.out.println(string);
            stringBuffer.append(string);
        }
        return stringBuffer.toString();
    }
}
