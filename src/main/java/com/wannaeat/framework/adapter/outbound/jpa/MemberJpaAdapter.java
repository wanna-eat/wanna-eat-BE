package com.wannaeat.framework.adapter.outbound.jpa;

import com.wannaeat.application.port.outbound.MemberRepository;
import com.wannaeat.domain.model.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemberJpaAdapter implements MemberRepository {
    private final MemberJpaRepository memberJpaRepository;

    @Override
    public Member save(Member member) {
        return memberJpaRepository.save(member);
    }
}
