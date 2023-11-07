package com.seventeen.doran.service;

import com.seventeen.doran.dto.DiaryDto;
import com.seventeen.doran.entity.Diary;
import com.seventeen.doran.repository.DiaryRepository;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class DiaryService {

  private final DiaryRepository diaryRepository;

  public void createDiary(LocalDateTime date, String text, String iconUrl) {
  }

  public List<Diary> readDiariesDay(LocalDateTime date) {

    return null;
  }

  public List<Diary> readDiariesMonth(LocalDateTime startDate, LocalDateTime endDate) {

    return null;
  }



  public void updateDiary(Long id) {

  }

  public void deleteDiary(LocalDate date) {
  }


}