package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    private final MemberService memberService;

    // BAD : 불필요하게 여러 개의 객체가 생성됨
    // private final MemberService memberService = new MemberService();

    // GOOD : 컨테이너에 등록하여 활용
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
