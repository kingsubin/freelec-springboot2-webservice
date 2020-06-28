package com.soob.book.springboot.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass // Entity 클래스들이 상속할경우 필드도 칼럼으로 인식
@EntityListeners(AuditingEntityListener.class) // Auditing 기능 추가
public class BaseTimeEntity {
    // 모든 Entity의 상위 클래스가 되어 Entity들의 createdDate, modifiedDate 자동관리하는 역할

    @CreatedDate // 생성되어 저장될때 시간 자동 저장
    private LocalDateTime createdDate;

    @LastModifiedDate // 변경할때 시간이 자동 저장
    private LocalDateTime modifiedDate;

}
