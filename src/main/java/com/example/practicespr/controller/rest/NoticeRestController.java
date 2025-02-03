package com.example.practicespr.controller.rest;

import com.example.practicespr.domain.Notice;
import com.example.practicespr.dto.NoticeDto;
import com.example.practicespr.service.NoticeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<NoticeDto.CreateResDto> create(@RequestBody NoticeDto.CreateReqDto params) {
        //return ResponseEntity.status(HttpStatus.CREATED).body(noticeService.create(params));
        return ResponseEntity.ok(noticeService.create(params));
    }
    @PutMapping("")
    public ResponseEntity<Void> update(@RequestBody NoticeDto.UpdateReqDto params) {
        noticeService.update(params);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @DeleteMapping("")
    public ResponseEntity<Void> delete(@RequestBody NoticeDto.UpdateReqDto params) {
        noticeService.delete(params);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @GetMapping("")
    public ResponseEntity<NoticeDto.DetailResDto> detail(NoticeDto.DetailReqDto params) {
        return ResponseEntity.ok(noticeService.detail(params));
    }
    @GetMapping("/list")
    public ResponseEntity<List<NoticeDto.DetailResDto>> list() {
        return ResponseEntity.ok(noticeService.list());
    }
}
