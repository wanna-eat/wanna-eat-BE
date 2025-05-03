package com.wannaeat.application.service;

import com.wannaeat.application.dto.MemberInputDTO;
import com.wannaeat.application.port.inbound.CreateMemberUseCase;
import com.wannaeat.application.port.outbound.MemberRepository;
import com.wannaeat.domain.model.Member;
import com.wannaeat.domain.model.MemberPreference;
import com.wannaeat.framework.adapter.outbound.jpa.MemberPreferenceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class MemberService implements CreateMemberUseCase {

    private final MemberRepository memberRepository;
    private final MemberPreferenceRepository preferenceRepository;

    public Mono<Void> createMember(MemberInputDTO dto) {
        Member member = dto.toMember();

        return memberRepository.save(member)
                .flatMap(savedMember -> {
                    MemberPreference preference = dto.toPreference(savedMember.getMemberId());
                    return preferenceRepository.save(preference);
                })
                .then(); // 반환형 Mono<Void>
    }
}
