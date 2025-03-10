package com.wannaeat.domain.member.domain;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table("member")
@Getter
@Builder
public class Member {

    @Id
    private Long memberId;

    private String loginId;

    private String password;

    private Long deptId;

    private String nickname;

    private String gender;

    private String image;

    private Long companyId;

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime modifiedDate;
}
