package project.Myprj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;
import project.Myprj.domain.Member;
import project.Myprj.repository.member.MemberRepository;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Transactional
public class MemberService implements UserDetailsService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    private void validateDuplicateMember(Member member) {
        System.out.println("In2");
        System.out.println(member.getName());
        Optional<Member> result = memberRepository.findByName(member.getName());
        // 존재할 경우 오류 발생 시킴
        if(result.isPresent()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    public long join(Member member) {

        try {
            System.out.println("In");
            validateDuplicateMember(member); // Ctrl + T 를 통해 Extract Method를 사용하여 이를 추출할 수 있다
            memberRepository.save(member);
            return member.getId();
        } finally {
            System.out.println("MemberService Join Doing");
        }

    }
    public List<Member> findMembers()
    {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId)
    {
        return memberRepository.findById(memberId);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Member> byUsername = memberRepository.findByName(username);
        Member member = byUsername.orElseThrow(() -> new UsernameNotFoundException(username)); // 없을 경우 예외를 던짐
        // UserDetails는 Interface 구현체이다.
        // 이는 우리의 Service마다 제각각으로 구현되어 있는 User 정보에 대한 Interface 이다. (모든 프로그래머가 다른 정보를 가지니까!)
        // 이를 user 라는 형태로 제공하고 있으며 ID, PASSWORD, 권한을 순서로 Param을 넣어주면 된다.
        return new User(member.getName(),member.getPassword(), createAccount());


    }

    private Collection<? extends GrantedAuthority> createAccount() {

        return Arrays.asList(new SimpleGrantedAuthority("MEMBER"));
    }

}
