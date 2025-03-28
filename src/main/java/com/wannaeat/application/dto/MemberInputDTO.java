package com.wannaeat.application.dto;


import com.wannaeat.domain.model.Member;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;

public record MemberInputDTO(@Pattern(
        regexp = "^[a-zA-Z가-힣]+$",
        message = "이름은 한글 또는 영문 대소문자만 입력할 수 있습니다."
) String nickname, @Email String email, @Pattern(
        regexp = "^(?=.*[A-Za-z])(?=.*\\d|.*\\W).{6,20}$",
        message = "비밀번호는 영문 대/소문자, 숫자, 특수문자 중 2가지 이상 조합하여 6~20자로 입력하세요."
) String password) {

    public Member toMember() {
        return Member.of(email, password, nickname);
    }
}
