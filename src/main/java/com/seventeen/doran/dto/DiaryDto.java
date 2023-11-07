package com.seventeen.doran.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class DiaryDto {

  private Long id;

  private LocalDateTime date;

  private String iconUrl;

  private String contents;

  private String resultUrl;

}
