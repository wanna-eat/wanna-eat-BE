package com.wannaeat.domain.member.application;

import com.wannaeat.domain.member.domain.Member;
import com.wannaeat.domain.member.infrastructure.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Mono<Member> save(Member member) {
        return memberRepository.save(member);
    }

    public Mono<Member> getById(Long id) {
        return memberRepository.findById(id);
    }

    public Flux<Member> getAll() {
        return memberRepository.findAll();
    }

    public Mono<Void> delete(Long id) {
        return memberRepository.deleteById(id);
    }
}