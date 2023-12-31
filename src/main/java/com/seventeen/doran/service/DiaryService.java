package com.seventeen.doran.service;

import com.seventeen.doran.dto.ContentsDto;
import com.seventeen.doran.dto.DiaryUpdateDto;
import com.seventeen.doran.dto.ResultDto;
import com.seventeen.doran.entity.Diary;
import com.seventeen.doran.repository.DiaryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@Service
public class DiaryService {

  private final DiaryRepository diaryRepository;

  @Transactional
  public long createIcon(DiaryUpdateDto diaryUpdateDto) {
    Diary diary = diaryRepository.save(diaryUpdateDto.toEntity());
    return diary.getId();
  }

  //기존 아이콘에 일기 추가
  @Transactional
  public void updateContents(@RequestBody ContentsDto contentsDto) {
    Optional<Diary> diary = diaryRepository.findById(contentsDto.getId());
    if(diary.isPresent()) {
      diary.get().setContents(contentsDto.getContents());
    }
  }

  //기존 아이콘에 결과 추가
  @Transactional
  public void updateResult(@RequestBody ResultDto resultDto) {
    Optional<Diary> diary = diaryRepository.findById(resultDto.getId());
    if(diary.isPresent()) {
      diary.get().setResultUrl(resultDto.getResultUrl());
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

  //저장한 모든 일기 내용 읽기
  @Transactional(readOnly = true)
  public List<Diary> readDiaries() {
    return diaryRepository.findAll();
  }

  @Transactional
  // 일기 삭제하기
  public void deleteDiary(Long id) {
    // CREATE / UPDATE / DELETE 에서는 전체적으로 findById를 하고 없으면 throw Exception 처리를 해주는 것이 좋습니다.
    diaryRepository.deleteById(id);
  }
}