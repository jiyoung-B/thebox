package com.team.thebox.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MovieDTO {
    private String movgenre;
    private String movtitle;
    private String movdirector;
    private String movactor;
    private String movreleasedate;
    private String movcountry;
    private String movgrade;
    private String movruntime;
    private String movdetail;
    private MultipartFile movieMainPoster;
    private MultipartFile[] stillcuts;
    private MultipartFile[] videos;
}
