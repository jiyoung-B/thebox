package com.team.thebox.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MovieRequestDto {
    private String movgenre;
    private String movtitle;
    private String movdirector;
    private String movactor;
    private String movreleasedate;
    private String movcountry;
    private String movgrade;
    private String movruntime;
    private String movdetail;
    private String movmainposter;
    private List<MultipartFile> stillcutslist;
    private String videourl;
}

