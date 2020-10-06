package project.Myprj.service;

import org.springframework.beans.factory.annotation.Autowired;
import project.Myprj.domain.Board;
import project.Myprj.domain.Member;
import project.Myprj.repository.board.BoardRepository;
import project.Myprj.repository.member.MemberRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
public class BoardService {

    private final BoardRepository boardrepository;

    @Autowired
    public BoardService(BoardRepository boardrepository) {
        this.boardrepository = boardrepository;
    }

    /*
    private void validateDuplicateMember(Board board) {
        System.out.println("In2");
        System.out.println(member.getName());
        Optional<Member> result = memberRepository.findByName(member.getName());
        // 존재할 경우 오류 발생 시킴
        if(result.isPresent()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

     */

    public long join(Board board) {

        try {
            // validateDuplicateMember(member); // 중복검증을 굳이 할 필요가 없음.
            boardrepository.save(board);
            return board.getIdx(); // 인덱스 호출
        } finally {
            System.out.println("BoardService Join Doing");
        }

    }

    public List<Board> findBoardAll() {
        return boardrepository.findAll();
    }

    public Optional<Board> findOne(Long boardId) {
        return boardrepository.findById(boardId);
    }

    public Optional<Board> findbyName(String Name) {
        return boardrepository.findByName(Name);
    }

    public Optional<Board> findByTitle(String Title) {
        return boardrepository.findByTitle(Title);
    }

    public int Updateboard(Board board) {
        boardrepository.UpdatebyId(board);
        return boardrepository.UpdatebyId(board);

    }

    public int Deleteboard(Long id) {
        return boardrepository.DeletebyId(id);
    }

    public int findAllcnt() {
        return boardrepository.findAllCnt();
    }

    public List<Board> findByListPaging(int StartIndex, int pageSize)
    {
        return boardrepository.findListPaging(StartIndex,pageSize);

    }
}

