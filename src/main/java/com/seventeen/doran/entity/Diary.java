package com.seventeen.doran.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.Chronology;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "diary")
@Entity
public class Diary {

  @Id
  @Column(name = "idx")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long diaryIdx;
  private LocalDate date;
  private String iconUrl;
  private String contents;
  @OneToOne(mappedBy = "diary")
  private Image resultUrl;

  @Builder
  public Diary (LocalDate date, String iconUrl, String contents, Image resultUrl) {
    this.date = date;
    this.iconUrl = iconUrl;
    this.contents = contents;
    this.resultUrl = resultUrl;
  }

  public long getId() {
    return diaryIdx;
  }
}
