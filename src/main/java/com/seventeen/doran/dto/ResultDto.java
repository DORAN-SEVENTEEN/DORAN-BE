package com.seventeen.doran.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResultDto {
    @Column
    private long id;
    @Column(length = 65535)
    private String result;

    public long getId() {
        return id;
    }
}
