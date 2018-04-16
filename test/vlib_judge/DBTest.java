package vlib_judge;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;

import org.junit.Test;

import com.sun.org.apache.bcel.internal.generic.NEW;

import vlib.dao.impl.RulesDaoImpl;
import vlib.entity.ByClass;
import vlib.entity.JudgeData;
import vlib.entity.JudgeDetail;
import vlib.entity.MethodData;
import vlib.entity.ParamData;
import vlib.util.JsonUtil;

public class DBTest {

	@Test
	public void test() {
		RulesDaoImpl rulesDaoImpl = new RulesDaoImpl();
		JudgeDetail judgeDetail = new JudgeDetail();
		judgeDetail.setType("java");
		judgeDetail.setRule("class");

		ArrayList<JudgeData> data = new ArrayList<JudgeData>();
		
			ByClass byClass = new ByClass();
			byClass.setClassName("JavaProjJudger");
			byClass.setClassVisibility("public");
			byClass.setFieldList(null);
			
				ArrayList<MethodData> methodList = new ArrayList<MethodData>();
		
					MethodData methodData = new MethodData();
					methodData.setMethodName("judgeJavaProj");
					methodData.setVisibility("public");
					methodData.setReturnType(null);
					
						ArrayList<ParamData> paramList = new ArrayList<ParamData>();
					
						ParamData paramData1 = new ParamData();
						paramData1.setType("String");
						paramData1.setTestData(new File("D:/test/proj/bin"));
						paramList.add(paramData1);
						
						ParamData paramData2 = new ParamData();
						paramData2.setType("Integer");
						paramData2.setTestData(new Integer(1));
						paramList.add(paramData2);
						
						ParamData paramData3 = new ParamData();
						paramData3.setType("Integer");
						paramData3.setTestData(new Integer(1));
						paramList.add(paramData3);
					
					methodData.setParamList(paramList);
					
				methodList.add(methodData);

			byClass.setMethodList(methodList);
		
		data.add(byClass);
		judgeDetail.setData(data);
		
		String jsonstr = JsonUtil.JudgeDetailToJson(judgeDetail);
		rulesDaoImpl.add(1, jsonstr);
	}

}
