package vlib.util;

import net.sf.json.JSONObject;
import vlib.entity.JudgeDetail;

public class JsonUtil {
	
	public static String JudgeDetailToJson(JudgeDetail detail) {
		
		JSONObject jsonObject = JSONObject.fromObject(detail);
		
		return jsonObject.toString();
	}
	
	public static JudgeDetail jsonToJudgeDetail(String jsonstr) {
		JSONObject jsonObject = JSONObject.fromObject(jsonstr);
		JudgeDetail judgeDetail = (JudgeDetail) JSONObject.toBean(jsonObject, JudgeDetail.class);
		
		return judgeDetail;
	}
	
}
