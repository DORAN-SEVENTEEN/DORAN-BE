package com.seventeen.doran.dto;

import java.time.LocalDateTime;

import com.seventeen.doran.entity.Diary;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class DiaryUpdateDto {

  private LocalDateTime date;
  private String iconUrl;
  private String contents;

  @Builder
  public Diary toEntity() {
    return Diary.builder()
            .date(date)
            .iconUrl(iconUrl)
            .contents(contents)
            .build();
  }
}
