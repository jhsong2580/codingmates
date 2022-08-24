package com.gbc.codingmates.domain.member;

import com.gbc.codingmates.domain.project.Project;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="member_id")
    private Long id;

    @Column(length=10, nullable = false)
    private String username;

    @Column(length =30, nullable = false)
    private String email;

    @Column(length = 30, nullable = false)
    private String password;

    private LocalDateTime created_time, updated_time;

    @Enumerated(EnumType.STRING)
    private MemberStatus status;

    @OneToMany(mappedBy = "member")
    private List<Project> project = new ArrayList<>();

    @Builder
    public Member(String username, String email, String password){
        this.username = username;
        this.email = email;
        this.password = password;
    }



}
