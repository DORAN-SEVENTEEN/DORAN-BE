package com.seventeen.doran.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Diary {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private LocalDate date;

  private String iconUrl;

  private String contents;

  private String resultUrl;

  @Builder
  public Diary (LocalDate date, String iconUrl, String contents, String resultUrl) {
    this.date = date;
    this.iconUrl = iconUrl;
    this.contents = contents;
    this.resultUrl = resultUrl;
  }

  public long getId() {
    return id;
  }
}
