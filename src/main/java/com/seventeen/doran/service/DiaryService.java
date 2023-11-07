package com.seventeen.doran.service;

import com.seventeen.doran.dto.ContentsDto;
import com.seventeen.doran.dto.ContentsResultDto;
import com.seventeen.doran.dto.DiaryUpdateDto;
import com.seventeen.doran.entity.Diary;
import com.seventeen.doran.repository.DiaryRepository;

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

  public void createIcon(DiaryUpdateDto diaryUpdateDto) {
    Diary diary = diaryRepository.save(diaryUpdateDto.toEntity());
  }

  //기존 아이콘에 일기 추가
  public void updateContents(@PathVariable Long id, @RequestBody ContentsDto contentsDto) {
    Optional<Diary> diary = diaryRepository.findById(id);
    if(diary.isPresent()) {
      diary.get().setContents(contentsDto.getContents());
      diaryRepository.save(diary.get());
    }
  }

  //기존 아이콘에 일기 + 결과 추가
  public void updateContentsResult(@PathVariable Long id, @RequestBody ContentsResultDto contentsResultDto) {
    Optional<Diary> diary = diaryRepository.findById(id);
    if(diary.isPresent()) {
      diary.get().setContents(contentsResultDto.getContents());
      diaryRepository.save(diary.get());
    }
  }


  public void updateDiary(@PathVariable Long id, @RequestBody DiaryUpdateDto diaryDto) {

    Optional<Diary> diary = diaryRepository.findById(id);
    if(diary.isPresent()) {
      diary.get().setDate(diaryDto.getDate());
      diary.get().setContents(diaryDto.getContents());
      diary.get().setIconUrl(diaryDto.getIconUrl());
      diaryRepository.save(diary.get());
    }
  }

  @Transactional
  public List<Diary> readDiariesDay(LocalDateTime date) {
    return diaryRepository.findAllByDate(date);
  }
  @Transactional
  public List<Diary> readDiariesMonth(LocalDateTime startDate, LocalDateTime endDate) {
    return diaryRepository.findAllByDateBetween(startDate, endDate);
  }
  public void deleteDiary(Long id) {

    diaryRepository.deleteById(id);

  }
}