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

    /*@Test
    @DisplayName("updateEmail")
    public void updateEmail() {

        Member m = new Member();
        m.setUserid("aaa111");
        m.setPasswd(m.getUserid().getPasswd());
        m.setName(m.getName());
        m.setPhone(m.getPhone());
        m.setEmail("bbb@gmail.com");

        mypageRepository.save(m);

    }*/
}
