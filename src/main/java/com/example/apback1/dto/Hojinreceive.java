package com.example.apback1.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.List;

@Data
public class Hojinreceive {
    @JsonProperty("hojin-infos")
    private List<HojinInfo> hojinInfos;
    private String message;

    @Data
    public static class HojinInfo {

        @JsonProperty("corporate_number")
        private String corporateNumber;     // 法人番号
        private String name;    // 法人名
        private String location;    // 所在地
        @JsonProperty("update_date")
        private String updateDate;      // 更新日



    }
}

