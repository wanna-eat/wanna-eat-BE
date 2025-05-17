package com.wannaeat.application.port.inbound;

import com.wannaeat.application.dto.MemberInputDTO;
import reactor.core.publisher.Mono;

public interface CreateMemberUseCase {
    Mono<Void> createMember(MemberInputDTO memberInputDTO);
}