package project.Myprj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.Myprj.domain.Board;
import project.Myprj.domain.Pagination;
import project.Myprj.service.BoardService;

import java.util.List;
import java.util.Optional;

@Controller
public class BoardController {

    private BoardService boardservice;

    public BoardController(BoardService boardservice) {
        this.boardservice = boardservice;
    }

    @GetMapping("/board/list")
    public String list(Model model, @RequestParam(defaultValue = "1") int page)
    {
        int totalListCnt = boardservice.findAllcnt(); // 총 게시물 수를 가져온다.
        Pagination pagination = new Pagination(totalListCnt,page); // 현재 페이지 및 총 게시물 개수를 넣어줌.
        int startIndex = pagination.getStartIndex(); // DB Find Index 추출
        int pageSize = pagination.getPageSize(); // 최대 가져올 페이지 사이즈 추출

        List<Board> boardlist = boardservice.findByListPaging(startIndex,pageSize); // 전체 수와 Page를 통해 일부 리스트만 추출
        model.addAttribute("boardList",boardlist);
        model.addAttribute("pagination",pagination);
        return "/board/list";

    }

    @GetMapping("/board/post")
    public String write() {

        return "/board/write";
    }

    @PostMapping("/post")
    public String write(@RequestParam(name = "title") String Title, @RequestParam(name = "writer") String writer, @RequestParam(name = "content") String Content) {

        Board board = new Board();
        board.setContent(Content);
        board.setTitle(Title);
        board.setWriter(writer);
        System.out.print(board.getWriter());
        boardservice.join(board);
        return "redirect:/board/list";
    }

    @GetMapping("/post/{no}")
    public String detail(@PathVariable("no") Long no, Model model) {

        Board board = boardservice.findOne(no).get();
        model.addAttribute("board", board);
        return "/board/detail";
    }

    /*
    @GetMapping("/post/edit/{no}")
    public String edit(@PathVariable("no") Long no, Model model) {
        BoardDto boardDTO = boardService.getPost(no);

        model.addAttribute("boardDto", boardDTO);
        return "board/update.html";
    }
     */

   //  @DeleteMapping("/post/{no}")
    @RequestMapping(value = "/post/{no}", method = {RequestMethod.PUT,RequestMethod.POST})
    public String delete(@PathVariable("no") Long no) {
        boardservice.Deleteboard(no);

        return "redirect:/board/list";
    }

    @GetMapping("/post/edit/{no}")
    public String Update(@PathVariable("no") Long no,Model model)
    {
        Board board = boardservice.findOne(no).get();
        model.addAttribute("board",board);
        return "/board/update";

    }

    //@PutMapping("/post/edit/{no}")
    @RequestMapping(value = "/post/edit/{no}", method = {RequestMethod.PUT,RequestMethod.POST})
    public String update(@PathVariable("no") Long no, @RequestParam("id") String input_idx,@RequestParam("title") String input_title, @RequestParam("writer") String input_writer, @RequestParam("content") String input_content)
    {
        Board board = new Board();
        board.setContent(input_content);
        board.setIdx(no);
        board.setTitle(input_title);
        board.setWriter(input_writer);
        boardservice.Updateboard(board);
        return "redirect:/board/list";
    }



}
