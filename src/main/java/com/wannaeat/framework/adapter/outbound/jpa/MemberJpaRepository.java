package com.wannaeat.framework.adapter.outbound.jpa;

import com.wannaeat.domain.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberJpaRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByEmail(String email);
}
