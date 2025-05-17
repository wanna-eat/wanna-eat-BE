package com.wannaeat.application.port.outbound;


import com.wannaeat.domain.model.Member;
import reactor.core.publisher.Mono;

public interface MemberRepository {
    Mono<Member> save(Member member);
    Mono<Member> findByLoginId(String loginId);
}
