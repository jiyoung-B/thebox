package com.team.thebox.dao.admin;

import com.team.thebox.model.BookingDetails;
import com.team.thebox.model.Member;

import java.util.List;

public interface AMemberDAO {
    List<Member> selectAllMember();

    List<BookingDetails> selectAllBookedList();
}
