package com.soob.book.springboot.domain.posts;

import com.soob.book.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter // getter 생성 , Entity 에서는 setter 생성 X
@NoArgsConstructor // 기본생성자 생성
@Entity // 테이블
public class Posts extends BaseTimeEntity {

    @Id // PK, PK는 Long타입으로 설정 추천 , 주민번호와 같은거는 UNIQUE로 따로 설
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 설정해야 auto_increment 적용
    private Long id;

    @Column(length = 500, nullable = false) // 컬럼설정 , 기본값말고 다른 설정하고싶을때 사용
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author; // @Column설정 없이도 컬럼으로 설정됨

    @Builder // 생성자로 사용해도되나 Builder패턴 추천
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
