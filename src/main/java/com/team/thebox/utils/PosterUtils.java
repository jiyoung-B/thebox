package com.team.thebox.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.UrlResource;
import org.springframework.web.util.UriUtils;

import java.nio.charset.StandardCharsets;

public class PosterUtils {

    // 포스터 저장 위치
    @Value("${posterDir}") private String posterDir;

    public UrlResource getResource(String title) {
        title = UriUtils.encode(title, StandardCharsets.UTF_8);

        UrlResource resource = null;
        try {
            resource = new UrlResource("file:" + title);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return resource;
    }
}
