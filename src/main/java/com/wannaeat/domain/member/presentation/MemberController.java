package com.wannaeat.domain.member.presentation;

import com.wannaeat.domain.member.application.MemberService;
import com.wannaeat.domain.member.domain.Member;
import com.wannaeat.domain.member.domain.dto.reqeust.MemberCreateRequest;
import com.wannaeat.domain.member.domain.dto.response.MemberCreateResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/members")
public class MemberController {

    private final MemberService memberService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<MemberCreateResponse> create(@RequestBody MemberCreateRequest memberCreateRequest) {
        return memberService.create(memberCreateRequest)
                .map(MemberCreateResponse::from);
    }

    @GetMapping("/{id}")
    public Mono<Member> getById(@PathVariable Long id) {
        return memberService.getById(id);
    }

    @GetMapping
    public Flux<Member> getAll() {
        return memberService.getAll();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> delete(@PathVariable Long id) {
        return memberService.delete(id);
    }
}
