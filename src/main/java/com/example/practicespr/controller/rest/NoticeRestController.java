package com.example.practicespr.controller.rest;

import com.example.practicespr.domain.Notice;
import com.example.practicespr.service.NoticeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RequestMapping("/api/notice")
@RestController
public class NoticeRestController {
    private final NoticeService noticeService;

    public NoticeRestController(NoticeService noticeService) {
        this.noticeService = noticeService;
    }

    @PostMapping("")
    public Long create(@RequestBody Map<String,Object> params) {
        return noticeService.create(params);
    }

    @GetMapping("/list")
    public List<Notice> list() {
        return noticeService.list();
    }

    @GetMapping("")
    public Notice detail(@RequestParam Long id) {
        return noticeService.detail(id);
    }

    @PutMapping("")
    public void update(@RequestBody Map<String, Object> params) {
        noticeService.update(params);
    }

    @DeleteMapping("")
    public void delete(@RequestBody Long id) {
        noticeService.delete(id);
    }
}
