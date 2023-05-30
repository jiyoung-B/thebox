package com.team.thebox.service.admin;

import com.team.thebox.domain.Pds;
import com.team.thebox.domain.PdsAttach;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public interface PdsService {
    Map<String, Object> newPds(Pds pds);

    boolean newPdsAttach(
            MultipartFile attach, Map<String, Object> pinfo);

    Map<String, Object> readPds(Integer cpg);

    Pds readOnePds(int pno);
    PdsAttach readOnePdsAttach(int pno);

    HttpHeaders getHeader(String fname, String uuid);
    UrlResource getResource(String fname, String uuid);

    void downfile(int pno);

    List<String> readFtype();


}
