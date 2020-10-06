package project.Myprj.repository.board;

import project.Myprj.domain.Member;
import project.Myprj.domain.Board;

import java.util.List;
import java.util.Optional;

public interface BoardRepository {

    Board save(Board board);
    Optional<Board> findByTitle(String Title);
    Optional<Board> findByName(String Name);
    Optional<Board> findById(Long id);
    List<Board> findAll();
    int DeletebyId(Long id);
    int UpdatebyId(Board board);
    int findAllCnt();
    List<Board> findListPaging(int startIndex, int pageSize);
}
