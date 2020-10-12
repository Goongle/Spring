package project.Myprj.domain;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "email")
public class Email {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long idx; // 자동 인덱스

    @Column()
    private String content; // 내용

    public long getIdx() {
        return idx;
    }

    public void setIdx(long idx) {
        this.idx = idx;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
