package com.team.thebox.dao.admin;

import com.team.thebox.model.Stats;
import com.team.thebox.repository.AStatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository("asdao")
public class AStatsDAOImpl implements AStatsDAO{

    @Autowired
    AStatsRepository aStatsRepository;

    @Override
    public Map<String, Object> selectTop5Date() {
        List<Stats> t5dlist = aStatsRepository.findFirst5ByOrderByBoxofficeDesc();

        Map<String, Object> t5d = new HashMap<>();
        t5d.put("t5dlist", t5dlist);

        return t5d;
    }

    @Override
    public Map<String, Object> selectTop5Cmbo() {
        List<Stats> t5clist = aStatsRepository.findFirst5ByOrderByCumulativeboxofficeDesc();

        Map<String, Object> t5c = new HashMap<>();
        t5c.put("t5clist", t5clist);

        return t5c;
    }

    @Override
    public Map<String, Object> selectTop5Sales() {
        List<Stats> t5salist = aStatsRepository.findFirst5ByOrderBySalesDesc();

        Map<String, Object> t5sales = new HashMap<>();
        t5sales.put("t5salist", t5salist);

        return t5sales;
    }

    @Override
    public Map<String, Object> selectTop5Share() {
        List<Stats> t5shlist = aStatsRepository.findFirst5ByOrderBySalesshareDesc();

        Map<String, Object> t5share = new HashMap<>();
        t5share.put("t5shlist", t5shlist);

        return t5share;
    }
}
