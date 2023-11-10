package com.seventeen.doran.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "diary_idx", referencedColumnName = "idx")
    private Diary diary;
    @Lob
    private String imageBinaryData;

    @Builder
    public Image (Diary diary, String imageBinaryData) {
        this.diary = diary;
        this.imageBinaryData = imageBinaryData;
    }

}
