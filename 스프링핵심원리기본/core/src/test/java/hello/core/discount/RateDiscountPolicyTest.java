package hello.core.discount;

import hello.core.AppConfig;
import hello.core.member.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {


    MemberService memberService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

//    MemberService memberService = new MemberServiceImpl();
    DiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP 할인")
    void 정률할인() {
        Member member1 = new Member(1l, "memberA", Grade.VIP);
        memberService.join(member1);

        int discount = discountPolicy.discount(member1, 10000);
        System.out.println(discount);

    }

    @Test
    @DisplayName("일반인 할인")
    void 일반인할인() {
        Member member1 = new Member(1l, "memberA", Grade.BASIC);
        memberService.join(member1);

        int discount = discountPolicy.discount(member1, 10000);
        System.out.println(discount);

    }
}