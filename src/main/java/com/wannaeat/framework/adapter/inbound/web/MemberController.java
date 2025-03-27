package com.wannaeat.framework.adapter.inbound.web;

import com.wannaeat.application.dto.MemberInputDTO;
import com.wannaeat.application.dto.MemberOutputDTO;
import com.wannaeat.application.port.inbound.CreateMemberUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/members")
public class MemberController {

    private final CreateMemberUseCase createMemberUseCase;

    @PostMapping
    public ResponseEntity<MemberOutputDTO> createMember(@RequestBody final MemberInputDTO memberInputDTO) {
        return ResponseEntity.ok(createMemberUseCase.createMember(memberInputDTO));
    }
}
