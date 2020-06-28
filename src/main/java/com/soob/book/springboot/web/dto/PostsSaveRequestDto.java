package com.soob.book.springboot.web.dto;

import com.soob.book.springboot.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/*
절대 Entity 클래스를 Request/Response 클래스로 사용하면 안됨
Entity는 DB와 맞닿은 핵심 클래스
Request와 Response용 Dto는 View를 위한 클래스라 정말 자주 변경이 필요
View Layer와 DB Layer의 역할 분리를 철저히
 */

@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {

    private String title;
    private String content;
    private String author;

    @Builder
    public PostsSaveRequestDto(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Posts toEntity() {
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }

}
