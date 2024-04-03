package com.github.binjoo.forever.utils;

import com.github.binjoo.forever.qqwry.IPZone;
import com.github.binjoo.forever.qqwry.QQWry;

/**
 * @author liangj
 * @version 1.0
 * @date 2024-03-13 21:18
 */
public class QQWryUtils {
    private static QQWry qqwry = null;

    public static String version() {
        String version = "";
        try {
            if (qqwry == null) {
                version = qqwry.getDatabaseVersion();
            }
            return version;
        } catch (Exception e) {
            return version;
        }
    }

    public static String parseIp(String ip) {
        String region = "火星";
        try {
            if (qqwry == null) {
                qqwry = new QQWry();
            }
            IPZone ipzone = qqwry.findIP(ip);
            return ipzone.getRegion();
        } catch (Exception e) {
            return region;
        }
    }
}
