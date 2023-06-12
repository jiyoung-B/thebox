package com.team.thebox.model;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
@Table(name = "movreply")
@Setter @Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MovieReply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rpno;
    @NotBlank(message = "댓글은 필수항목입니다.")
    private String reply;
    @NotBlank(message = "작성자는 필수항목입니다.")
    private String userid;
    private Long movno;
    private int star;
    @CreatedDate
    @Column(insertable = false, updatable = false)
    private LocalDateTime regdate;
}
