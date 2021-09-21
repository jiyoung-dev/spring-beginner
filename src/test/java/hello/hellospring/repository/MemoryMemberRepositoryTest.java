package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }


    @Test
    public void save(){
        //given
        Member member = new Member();
        member.setName("Jiyoung");

        //when
        repository.save(member);

        //then
        Member result = repository.findById(member.getId()).get();
        assertThat(result).isEqualTo(member);
    }

    @Test
    public void findByName() {
        //given
        Member member1 = new Member();
        member1.setName("Jiyoung");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("Nayoung");
        repository.save(member2);

        //when
        Member result = repository.findByName("Jiyoung").get();

        //then
        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        //given
        Member member1 = new Member();
        member1.setName("Jiyoung");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("Nayoung");
        repository.save(member2);

        //when
        List<Member> result = repository.findAll();

        //then
        System.out.println(result);
        assertThat(result.size()).isEqualTo(2);
    }
}
