package com.team.thebox.dao.admin;

import com.team.thebox.model.BookingDetails;
import com.team.thebox.model.Member;
import com.team.thebox.repository.BookingdetailsRepository;
import com.team.thebox.repository.MemberRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("admmemdao")
public class AMemberDAOImpl implements AMemberDAO{

    private final MemberRepository memberRepository;

    private final BookingdetailsRepository bookingdetailsRepository;

    public AMemberDAOImpl(MemberRepository memberRepository, BookingdetailsRepository bookingdetailsRepository) {
        this.memberRepository = memberRepository;
        this.bookingdetailsRepository = bookingdetailsRepository;
    }

    @Override
    public List<Member> selectAllMember() {
        return memberRepository.findAll();
    }

    @Override
    public List<BookingDetails> selectAllBookedList() {
        return bookingdetailsRepository.findAll();
    }
}
