package com.team.thebox;

import com.team.thebox.model.BookingDetails;
import com.team.thebox.model.CancellationDetails;
import com.team.thebox.model.Member;
import com.team.thebox.repository.BookingdetailsRepository;
import com.team.thebox.repository.CancellationdetailsRepository;
import com.team.thebox.repository.MypageRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
public class MypageTest {

    @Autowired
    MypageRepository mypageRepository;

    @Autowired
    BookingdetailsRepository bookingdetailsRepository;

    @Autowired
    CancellationdetailsRepository cancellationdetailsRepository;

    @Test
    @DisplayName("member delete")
    public void deleteMember() {
        Member m = new Member();
        m.setUserid("444444");

        mypageRepository.delete(m);
    }

    @Test
    @DisplayName("bds delete")
    public void deleteBds() {
        BookingDetails bd = new BookingDetails();
        bd.setBkno(21);

        bookingdetailsRepository.delete(bd);
    }

    @Test
    @DisplayName("cds insert")
    public void insertCds() {
        CancellationDetails cd = new CancellationDetails();
        cd.setUserid("aaa111");
        cd.setTitle("a");
        cd.setTotalprice(0);
        cd.setRegion("a");
        cd.setViewingday(LocalDateTime.now());

        cancellationdetailsRepository.save(cd);
    }
}
