package com.github.binjoo.forever.qqwry;

import lombok.Data;

/**
 * @author liangj
 * @version 1.0
 * @date 2024-03-14 9:54
 */
@Data
public class IPZone {
    private final String ip;
    private String mainInfo = "";
    private String subInfo = "";

    private String region;


    public IPZone(String ip) {
        this.ip = ip;
    }

    public void setMainInfo(String mainInfo) {
        this.mainInfo = mainInfo;
        this.region = "火星";
        for (int i = 0; i < Constants.REGION.length; i++) {
            if (mainInfo.contains(Constants.REGION[i])) {
                this.region = Constants.REGION[i];
                break;
            }
        }
    }
}
