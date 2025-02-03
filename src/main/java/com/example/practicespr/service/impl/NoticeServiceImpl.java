package com.example.practicespr.service.impl;

import com.example.practicespr.domain.Notice;
import com.example.practicespr.dto.NoticeDto;
import com.example.practicespr.repository.NoticeRepository;
import com.example.practicespr.service.NoticeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NoticeServiceImpl implements NoticeService {

    private final NoticeRepository noticeRepository;
    public NoticeServiceImpl(NoticeRepository noticeRepository){
        this.noticeRepository = noticeRepository;
    }

    @Override
    public NoticeDto.CreateResDto create(NoticeDto.CreateReqDto params) {
        return noticeRepository.save(params.toEntity()).toCreateResDto();
    }

    @Override
    public void update(NoticeDto.UpdateReqDto params) {
        Notice notice = noticeRepository.findById(params.getId()).orElseThrow(() -> new RuntimeException("no data"));
        if(params.getDeleted() != null){ notice.setDeleted(params.getDeleted()); }
        if(params.getProcess() != null){ notice.setProcess(params.getProcess()); }
        if(params.getTitle() != null){ notice.setTitle(params.getTitle()); }
        if(params.getContent() != null){ notice.setContent(params.getContent()); }
        noticeRepository.save(notice);
    }

    @Override
    public void delete(NoticeDto.UpdateReqDto params) {
        params.setDeleted(true);
        update(params);
    }

    @Override
    public NoticeDto.DetailResDto detail(NoticeDto.DetailReqDto params) {
        Notice notice = noticeRepository.findById(params.getId())
                    .orElseThrow(() -> new RuntimeException("no data"));

        return NoticeDto.DetailResDto.builder()
                .id(notice.getId())
                .createdAt(notice.getCreatedAt().toString())
                .modifiedAt(notice.getModifiedAt().toString())
                .deleted(notice.getDeleted())
                .process(notice.getProcess())
                .title(notice.getTitle())
                .content(notice.getContent())
                .build();
        }

    @Override
    public List<NoticeDto.DetailResDto> list() {
        List<Notice> notices = noticeRepository.findAll();
        List<NoticeDto.DetailResDto> result = new ArrayList<>();

        for (Notice notice : notices) {
            NoticeDto.DetailResDto dto = NoticeDto.DetailResDto.builder()
                    .id(notice.getId())
                    .createdAt(notice.getCreatedAt().toString())
                    .modifiedAt(notice.getModifiedAt().toString())
                    .deleted(notice.getDeleted())
                    .process(notice.getProcess())
                    .title(notice.getTitle())
                    .content(notice.getContent())
                    .build();
            result.add(dto);
        }

        return result;
    }
}