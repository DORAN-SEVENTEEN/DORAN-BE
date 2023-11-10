package com.seventeen.doran.service;

import com.seventeen.doran.entity.Diary;
import com.seventeen.doran.entity.Image;
import com.seventeen.doran.repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class ImageService {
    private final ImageRepository imageRepository;

    public Long saveImage(Diary diary, MultipartFile image) throws IOException {
        if (image.isEmpty()) {
            return null;
        }

        String origName = image.getOriginalFilename();
        String uuid = UUID.randomUUID().toString();
        String extension = origName.substring(origName.lastIndexOf("."));
        String savedName = uuid + extension;

        Image imageEntity = Image.builder()
                .diary(diary)
                .imageBinaryData(savedName)
                .build();

        Image savedImage = imageRepository.save(imageEntity);
        return savedImage.getId();
    }
}
