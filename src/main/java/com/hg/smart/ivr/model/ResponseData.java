package com.hg.smart.ivr.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by litong on 2018/4/7 0007.
 */
/*
{
	"action": "start_asr",			//第一个动作 start_asr是一个异步函数，只需要执行一次，启动后会一直进行VAD和ASR，直到调用sotp_asr
	"flowdata": "流程选择",			//流程数据，类似浏览器的Cookie,机器人后续httpapi请求会把这个数据发送回来。
	"params": {
		"min_speak_ms": 100,		//最小说话时间，默认值100，单位毫秒，说话时间小于这个值，会被认为是无效声音。
		"max_speak_ms": 10000,		//最大说话时间，默认值10000，单位毫秒，说话时间超过这个值，就停止录音，直接提交ASR服务器识别。
		"min_pause_ms": 300,		//最小停顿时间，默认值300，单位毫秒，默认值用户停顿时间超过这个值，会提交到ASR识别。识别完成后发送asrprogress事件。 完成后的意思是 ASR服务器可能 300-800ms才返回识别接口。
		"max_pause_ms": 600,		//最大停顿时间，默认值600，单位毫秒，用户停顿时间超过这个值，认为一句话说完，所有识别完成后发送asrmessage事件。所有识别完成后的意思是，所有提交到asr服务器的识别结果都返回了。 注意 min_pause_ms 必须大于min_pause_ms。
		"pause_play_ms": 200,		//触发暂停放音时间，默认值0：就是禁用自动暂停，单位毫秒，建议设置200-1000，用户说话时间超过这个值，就暂停放音。 有时候用户一直持续说话，中间没停顿，所以还没提交到ASR服务器识别，不能使用关键词打断，可以先暂停放音。
		"threshold": 0,				//VAD阈值，默认0，建议不要设置，如果一定要设置，建议 2000以下的值。
		"recordpath": "",			//录音文件路径，如果不设置：就会使用配置文件中的路径，每天生成一个文件夹,如果设置了，就会使用这个参数中的目录，文件格式是 recordpath/被叫号码_Unique-ID_序号.wav
		"volume": 50				//音量标准化的值。0-100，0不使用音量标准化，其他值 音量把录音音量调整到这个值后，再提交ASR识别。
	},
	"after_action": "playback",
	"after_ignore_error": false,	//如果action动作（start_asr）执行失败是否继续执行after_action（playback）。
	"after_params": {
		"prompt": "您好，欢迎致电顶顶通软件，这里是电话机器人演示系统，请说要进入的测试流程，比如，房产！",		//可以直接播放声音文件。规则就是如果最后4个字是.wav,就直接播放wav文件。
		"wait": 5000,				//单位毫秒，放音结束后等待时间。用于等待用户说话。
		"retry": 0					//重播次数。就是wait时间内用户不说话，就重新播放声音。
	}
}
 */
@Data
@AllArgsConstructor
public class ResponseData {
    private String action=Action.START_ASR;
    private String after_action=Action.PLAYBACK;
    private String flowdata="/";
    private Boolean after_ignore_error=false;
    private Params params=new Params();
    private AfterParams after_params=new AfterParams();
    //use singletom mode
    private ResponseData(){}
    // constrace a object for this class
    private static ResponseData rd=new ResponseData();

    //set prompt content
    public static synchronized ResponseData getInstance(String prompt){
        rd.getAfter_params().setPrompt(prompt);
        return rd;
    }
}

class Action {
    public static final String START_ASR="start_asr";
    public static final String PLAYBACK="playback";
}
@Data
@NoArgsConstructor
@AllArgsConstructor
class Params{
    private Integer min_speak_ms=100,max_speak_ms=1000,min_pause_ms=300,max_pause_ms=600;
    private Integer pause_play_ms=200,threshold=0,volume=50;
    private String recordpath="";
}
@Data
@NoArgsConstructor
@AllArgsConstructor
class AfterParams{
    private String prompt="hello,world";
    private Integer wait=5000,retry=0;
}