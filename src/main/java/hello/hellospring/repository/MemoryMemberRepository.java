package hello.hellospring.repository;

import hello.hellospring.domain.Member;


import java.util.*;

public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>();//데이터 저장
    private static long sequence = 0L; //key값 결정

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));//null일 떄를 대비
    }


    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny(); //전체를 다 찾아서 찾으면 반환하기
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }
}
