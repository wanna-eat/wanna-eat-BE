package com.wannaeat.framework.adapter.outbound.jpa;

import com.wannaeat.domain.model.Member;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface MemberJpaRepository extends R2dbcRepository<Member, Long> {
    Mono<Member> findByLoginId(String loginId);
}
