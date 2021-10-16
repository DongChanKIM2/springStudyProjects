package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    @Test
    public void join() {
        // given
        Member member1 = new Member(1l, "memberA", Grade.VIP);

        // when
        memberService.join(member1);

        Member result = memberService.findMember(1l);

        // then
        Assertions.assertThat(member1).isEqualTo(result);
    }

}