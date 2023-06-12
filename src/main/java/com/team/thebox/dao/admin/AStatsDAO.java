package com.team.thebox.dao.admin;

import java.util.Map;

public interface AStatsDAO {
    Map<String, Object> selectTop5Date();

    Map<String, Object> selectTop5Cmbo();

    Map<String, Object> selectTop5Sales();

    Map<String, Object> selectTop5Share();
}
