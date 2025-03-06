package com.wannaeat.domain.member.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table("member")
@Getter
public class Member {

    @Id
    private Long memberid;
    private Long deptid; // 외래 키
    private String nickname;
    private String gender;
    private String image;
    private String role;
    private Long companyid; // 외래 키

    @CreatedDate
    private LocalDateTime createdate;

    @LastModifiedDate
    private LocalDateTime modifieddate;
}
