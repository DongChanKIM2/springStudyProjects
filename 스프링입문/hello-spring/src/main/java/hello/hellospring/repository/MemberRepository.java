package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {


    Member save(Member member);
    // optional (null 값도 받아와주는? get같은 녀석인가)
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();


}
