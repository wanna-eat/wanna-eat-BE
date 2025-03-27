package com.wannaeat.application.port.inbound;


import com.wannaeat.application.dto.MemberInputDTO;
import com.wannaeat.application.dto.MemberOutputDTO;

public interface CreateMemberUseCase {
    MemberOutputDTO createMember(MemberInputDTO memberInputDTO);
}