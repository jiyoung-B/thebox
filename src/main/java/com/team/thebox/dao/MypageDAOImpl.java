package com.team.thebox.dao;

import com.team.thebox.model.BookingDetails;
import com.team.thebox.model.CancellationDetails;
import com.team.thebox.model.Member;
import com.team.thebox.repository.BookingdetailsRepository;
import com.team.thebox.repository.CancellationdetailsRepository;
import com.team.thebox.repository.MypageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
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
        List<CancellationDetails> cdlist = cancellationdetailsRepository.findAllByUseridOrderByCancellationdate(userid);

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

    @Override
    public void updateEmail(String userid, String fillEmail) {
        Member m = mypageRepository.findAllByUserid(userid);

        m.setEmail(fillEmail);
        mypageRepository.save(m);
    }

    @Override
    public void updatePhnum(String userid, String changePhnum) {
        Member m = mypageRepository.findAllByUserid(userid);

        m.setPhone(changePhnum);
        mypageRepository.save(m);
    }

    @Override
    public void updatePswd(String userid, String newPswd2) {
        Member m = mypageRepository.findAllByUserid(userid);

        m.setPasswd(newPswd2);
        mypageRepository.save(m);
    }

    @Override
    public void deleteMember(String userid) {
        Member m = mypageRepository.findAllByUserid(userid);

        m.setUserid(userid);
        mypageRepository.delete(m);
    }

    @Override
    public void delBkNinsCan(int bkno, CancellationDetails cds) {
        // 행 조회
        BookingDetails bd = bookingdetailsRepository.findAllByBkno(bkno);

        // CancellationDetails에 삽입
        CancellationDetails cd = new CancellationDetails();
        cd.setUserid(bd.getUserid());
        cd.setCancellationdate(LocalDateTime.now());
        cd.setTitle(bd.getTitle());
        cd.setRegion(bd.getRegion());
        cd.setViewingday(bd.getViewingday());
        cd.setTotalprice(bd.getTotalprice());
        cancellationdetailsRepository.save(cd);

        // 행 삭제
        bd.setBkno(bkno);
        bookingdetailsRepository.delete(bd);
    }

    @Override
    public void updateProfile(String userid, MultipartFile attach) {
        Member m = mypageRepository.findAllByUserid(userid);

        String savePName = "http://localhost/cdn/profilepic/" + m.getUserid();
        m.setProfilepic(savePName);

        String orgFname = attach.getOriginalFilename();
        int pos = orgFname.lastIndexOf(".") + 1;
        String savePType = orgFname.substring(pos);
        m.setPictype(savePType);
        
        mypageRepository.save(m);
    }
}
