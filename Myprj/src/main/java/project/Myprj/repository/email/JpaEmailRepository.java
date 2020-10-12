package project.Myprj.repository.email;

import org.springframework.beans.factory.annotation.Autowired;
import project.Myprj.domain.Board;
import project.Myprj.domain.Email;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaEmailRepository implements EmailRepository{

    private final EntityManager em;

    @Autowired
    public JpaEmailRepository(EntityManager em) {
        this.em = em;
    }


    @Override
    public Email save(Email email) {
        em.persist(email);
        return email;
    }

    @Override
    public Optional<Email> findByContext(String content) {
        List<Email> result = em.createQuery("select m from Email m where m.content = :content", Email.class)
                .setParameter("content", content)
                .getResultList();
        return result.stream().findAny();
    }

    @Override
    public List<Email> findAll() {
        return em.createQuery("select m from Email m", Email.class)
                .getResultList();
    }
}
