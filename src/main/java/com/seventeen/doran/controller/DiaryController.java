package com.seventeen.doran.controller;

import com.seventeen.doran.dto.DiaryDto;
import com.seventeen.doran.entity.Diary;
import com.seventeen.doran.service.DiaryService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
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


  @ApiOperation(value="DB에 일기 저장", notes = "세부 설명")
  @PostMapping("/create/diary")
  void createDiary(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @ApiParam(value="날짜 형식 : yyyy-MM-dd", example="2023-10-23") LocalDateTime date,
      @RequestBody String contents, String icon_Url) {
    diaryService.createDiary(date, contents, icon_Url);
  }

  @ApiOperation(value="선택한 날의 모든 일기 데이터를 가져옴", notes = "세부 설명")
  @GetMapping("/read/diaries-day")
  List<Diary> readDiary(@RequestParam @DateTimeFormat(iso = ISO.DATE) @ApiParam(value="날짜 형식 : yyyy-MM-dd", example="2023-10-23") LocalDateTime date) {
    return diaryService.readDiariesDay(date);
  }

  @ApiOperation(value="선택한 달의 모든 일기 데이터를 가져옴", notes = "세부 설명")
  @GetMapping("/read/diaries-month")
  List<Diary> readDiaries(@RequestParam @DateTimeFormat(iso = ISO.DATE) @ApiParam(value="조회할 달의 1일", example="2023-11-01")LocalDateTime startDate,
      @RequestParam @DateTimeFormat(iso = ISO.DATE) @ApiParam(value="조회할 달의 마지막 일", example="2023-11-30")LocalDateTime endDate){
    return diaryService.readDiariesMonth(startDate, endDate);
  }

  @ApiOperation(value="선택한 일기의 내용을 변경", notes = "세부 설명")
  @PutMapping("/update/diary/{id}")
  void updateDiary(@PathVariable Long id, @RequestBody DiaryDto diaryDto) {

    diaryService.updateDiary(id, diaryDto);
  }

  @ApiOperation(value="선택한 일기를 삭제", notes = "세부 설명")
  @DeleteMapping("/delete/diary")
  void deleteDiary(@RequestParam Long id) {
    diaryService.deleteDiary(id);
  }

}