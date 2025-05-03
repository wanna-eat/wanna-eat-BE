package com.wannaeat.framework.adapter.outbound.jpa;

import com.wannaeat.domain.model.MemberPreference;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Mono;

public interface MemberPreferenceRepository extends R2dbcRepository<MemberPreference, Long> {
    Mono<MemberPreference> findByMemberId(Long memberId);
}
