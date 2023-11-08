package com.seventeen.doran.service;

import com.seventeen.doran.dto.ContentsDto;
import com.seventeen.doran.dto.DiaryUpdateDto;
import com.seventeen.doran.dto.ResultDto;
import com.seventeen.doran.entity.Diary;
import com.seventeen.doran.repository.DiaryRepository;

import java.time.LocalDate;
import java.util.List;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
  public void updateResult(@PathVariable Long id, @RequestBody ResultDto ResultDto) {
    Optional<Diary> diary = diaryRepository.findById(id);
    if(diary.isPresent()) {
      diary.get().setResultUrl(ResultDto.getResult());
      diaryRepository.save(diary.get());
    }
  }

  //인덱스에 따른 일기 내용 읽기
  @Transactional(readOnly = true)
  public Optional<Diary> readDiary(Long id) {

    return diaryRepository.findById(id);
  }

  //날짜에 따른 일기 내용 읽기
  @Transactional(readOnly = true)
  public List<Diary> readDiariesDay(LocalDate date) {

    return diaryRepository.findAllByDate(date);
  }

  //기간(월)에 따른 일기 내용 읽기
  @Transactional(readOnly = true)
  public List<Diary> readDiariesMonth(LocalDate startDate, LocalDate endDate) {

    return diaryRepository.findAllByDateBetween(startDate, endDate);
  }

  // 일기 수정하기
  public void updateDiary(@PathVariable Long id, @RequestBody DiaryUpdateDto diaryDto) {

    Optional<Diary> diary = diaryRepository.findById(id);
    if(diary.isPresent()) {
      diary.get().setDate(diaryDto.getDate());
      diary.get().setContents(diaryDto.getContents());
      diary.get().setIconUrl(diaryDto.getIconUrl());
      diaryRepository.save(diary.get());
    }
  }

  // 일기 삭제하기
  public void deleteDiary(Long id) {

    diaryRepository.deleteById(id);
  }
}