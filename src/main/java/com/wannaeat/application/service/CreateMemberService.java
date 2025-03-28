package com.wannaeat.application.service;


import com.wannaeat.application.dto.MemberInputDTO;
import com.wannaeat.application.dto.MemberOutputDTO;
import com.wannaeat.application.port.inbound.CreateMemberUseCase;
import com.wannaeat.application.port.outbound.MemberRepository;
import com.wannaeat.domain.model.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CreateMemberService implements CreateMemberUseCase {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public MemberOutputDTO createMember(MemberInputDTO memberInputDTO) {
        Member member = memberInputDTO.toMember();
        member.changePassword(passwordEncoder.encode(member.getPassword()));
        return MemberOutputDTO.from(memberRepository.save(member));
    }
}
