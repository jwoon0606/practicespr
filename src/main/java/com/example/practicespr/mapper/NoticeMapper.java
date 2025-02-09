package com.example.practicespr.mapper;

import com.example.practicespr.dto.NoticeDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NoticeMapper {
    NoticeDto.DetailResDto detail(NoticeDto.DetailReqDto param);
    List<NoticeDto.DetailResDto> list(NoticeDto.ListReqDto params);

    int pagedListCount(NoticeDto.PagedListReqDto params);
    List<NoticeDto.DetailResDto> pagedList(NoticeDto.PagedListReqDto params);
    List<NoticeDto.DetailResDto> scrollList(NoticeDto.ScrollListReqDto params);
}
