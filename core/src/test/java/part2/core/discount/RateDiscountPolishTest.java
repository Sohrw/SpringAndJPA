package part2.core.discount;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import part2.core.member.Grade;
import part2.core.member.Member;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolishTest {
    RateDiscountPolicy discountPolish = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP should apply 10% discount")
    void vip_o() {
        //given
        Member member = new Member(1L, "memberA", Grade.VIP);

        //when
        int discount = discountPolish.discount(member, 10000);
        //then
        assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("If client is not VIP, Don't apply discount")
    void vip_x() {
        //given
        Member member = new Member(2L, "memberB", Grade.NORMAL);

        //when
        int discount = discountPolish.discount(member, 10000);
        //then
        assertThat(discount).isEqualTo(0);
    }
}