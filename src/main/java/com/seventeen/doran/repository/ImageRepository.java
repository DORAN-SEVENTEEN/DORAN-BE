package com.seventeen.doran.repository;

import com.seventeen.doran.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {

    Image findByDiary_DiaryIdx(long idx);


}
