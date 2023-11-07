package com.seventeen.doran.controller;

import com.seventeen.doran.dto.ContentsDto;
import com.seventeen.doran.dto.DiaryUpdateDto;
import com.seventeen.doran.dto.ResultDto;
import com.seventeen.doran.entity.Diary;
import com.seventeen.doran.service.DiaryService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

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


  @ApiOperation(value="DB에 아이콘 저장하면서 id 생성", notes = "세부 설명")
  @PostMapping("/create/icon")
  void createIcon(@RequestBody DiaryUpdateDto diaryUpdateDto) {
    diaryService.createIcon(diaryUpdateDto);
  }

  @ApiOperation(value="해당 id에 일기 추가", notes = "세부 설명")
  @PutMapping("/update/contents/{id}")
  void updateContents(@PathVariable Long id, @RequestBody ContentsDto contentsDto) {

    diaryService.updateContents(id, contentsDto);
  }

  @ApiOperation(value="해당 id에 결과 추가", notes = "세부 설명")
  @PutMapping("/update/result/{id}")
  void updateResult(@PathVariable Long id, @RequestBody ResultDto ResultDto) {

    diaryService.updateResult(id, ResultDto);
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
  void updateDiary(@PathVariable Long id, @RequestBody DiaryUpdateDto diaryUpdateDto) {

    diaryService.updateDiary(id, diaryUpdateDto);
  }

  @ApiOperation(value="선택한 일기를 삭제", notes = "세부 설명")
  @DeleteMapping("/delete/diary")
  void deleteDiary(@RequestParam Long id) {
    diaryService.deleteDiary(id);
  }

}