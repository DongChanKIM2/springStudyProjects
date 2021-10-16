package hello.core.order;

import hello.core.AppConfig;
import hello.core.member.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {

    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }
    @Test
    void createOrder() {
        // given
        // 생성자로하면 아래와 같이 생성해 java로 test할 수 있지만 필드 주입은 생성자가 없으니 생성 불가능해 java에서 test 불가능
        Member member1 = new Member(1l, "memberA", Grade.VIP);
        Member member2 = new Member(2l, "memberB", Grade.BASIC);

        memberService.join(member1);
        memberService.join(member2);

        // when
//        member1Id = memberService.findMember()
        Order result1 = orderService.createOrder(member1.getId(), "itemA", 10000);
        Order result2 = orderService.createOrder(member2.getId(), "itemA", 10000);

        // then
        System.out.println(result1);
        System.out.println(result2);
        Assertions.assertThat(result1.getDiscountPrice()).isEqualTo(1000);


    }

}