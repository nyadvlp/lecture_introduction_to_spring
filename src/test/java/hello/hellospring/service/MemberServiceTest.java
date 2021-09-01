package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*; import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memoryMemberRepository;

    @BeforeEach
    public void beforeEach() {
        memoryMemberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memoryMemberRepository);
    }

    @AfterEach
    public void afterEach() {
        memoryMemberRepository.clearStore();
    }

    @Test
    void join() {
        // given
        Member member = new Member();
        member.setName("김바냐");

        // when
        Long saveId = memberService.join(member);

        // then
        Member result = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(result.getName());

    }

    @Test
    public void duplicateMemberException(){
        // given
        Member member1 = new Member();
        member1.setName("피유");

        Member member2= new Member();
        member2.setName("피유");

        // when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 등록된 이름입니다.");

        /*
        try {
            memberService.join(member2);
            fail();
        } catch (Exception e) {
            assertThat(e.getMessage()).isEqualTo("이미 등록된 이름입니다.");
        }
        */


    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}