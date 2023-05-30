package com.team.thebox.dao;

import com.team.thebox.model.Pds;
import com.team.thebox.model.PdsAttach;

import java.util.List;
import java.util.Map;

public interface PdsDAO {

    int insertPds(Pds pds);
    int insertPdsAttach(PdsAttach pa);

    Map<String, Object> selectPds(int cpg);

    Pds selectOnePds(int pno);
    PdsAttach selectOnePdsAttach(int pno);

    void countDownload(int pno);

    List<String> selectFtype();


}