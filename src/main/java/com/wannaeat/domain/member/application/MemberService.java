package com.wannaeat.domain.member.application;

import com.wannaeat.domain.member.domain.Member;
import com.wannaeat.domain.member.domain.dto.reqeust.MemberCreateRequest;
import com.wannaeat.domain.member.infrastructure.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@Slf4j
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public Mono<Member> create(MemberCreateRequest memberCreateRequest) {
        String password = passwordEncoder.encode(memberCreateRequest.password());
        log.debug("유저 패스워드 암호화 성공");
        return memberRepository.save(memberCreateRequest.toMember(password));
    }

    public Mono<Member> getById(Long id) {
        log.debug("유저 인덱스 검색 userId : {}", id);
        return memberRepository.findById(id);
    }

    public Flux<Member> getAll() {
        log.debug("유저 모두 찾기");
        return memberRepository.findAll();
    }

    public Mono<Void> delete(Long id) {
        log.debug("특정 유저 삭제 {}", id);
        return memberRepository.deleteById(id);
    }
}