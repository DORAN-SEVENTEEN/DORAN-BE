package com.seventeen.doran.service;

import com.seventeen.doran.dto.DiaryDto;
import com.seventeen.doran.entity.Diary;
import com.seventeen.doran.repository.DiaryRepository;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import java.util.Optional;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;


@RequiredArgsConstructor
@Service
public class DiaryService {

  private final DiaryRepository diaryRepository;

  public void createDiary(LocalDateTime date, String text, String iconUrl) {
  }

  @Transactional
  public List<Diary> readDiariesDay(LocalDateTime date) {
    return diaryRepository.findAllByDate(date);
  }
  @Transactional
  public List<Diary> readDiariesMonth(LocalDateTime startDate, LocalDateTime endDate) {
    return diaryRepository.findAllByDateBetween(startDate, endDate);
  }


  public void updateDiary(@PathVariable Long id, @RequestBody DiaryDto diaryDto) {

    Optional<Diary> diary = diaryRepository.findById(id);
    if(diary.isPresent()) {
      diary.get().setDate(diaryDto.getDate());
      diary.get().setContents(diaryDto.getContents());
      diary.get().setIconUrl(diaryDto.getIconUrl());
      diaryRepository.save(diary.get());
    }
  }
  public void deleteDiary(Long id) {

    diaryRepository.deleteById(id);

  }
}