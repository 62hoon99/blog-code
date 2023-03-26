package querydsl.performanceimprovement.company.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import querydsl.performanceimprovement.company.entity.Member;
import querydsl.performanceimprovement.company.repository.MemberRepository;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberRepository memberRepository;

    @GetMapping("/member")
    public List<Member> findMember(@RequestParam(value = "team") String teamName) {
        return memberRepository.notCrossJoin(teamName);
    }
}
