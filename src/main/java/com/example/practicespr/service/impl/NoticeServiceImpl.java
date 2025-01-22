package com.example.practicespr.service.impl;

import com.example.practicespr.domain.Notice;
import com.example.practicespr.repository.NoticeRepository;
import com.example.practicespr.service.NoticeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class NoticeServiceImpl implements NoticeService {
    private final NoticeRepository noticeRepository;

    public NoticeServiceImpl(NoticeRepository noticeRepository) {
        this.noticeRepository = noticeRepository;
    }

    @Override
    public Long create(Map<String, Object> params) {
        String title = params.get("title").toString();
        String content = params.get("content").toString();

        Notice notice = new Notice();
        notice.setTitle(title);
        notice.setContent(content);

        noticeRepository.save(notice);

        return notice.getId();  // DB에 생성되는 순간 생성된 id를 자바 Entity 에도 바로 전달되는가?
    }

    @Override
    public void update(Map<String, Object> params) {
        Notice notice = noticeRepository.findById(Long.valueOf(params.get("id").toString())).orElseThrow(()->new RuntimeException("No Notice"));
        notice.setTitle(params.get("title").toString());
        notice.setContent(params.get("content").toString());

        noticeRepository.save(notice);
    }

    @Override
    public void delete(Long id) {
        Notice notice = noticeRepository.findById(id).orElseThrow(()->new RuntimeException("No Notice"));
        noticeRepository.delete(notice);
    }

    @Override
    public Notice detail(Long id) {
        return noticeRepository.findById(id).orElseThrow(() -> new RuntimeException("Notice not found"));
    }

    @Override
    public List<Notice> list() {
        return noticeRepository.findAll();
    }
}
