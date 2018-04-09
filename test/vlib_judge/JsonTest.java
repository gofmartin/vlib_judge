package vlib_judge;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;

import org.junit.Test;

import vlib.entity.ByClass;
import vlib.entity.JudgeData;
import vlib.entity.JudgeDetail;

public class JsonTest {

	@Test
	public void test() {
		
		JudgeDetail judgeDetail = new JudgeDetail();
		//填入实验类型
		judgeDetail.setType("Java");
		//填入判分方式
		judgeDetail.setRule("ByClass");
		//数组方式生成判分细则
		List<JudgeData> data = new ArrayList<JudgeData>();
		for(int i=0; i<2; i++) {
			data.add(new ByClass("name"+i, "in"+i, "out"+i));
		}
		judgeDetail.setData(data);
		
		//转换为json字符串
		JSONObject jsonObject = JSONObject.fromObject(judgeDetail);
		System.out.println(jsonObject);
		
	}

}
