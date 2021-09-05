package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping ("/members/new")
    public String create(MemberForm form) {
        Member member = new Member(); // CRUD 작업을 위한 객체 생성
        member.setName(form.getName()); // form으로 받아온 이름 세팅
        memberService.join(member); // 만들어 둔 create 작업
        return "redirect:/"; // home 화면으로 돌려보냄
    }
}
