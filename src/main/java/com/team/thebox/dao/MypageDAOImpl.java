package com.team.thebox.dao;

import com.team.thebox.model.BookingDetails;
import com.team.thebox.model.CancellationDetails;
import com.team.thebox.model.Member;
import com.team.thebox.repository.BookingdetailsRepository;
import com.team.thebox.repository.CancellationdetailsRepository;
import com.team.thebox.repository.MypageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository("mpdao")
public class MypageDAOImpl implements MypageDAO{

    @Autowired
    MypageRepository mypageRepository;

    @Autowired
    BookingdetailsRepository bookingdetailsRepository;

    @Autowired
    CancellationdetailsRepository cancellationdetailsRepository;

    @Override
    public Member selectOneMember(String userid) {
        return mypageRepository.findAllByUserid(userid);
    }

    @Override
    public Map<String, Object> selectBookingDetails(String userid) {

        List<BookingDetails> bdlist = bookingdetailsRepository.findAllByUserid(userid);

        Map<String, Object> bds = new HashMap<>();
        bds.put("bdlist", bdlist);

        return bds;
    }

    @Override
    public Map<String, Object> selectCancellationDetails(String userid) {
        List<CancellationDetails> cdlist = cancellationdetailsRepository.findAllByUserid(userid);

        Map<String, Object> cds = new HashMap<>();
        cds.put("cdlist", cdlist);

        return cds;
    }

    @Override
    public Map<String, Object> selectTop2(String userid) {
        List<BookingDetails> t2list = bookingdetailsRepository.findAllByUserid(userid).stream().limit(2).collect(Collectors.toList());

        Map<String, Object> t2s = new HashMap<>();
        t2s.put("t2list", t2list);

        return t2s;
    }
}
