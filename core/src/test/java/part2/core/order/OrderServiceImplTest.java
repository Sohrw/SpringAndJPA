package part2.core.order;

import org.junit.jupiter.api.Test;
import part2.core.discount.FixDiscountPolicy;
import part2.core.member.Grade;
import part2.core.member.Member;
import part2.core.member.MemoryMemberRepository;

import static org.assertj.core.api.Assertions.*;

class OrderServiceImplTest {

    @Test
    void createOrder() {
        MemoryMemberRepository memberRepository = new MemoryMemberRepository();
        memberRepository.save(new Member(1L, "name", Grade.VIP));

        OrderServiceImpl orderService = new OrderServiceImpl(memberRepository, new FixDiscountPolicy());
        Order order = orderService.createOrder(1L, "itemA", 10000);
        assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }

}