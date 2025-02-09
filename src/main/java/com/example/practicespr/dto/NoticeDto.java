package com.example.practicespr.dto;

import com.example.practicespr.domain.Notice;
import lombok.*;

public class NoticeDto {

    @Builder
    @Getter
    @Setter
    public static class CreateReqDto{
        private String title;
        private String content;

        public Notice toEntity(){
            return Notice.of(getTitle(), getContent());
        }
    }

    @Builder
    @Getter
    @Setter
    public static class CreateResDto{
        private Long id;
    }

    @Builder
    @Getter
    @Setter
    public static class UpdateReqDto{
        private Long id;
        private Boolean deleted;
        private String process;
        private String title;
        private String content;
    }

    @Builder
    @Getter
    @Setter
    public static class DetailReqDto{
        private Long id;
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Getter
    @Setter
    public static class DetailResDto{
        private Long id;
        private String createdAt;
        private String modifiedAt;
        private Boolean deleted;
        private String process;
        private String title;
        private String content;
    }

    @Builder
    @Getter
    @Setter
    public static class ListReqDto{
        private String orderby;
        private String orderway;
        private Boolean deleted;
        private String title;
    }

    @Builder
    @Getter
    @Setter
    public static class PagedListReqDto{
        private Integer offset;
        private Integer callpage;
        private Integer perpage;
        private String orderby;
        private String orderway;
        private Boolean deleted;
        private String title;
    }
    @Builder
    @Getter
    @Setter
    public static class PagedListResDto{
        private Object list;
        private Integer totalList;
        private Integer totalPage;
        private Integer callpage;
        private Integer perpage;
    }

    @Builder
    @Getter
    @Setter
    public static class ScrollListReqDto{
        private Long cursor;
        private String orderway;
        private Integer perpage;
        private Boolean deleted;
        private String title;
    }
}