package com.hg.smart.ivr.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by litong on 2018/4/7 0007.
 */
/*
{
	"calleeid": "8888abc",		//被叫号码
	"callerid": "abc",			//主叫号码
	"callid": "1fe74812-e376-4319-b335-3de1b494325c", //每个通话的唯一ID
	"errorcode": 0,				//错误代码
	"flowdata": null,			//流程数据
	"flowid": "abc",			//流程ID
	"notify": "enter"			//通知类型
}
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FirstSession {
    public String calleeid,callerid,callid,errorcode,flowdata,flowid,notify;
}
