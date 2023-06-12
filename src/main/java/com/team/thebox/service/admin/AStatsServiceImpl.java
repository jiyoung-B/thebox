package com.team.thebox.service.admin;

import com.team.thebox.dao.admin.AStatsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("assrv")
public class AStatsServiceImpl implements AStatsService{

    @Autowired
    AStatsDAO asdao;

    @Override
    public Map<String, Object> readTop5Date() {
        return asdao.selectTop5Date();
    }

    @Override
    public Map<String, Object> readTop5Cmbo() {
        return asdao.selectTop5Cmbo();
    }

    @Override
    public Map<String, Object> readTop5Sales() {
        return asdao.selectTop5Sales();
    }

    @Override
    public Map<String, Object> readTop5Share() {
        return asdao.selectTop5Share();
    }
}
