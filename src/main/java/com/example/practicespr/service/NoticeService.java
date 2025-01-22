package com.example.practicespr.service;

import com.example.practicespr.domain.Notice;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface NoticeService {
    Long create(Map<String, Object> params);
    void update(Map<String, Object> params);
    void delete(Long id);
    Notice detail(Long id);
    List<Notice> list();
}
