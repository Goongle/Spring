package project.Myprj.repository.member;

import project.Myprj.domain.Member;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class SpringDataJpaMemberRepository implements MemberRepository{

    private final EntityManager em;

    public SpringDataJpaMemberRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Member save(Member member) {
        em.persist(member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        Member member = em.find(Member.class, id);
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findByName(String Name) {
        Member member = em.find(Member.class, Name);
        return Optional.ofNullable(member);
    }

    @Override
    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }
}
