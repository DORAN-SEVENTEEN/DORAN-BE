package com.seventeen.doran.controller;

import com.seventeen.doran.dto.ContentsDto;
import com.seventeen.doran.dto.DiaryUpdateDto;
import com.seventeen.doran.dto.ResultDto;
import com.seventeen.doran.entity.Diary;
import com.seventeen.doran.entity.Image;
import com.seventeen.doran.repository.DiaryRepository;
import com.seventeen.doran.repository.ImageRepository;
import com.seventeen.doran.service.DiaryService;
import com.seventeen.doran.service.ImageService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

@RequiredArgsConstructor
@RestController
public class DiaryController {

  private final DiaryService diaryService;
  private final ImageRepository imageRepository;
  private final DiaryRepository diaryRepository;
  private final ImageService imageService;

  @CrossOrigin("*")
  @ApiOperation(value="DB에 아이콘 저장하면서 id 생성")
  @PostMapping("/create/icon")
  long createIcon(@RequestBody DiaryUpdateDto diaryUpdateDto) {
    long diaryId = diaryService.createIcon(diaryUpdateDto);
    return diaryId;
  }

  @CrossOrigin("*")
  @ResponseStatus(HttpStatus.OK)
  @ApiOperation(value="해당 id에 일기 추가")
  @PutMapping("/update/contents")
  void updateContents(@RequestBody ContentsDto contentsDto) {
    diaryService.updateContents(contentsDto);
  }

//  @CrossOrigin
//  @ResponseStatus(HttpStatus.OK)
//  @ApiOperation(value="해당 id에 결과 추가")
//  @PutMapping("/update/result")
//  void updateResult(@RequestBody ResultDto resultDto) {
//    diaryService.updateResult(resultDto);
//  }
//  @CrossOrigin
//  @PostMapping("/update/result/{id}")
//  public String postImage(@PathVariable Long id, @RequestPart("image") MultipartFile image, Model model)
//          throws Exception {
//    Diary diary = diaryRepository.findById(id).get();
//    Image imageEntity = new Image();
//    imageEntity.setDiary(diary);
//    imageEntity.setImageBinaryData(image);
//    imageRepository.save(imageEntity);
////    model.addAttribute("imageBinary", "data:image/gif;base64," + image);
//    return "image";
//  }
//
//
//  @CrossOrigin
//  @GetMapping("image")
//  public ResponseEntity<?> getResultImage(@PathVariable Long id, Model model) {
//    Optional<Image> image = Optional.ofNullable(imageRepository.findByDiary_DiaryIdx(id));
//    if (image.isPresent()) {
//      model.addAttribute("imageBinary", "data:image/gif;base64," + image.get().getImageBinaryData());
//    }
//    return new ResponseEntity<>(image, HttpStatus.OK);
//  }
//
////  @CrossOrigin
//  public String convertBinary(MultipartFile files) throws Exception {
//    String fileName = StringUtils.cleanPath(files.getOriginalFilename());
//    BufferedImage image = ImageIO.read(files.getInputStream());
//    ByteArrayOutputStream baos = new ByteArrayOutputStream();
//    ImageIO.write(image, fileName.substring(fileName.lastIndexOf(".") + 1), baos);
//    return new String(Base64.encodeBase64(baos.toByteArray(), true));
//  }

  @CrossOrigin("*")
  @PostMapping("/update/result/{id}")
  public String uploadFile(@PathVariable Long id, @RequestParam("image") MultipartFile image) throws IOException {
    Diary diary = diaryRepository.findById(id).get();
    imageService.saveImage(diary, image);
    return "redirect:/";
  }

  @CrossOrigin("*")
  @ApiOperation(value="선택한 id에 따른 일기 내용을 가져옴")
  @GetMapping("/read/diary/{id}")
  Optional<Diary> readDiary(@PathVariable Long id) {

    return diaryService.readDiary(id);
  }

  @CrossOrigin
  @ApiOperation(value="선택한 날의 모든 일기 데이터를 가져옴")
  @GetMapping("/read/diaries-day")
  List<Diary> readDiariesDay(@RequestParam @DateTimeFormat(iso = ISO.DATE) @ApiParam(value="날짜 형식 : yyyy-MM-dd", example="2023-10-23") LocalDate date) {
    return diaryService.readDiariesDay(date);
  }

  @CrossOrigin("*")
  @ApiOperation(value="모든 일기 데이터를 가져옴")
  @GetMapping("/read/diaries")
  List<Diary> readDiaries() {
    return diaryService.readDiaries();
  }

  @CrossOrigin("*")
  @ApiOperation(value="선택한 일기를 삭제")
  @DeleteMapping("/delete/diary")
  void deleteDiary(@RequestParam Long id) {
    diaryService.deleteDiary(id);
  }

}