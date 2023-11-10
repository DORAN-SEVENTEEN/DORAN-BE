package com.seventeen.doran.repository;

import com.seventeen.doran.entity.Diary;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
public interface DiaryRepository extends JpaRepository<Diary, Long>{


  //날짜 값으로 (해당 일자 클릭) 내용 조회하기 -> get 사용
  List<Diary> findAllByDate(LocalDate date);

  //일기 id 값으로 (해당 일자 클릭) 내용 삭제하기 - delete 사용
  @Transactional
  void deleteById(Long id);

}