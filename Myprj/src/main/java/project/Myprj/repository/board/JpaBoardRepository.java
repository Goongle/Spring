package project.Myprj.repository.board;

import org.springframework.beans.factory.annotation.Autowired;
import project.Myprj.domain.Board;
import project.Myprj.domain.Member;

import javax.persistence.EntityManager;
import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public class JpaBoardRepository implements BoardRepository {

    private final EntityManager em;

    @Autowired
    public JpaBoardRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Board save(Board board) {
        em.persist(board);
        return board;
    }

    @Override // Board의 Idx로 검색
    public Optional<Board> findById(Long id) {
        Board board = em.find(Board.class, id);
        return Optional.ofNullable(board);
    }

    @Override
    public Optional<Board> findByTitle(String Title) {
        List<Board> result = em.createQuery("select m from Board m where m.title = :title", Board.class)
                .setParameter("title", Title)
                .getResultList();
        return result.stream().findAny();
    }

    @Override
    public Optional<Board> findByName(String Name) {
        List<Board> result = em.createQuery("select m from Board m where m.writer = :name", Board.class)
                .setParameter("name", Name)
                .getResultList();
        return result.stream().findAny();
    }

    @Override
    public List<Board> findAll() {
        System.out.println("public List<Board> findAll() Jpa");
        return em.createQuery("select m from Board m", Board.class)
                .getResultList();
    }

    @Override
    public int DeletebyId(Long input_id) {
        String sql = "delete FROM Board as p " +
                "WHERE p.idx = :id";

        // 아래 구문에서 executeUpdate() 수행 시 구문 수행이 동작한 row 수를 반환
        // -1일 경우 행해진 행 없음
        int resultCount = em.createQuery(sql)
                .setParameter("id", input_id)
                .executeUpdate();
    return resultCount;
    }

    @Override
    public int UpdatebyId(Board board)
    {
        Long idx = board.getIdx();
        String Content = board.getContent();
        String Title = board.getTitle();
        String Writer = board.getWriter();
        String sql = "UPDATE Board as b " +
                "SET b.content = :Content, b.writer = :Writer, b.title = :Title " +
                "WHERE b.idx = :idx";

        int resultCount = em.createQuery(sql)
                .setParameter("Content", Content)
                .setParameter("Writer",Writer)
                .setParameter("Title",Title)
                .setParameter("idx",idx)
                .executeUpdate();
        return resultCount;

    }

    @Override
    public int findAllCnt()
    {
        // 여기서 Number는  BigDecimal, BigInteger, Byte, Double, Float, Integer, Long 및 Short 슈퍼 클래스
        // intValue 메서드를 통해 인트형으로 반환
    return ((Number)em.createQuery("select count(*) from Board")
            .getSingleResult()).intValue();
    }

    @Override
    public List<Board> findListPaging(int startIndex, int pageSize) {
        return em.createQuery("select b from Board b", Board.class)
                .setFirstResult(startIndex)
                .setMaxResults(pageSize)
                .getResultList();
    }

}
