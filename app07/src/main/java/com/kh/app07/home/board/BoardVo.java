package com.kh.app07.home.board;

import lombok.Data;

@Data
public class BoardVo {
    private String no;
    private String title;
    private String content;
    private String writerNo;
    private String createdDate;
    private String hit;
    private String delYn;
}
