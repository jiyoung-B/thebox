package com.team.thebox.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class StarTDO {
        private Long movno;
        private String movtitle;
        private String movactor;
        private String movgrade;
        private String movreleasedate;
        private String movmainposter;
        private Double tsales;
        private Double avgStar;

        // getter 및 setter 메서드
    }

