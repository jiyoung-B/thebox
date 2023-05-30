package com.team.thebox.dao;

import com.team.thebox.model.Member;

public interface MypageDAO {
    Member selectOneMember(String userid);
}
