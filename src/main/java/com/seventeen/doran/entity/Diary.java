package com.seventeen.doran.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.*;

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
  @Column
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @Column
  private LocalDate date;
  @Column
  private String iconUrl;
  @Column
  private String contents;
  @Column(length = 65535)
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
