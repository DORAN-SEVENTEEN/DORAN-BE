package com.seventeen.doran.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "diary_idx", referencedColumnName = "idx")
    private Diary diary;
    @Lob
    private String imageBinaryData;

}
