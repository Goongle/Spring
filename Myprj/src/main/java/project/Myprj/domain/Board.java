package project.Myprj.domain;

import com.fasterxml.jackson.annotation.JsonTypeId;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "board")
@Getter
public class Board {
    public Board() {
        this.insertTime = LocalDate.now();
    }

    public long getIdx() {
        return idx;
    }

    public void setIdx(long idx) {
        this.idx = idx;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public LocalDate getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(LocalDate  insertTime) {
        this.insertTime = insertTime;
    }


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long idx; // 자동 인덱스

    @Column()
    private String title; // 제목

    @Column()
    private String content; // 내용

    @Column()
    private String writer; // 작성자

    @Column
    private LocalDate insertTime; // 작성 시간


}
