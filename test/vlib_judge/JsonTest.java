package vlib_judge;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;

import org.junit.Test;

import vlib.entity.ByClass;
import vlib.entity.FieldData;
import vlib.entity.JudgeData;
import vlib.entity.JudgeDetail;
import vlib.entity.MethodData;
import vlib.util.JsonUtil;

public class JsonTest {

	@Test
	public void test() {
		
		JudgeDetail judgeDetail = new JudgeDetail();
		//填入实验类型
		judgeDetail.setType("Java");
		//填入判分方式
		judgeDetail.setRule("ByClass");
		//数组方式生成判分细则
		List<ByClass> data = new ArrayList<ByClass>();
		for(int i=0; i<2; i++) {
			ByClass class1 = new ByClass();
			class1.setClassName("123");
			class1.setFieldList(new ArrayList<FieldData>());
			class1.setMethodList(new ArrayList<MethodData>());
		}
		judgeDetail.setData(data);
		
		//转换为json字符串
		JSONObject jsonObject = JSONObject.fromObject(judgeDetail);
		System.out.println(jsonObject);
		JSONObject jsonObject2 = JSONObject.fromObject(jsonObject.toString());
		JudgeDetail judgeDetail2 = (JudgeDetail) JSONObject.toBean(jsonObject2, JudgeDetail.class);
//		JudgeDetail judgeDetail2 = JsonUtil.jsonToJudgeDetail(jsonObject.toString());
		System.out.println(judgeDetail2.getData().get(0).getClassName());
	}

}
