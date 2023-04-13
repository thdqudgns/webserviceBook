package com.book.webservice.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity // 테이블과 링크될 클래스임을 나타낸다.
public class Posts {

    @Id // 테이블의 PK 필드를 나타낸다.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK의 생성규칙을 나타낸다. Spring Boot 2.0에서는 GenerationType.IDENTITY를 추가해야만 auto_increment가 된다.
    private Long id;

    // @Column 테이블의 컬럼을 의미하며, 선언하지 않아도 해당 클래스의 필드는 모두 컬럼이 된다.
    // 추가적인 변경 사항이 있으면 사용한다.
    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
