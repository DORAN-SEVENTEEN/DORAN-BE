package com.seventeen.doran.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ContentsDto {
    private long id;
    private String contents;

    public long getId() {
        return id;
    }
}
