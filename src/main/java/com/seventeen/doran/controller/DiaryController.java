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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class DiaryController {

  private final DiaryService diaryService;


  @ApiOperation(value="DB에 아이콘 저장하면서 id 생성")
  @PostMapping("/create/icon")
  void createIcon(@RequestBody DiaryUpdateDto diaryUpdateDto) {
    diaryService.createIcon(diaryUpdateDto);
  }

  @ApiOperation(value="해당 id에 일기 추가")
  @PutMapping("/update/contents/{id}")
  void updateContents(@PathVariable Long id, @RequestBody ContentsDto contentsDto) {

    diaryService.updateContents(id, contentsDto);
  }

  @ApiOperation(value="해당 id에 결과 추가")
  @PutMapping("/update/result/{id}")
  void updateResult(@PathVariable Long id, @RequestBody ResultDto ResultDto) {

    diaryService.updateResult(id, ResultDto);
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

  @ApiOperation(value="선택한 달의 모든 일기 데이터를 가져옴")
  @GetMapping("/read/diaries-month")
  List<Diary> readDiariesMonth(@RequestParam @DateTimeFormat(iso = ISO.DATE) @ApiParam(value="날짜 형식 : yyyy-MM-dd", example="2023-10-01") LocalDate startDate,
                              @RequestParam @DateTimeFormat(iso = ISO.DATE) @ApiParam(value="날짜 형식 : yyyy-MM-dd", example="2023-10-30") LocalDate endDate) {

    return diaryService.readDiariesMonth(startDate, endDate);

  }

  @ApiOperation(value="선택한 일기의 내용을 변경")
  @PutMapping("/update/diary/{id}")
  void updateDiary(@PathVariable Long id, @RequestBody DiaryUpdateDto diaryUpdateDto) {

    diaryService.updateDiary(id, diaryUpdateDto);
  }

  @ApiOperation(value="선택한 일기를 삭제")
  @DeleteMapping("/delete/diary")
  void deleteDiary(@RequestParam Long id) {
    diaryService.deleteDiary(id);
  }

}