package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    public void save(){
        Member member = new Member();
        member.setName("yoon");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        //System.out.println("result = " + (result == member));
        //Assertions.assertEquals(member,result);
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("yoon1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("yoon2");
        repository.save(member2);

        Member result1 = repository.findByName("yoon1").get();

        assertThat(member1).isEqualTo(result1);
    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("yoon1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("yoon2");
        repository.save(member2);

        List<Member> result1 = repository.findAll();

        assertThat(result1.size()).isEqualTo(2);
    }
}
