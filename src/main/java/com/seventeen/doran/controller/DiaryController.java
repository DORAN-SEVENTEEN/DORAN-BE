package com.seventeen.doran.controller;

import com.seventeen.doran.dto.ContentsDto;
import com.seventeen.doran.dto.DiaryUpdateDto;
import com.seventeen.doran.dto.ResultDto;
import com.seventeen.doran.entity.Diary;
import com.seventeen.doran.service.DiaryService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class DiaryController {

  private final DiaryService diaryService;

  @ApiOperation(value="DB에 아이콘 저장하면서 id 생성")
  @PostMapping("/create/icon")
  long createIcon(@RequestBody DiaryUpdateDto diaryUpdateDto) {
    long diaryId = diaryService.createIcon(diaryUpdateDto);
    return diaryId;
  }

  @ResponseStatus(HttpStatus.OK)
  @ApiOperation(value="해당 id에 일기 추가")
  @PutMapping("/update/contents")
  void updateContents(@RequestBody ContentsDto contentsDto) {
    diaryService.updateContents(contentsDto);
  }

  @ResponseStatus(HttpStatus.OK)
  @ApiOperation(value="해당 id에 결과 추가")
  @PutMapping("/update/result")
  void updateResult(@RequestBody ResultDto ResultDto) {

    diaryService.updateResult(ResultDto);
  }

  @ApiOperation(value="선택한 id에 따른 일기 내용을 가져옴")
  @GetMapping("/read/diary/{id}")
  Optional<Diary> readDiary(@PathVariable Long id) {

    return diaryService.readDiary(id);
  }

  @ApiOperation(value="선택한 날의 모든 일기 데이터를 가져옴")
  @GetMapping("/read/diaries-day")
  List<Diary> readDiariesDay(@RequestParam @DateTimeFormat(iso = ISO.DATE) @ApiParam(value="날짜 형식 : yyyy-MM-dd", example="2023-10-23") LocalDate date) {

    return diaryService.readDiariesDay(date);
  }

  @ApiOperation(value="모든 일기 데이터를 가져옴")
  @GetMapping("/read/diaries")
  List<Diary> readDiaries() {

    return diaryService.readDiaries();
  }

  @ApiOperation(value="선택한 일기를 삭제")
  @DeleteMapping("/delete/diary")
  void deleteDiary(@RequestParam Long id) {
    diaryService.deleteDiary(id);
  }

}