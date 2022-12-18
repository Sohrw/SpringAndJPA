package part2.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import part2.core.discount.DiscountPolicy;
import part2.core.discount.RateDiscountPolicy;
import part2.core.member.MemberRepository;
import part2.core.member.MemberService;
import part2.core.member.MemberServiceImpl;
import part2.core.member.MemoryMemberRepository;
import part2.core.order.OrderService;
import part2.core.order.OrderServiceImpl;

@Configuration
public class AppConfig {
    @Bean
    public MemberService memberService() {
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }
    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolish();
        return new RateDiscountPolicy();
    }
    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }


}
