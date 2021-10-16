package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AppConfig {

    // 구현체 생성과 생성 이후 연결을 담당하는 config

    // memberService interface를 외부에서 부루면 MemberServiceImpl 구현체가 생성이 되고 구현체에 MemoryMembemRepository 주입
    // 1. mermberService 가 호출되면
    // 2. MemberServiceImpl 구현
    // 3. MemoryMemberRepo 구현 후 주입
    // 4. MmmberServiceImpl 에서는 단순히 실행만 할뿐 생성 및 주입은 appconfig에서 해결

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    // orderService interface를 부르면 orderServiceImpl 구현체 생성 후 MemoryMemberRepo와
    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
//        return new FixDiscountPolicy();
    }
}
