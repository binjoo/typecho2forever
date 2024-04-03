package com.github.binjoo.utils;

import com.alibaba.fastjson.JSONObject;
import nl.bitwalker.useragentutils.UserAgent;

/**
 * @author liangj
 * @version 1.0
 * @date 2024-03-13 20:59
 */
public class UserAgentUtils {

    public static JSONObject parseUserAgent(String agent) {
        JSONObject ua = new JSONObject();
        try {
            UserAgent userAgent = UserAgent.parseUserAgentString(agent);

            ua.put("osName", userAgent.getOperatingSystem().getName());
            ua.put("browserName", userAgent.getBrowser().getName());

            String osGroup = userAgent.getOperatingSystem().getGroup().toString();
            switch (osGroup.toLowerCase()) {
                case "windows":
                    ua.put("osIcon", "windows");
                    break;
                case "linux":
                    ua.put("osIcon", "linux");
                    break;
                case "ios":
                case "os x":
                case "mac_os_x":
                case "apple":
                    ua.put("osIcon", "apple");
                    break;
                case "android":
                    ua.put("osIcon", "android");
                    break;
                default:
                    ua.put("osIcon", "unknown");
                    break;
            }

            String browserGroup = userAgent.getBrowser().getGroup().toString();
            switch (browserGroup.toLowerCase()) {
                case "chrome":
                case "coolnovo":
                    ua.put("browserIcon", "chrome");
                    break;
                case "firefox":
                case "mozilla":
                    ua.put("browserIcon", "firefox");
                    break;
                case "edge":
                    ua.put("browserIcon", "edge");
                    break;
                case "opera":
                    ua.put("browserIcon", "opera");
                    break;
                case "safari":
                    ua.put("browserIcon", "safari");
                    break;
                case "ie":
                    ua.put("browserIcon", "ie");
                    break;
                default:
                    ua.put("browserIcon", "unknown");
                    break;
            }
            return ua;
        } catch (Exception e) {
            ua.put("osName", "unknown");
            ua.put("osIcon", "unknown");
            ua.put("browserName", "unknown");
            ua.put("browserIcon", "unknown");
            return ua;
        }
    }
}
