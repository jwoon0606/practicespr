package com.example.practicespr.service;

import com.example.practicespr.domain.Notice;
import com.example.practicespr.dto.NoticeDto;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface NoticeService {
    NoticeDto.CreateResDto create(NoticeDto.CreateReqDto params);
    void update(NoticeDto.UpdateReqDto params);
    void delete(NoticeDto.UpdateReqDto params);
    NoticeDto.DetailResDto detail(NoticeDto.DetailReqDto params);
    List<NoticeDto.DetailResDto> list();
}
