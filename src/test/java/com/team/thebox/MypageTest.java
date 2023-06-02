package com.team.thebox;

import com.team.thebox.model.Member;
import com.team.thebox.repository.MypageRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MypageTest {

    @Autowired
    MypageRepository mypageRepository;

    @Test
    @DisplayName("member delete")
    public void deleteMember() {
        Member m = new Member();
        m.setUserid("444444");

        mypageRepository.delete(m);
    }
}
