package com.test.secu.common.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ChatVO {
	private String name;
	private String msg;
	private String errMsg;
	private String targetName;
}
