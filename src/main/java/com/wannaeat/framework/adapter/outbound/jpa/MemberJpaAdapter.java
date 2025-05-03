package com.wannaeat.framework.adapter.outbound.jpa;

import com.wannaeat.application.port.outbound.MemberRepository;
import com.wannaeat.domain.model.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class MemberJpaAdapter implements MemberRepository {
    private final MemberJpaRepository memberJpaRepository;

    @Override
    public Mono<Member> save(Member member) {
        return memberJpaRepository.save(member);
    }

    @Override
    public Mono<Member> findByLoginId(String loginId) {
        return memberJpaRepository.findByLoginId(loginId);
    }
}
