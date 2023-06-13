package com.team.thebox.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
@Table(name = "ticketing")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Ticketing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pmnumber;

    @NotBlank(message = "영화관을 선택해주세요!")
    private String district;

    private String cinematype;

    @NotBlank(message = "날짜를 선택해주세요!")
    private String movdate;

    @NotBlank(message = "영화를 선택해주세요!")
    private String movname;

    @NotBlank(message = "시간을 선택해주세요!")
    private String movtime;

    @NotBlank(message = "결제를 진행해주세요!")
    private String rsp;

    @NotBlank(message = "좌석을 선택해주세요!")
    private String seat;

    @NotBlank(message = "로그인이 필요합니다!")
    private String userid;

    private String adult;

    private String teen;

    private String movseatadult;

    private String movseatteen;

    private String movtotalprice;

    private Integer movnum;

    private String regdate;
}
