package com.team.thebox.service.admin;

import com.team.thebox.model.BookingDetails;
import com.team.thebox.model.Member;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AMemberService {
    List<Member> getAllMembers();

    List<BookingDetails> getAllBookedList();
}
