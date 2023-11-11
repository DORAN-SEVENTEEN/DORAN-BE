package com.seventeen.doran.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;


@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "diary")
@Getter
@Entity
public class Diary {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long diaryIdx;

    private LocalDate date;

    private String iconUrl;

    private String contents;

    private String resultUrl;


    @Builder
    public Diary(LocalDate date, String iconUrl, String contents, String resultUrl) {
        this.date = date;
        this.iconUrl = iconUrl;
        this.contents = contents;
        this.resultUrl = resultUrl;
    }

    public long getId() {
        return diaryIdx;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public void setResultUrl(String resultUrl) {
        this.resultUrl = resultUrl;
    }

}
