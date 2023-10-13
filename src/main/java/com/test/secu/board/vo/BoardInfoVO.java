package com.test.secu.board.vo;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BoardInfoVO{
	private int biNum;
	private String biTitle;
	private String biContent;
	private int uiNum;
	private String uiName;
	private String biFilePath;
	private String biFileName;
	private MultipartFile file;
	private String cretim;
	private String credat;
	private String lmodat;
	private String lmotim;
	private int page;
	private int start;
	private int end;
	private int pageSize;

}