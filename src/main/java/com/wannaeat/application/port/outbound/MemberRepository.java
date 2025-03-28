package com.wannaeat.application.port.outbound;


import com.wannaeat.domain.model.Member;

import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);

    Optional<Member> findByEmail(String email);
}
