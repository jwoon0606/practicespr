package com.example.practicespr.domain;

import com.example.practicespr.dto.NoticeDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
public class Notice extends AuditingFields{
    @Setter String title;
    @Setter String content;
    // id는 AuditingFields 안에 있음

    protected Notice(){}
    private Notice(Boolean deleted, String process, String title, String content) {
        this.deleted = deleted;
        this.process = process;
        this.title = title;
        this.content = content;
    }
    public static Notice of(String title, String content) {
        return new Notice(false, "", title, content);
    }

    public NoticeDto.CreateResDto toCreateResDto() {
        return NoticeDto.CreateResDto.builder().id(getId()).build();
    }
}
