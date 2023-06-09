package com.team.thebox.service.admin;

import com.team.thebox.dao.admin.AMemberDAO;
import com.team.thebox.model.BookingDetails;
import com.team.thebox.model.Member;
import net.bytebuddy.implementation.auxiliary.AuxiliaryType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("admmemsrv")
public class AMemberServiceImpl implements AMemberService{
    @Autowired
    AMemberDAO admmemdao;

    @Override
    public List<Member> getAllMembers() {
        return admmemdao.selectAllMember();
    }

    @Override
    public List<BookingDetails> getAllBookedList() {
        return admmemdao.selectAllBookedList();
    }
}
