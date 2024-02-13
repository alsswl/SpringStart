package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

    //ctrl + shift + t하면 자동으로 test클래스 생성
    //private final MemberRepository memberRepository = new MemoryMemberRepository(); 이렇게 하면  test에서 다른 리퍼 사용

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository){ //생성자
        this.memberRepository = memberRepository;
    }


    //회원가입
    public Long join(Member member){

        //같은 이름이 있으면 안된다

       memberRepository.findByName(member.getName())
               .ifPresent(m->{
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });

        memberRepository.save(member);
        return member.getId();

    }

    //전체 회원 조회

    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}
