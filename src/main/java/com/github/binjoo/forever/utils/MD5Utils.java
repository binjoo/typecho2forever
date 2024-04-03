package com.github.binjoo.forever.utils;

import org.springframework.util.StringUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author liangj
 * @version 1.0
 * @date 2024-03-22 21:22
 */
public class MD5Utils {

    public static String encrypt(String str) {
        try {
            if (!StringUtils.hasText(str)) {
                return "";
            }
            byte[] msg = str.getBytes();
            byte[] hash = null;
            MessageDigest md = MessageDigest.getInstance("MD5");
            hash = md.digest(msg);
            StringBuilder strBuilder = new StringBuilder();
            for (byte b : hash) {
                strBuilder.append(String.format("%02x", b));
            }
            return strBuilder.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

}
