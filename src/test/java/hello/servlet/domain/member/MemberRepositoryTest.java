package hello.servlet.domain.member;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach(){
        memberRepository.clearStore();
    }

    @Test
    void save() {
        //give
        Member member = new Member("MinGyu", 27);

        //when
        Member savedMember = memberRepository.save(member);

        //then
        Member findMember = memberRepository.findById(savedMember.getId());
        assertThat(findMember).isEqualTo(savedMember);
    }


    @Test
    void findAll() {
        //given
        Member member1 = new Member("MinGyu", 27);
        Member member2 = new Member("YuJin", 27);

        //when
        memberRepository.save(member1);
        memberRepository.save(member2);

        //then
        assertThat(memberRepository.findAll()).contains(member1, member2);
    }


}