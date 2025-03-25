package com.wannaeat.application.port.outbound;


import com.wannaeat.domain.model.Member;

public interface MemberRepository {
    Member save(Member member);
}
