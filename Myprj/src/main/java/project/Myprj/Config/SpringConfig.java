package project.Myprj.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import project.Myprj.repository.board.BoardRepository;
import project.Myprj.repository.board.JpaBoardRepository;
import project.Myprj.repository.email.EmailRepository;
import project.Myprj.repository.email.JpaEmailRepository;
import project.Myprj.repository.member.JpaMemberRepository;
import project.Myprj.repository.member.MemberRepository;
import project.Myprj.service.BoardService;
import project.Myprj.service.EmailService;
import project.Myprj.service.MemberService;

import javax.persistence.EntityManager;

@Configuration
public class SpringConfig {

    private EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
    }


    @Bean
    public MemberService memberService()
    {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository()
    {
        return new JpaMemberRepository(em);
    }

    @Bean
    public EmailService emailService() {return new EmailService(emailRepository());}

    @Bean
    public EmailRepository emailRepository(){return new JpaEmailRepository(em); }

    @Bean
    public BoardService boardService() {return new BoardService(boardRepository());}

    @Bean
    public BoardRepository boardRepository() {return new JpaBoardRepository(em);
    }

}
