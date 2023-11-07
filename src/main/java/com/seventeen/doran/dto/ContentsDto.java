package com.seventeen.doran.dto;

import com.seventeen.doran.entity.Diary;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ContentsDto {
    private String contents;

    @Builder
    public Diary toEntity() {
        return Diary.builder()
                .contents(contents)
                .build();
    }
}
