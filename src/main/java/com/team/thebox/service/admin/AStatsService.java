package com.team.thebox.service.admin;

import java.util.Map;

public interface AStatsService {
    Map<String, Object> readTop5Date();

    Map<String, Object> readTop5Cmbo();

    Map<String, Object> readTop5Sales();

    Map<String, Object> readTop5Share();
}
