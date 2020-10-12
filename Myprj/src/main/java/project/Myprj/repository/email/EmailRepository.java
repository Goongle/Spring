package project.Myprj.repository.email;

import project.Myprj.domain.Board;
import project.Myprj.domain.Email;

import java.util.List;
import java.util.Optional;

public interface EmailRepository {

    Email save(Email email);
    Optional<Email> findByContext(String content);
    List<Email> findAll();
}
