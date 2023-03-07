package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    /*회원가입*/
    public Long join(Member member) {


        /*
        Optional<Member> result = memberRepository.findByName(member.getName());
        //Member member1 = result.get();
        //바로 값을 받을 수 있지만, Optional처리를 하여 감싸주는 것이 좋다
        result.ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        */
        
        //Optional이 안이쁘면 지우고 바로 ifPresent를 붙여서 사용 가능
        validateDuplicateMember(member); //중복회원 검증

        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
            .ifPresent(m -> {
                throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }
    /*
    전체회원조회
    */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }

}
