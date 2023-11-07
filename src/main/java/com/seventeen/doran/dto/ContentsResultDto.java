package com.seventeen.doran.dto;

import com.seventeen.doran.entity.Diary;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
public class ContentsResultDto {

    private String contents;
    private String resultUrl;

    @Builder
    public Diary toEntity() {
        return Diary.builder()
                .contents(contents)
                .resultUrl(resultUrl)
                .build();
    }
}
