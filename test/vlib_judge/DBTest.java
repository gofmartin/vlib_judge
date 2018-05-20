package vlib_judge;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;

import net.sf.json.JSONObject;
import oracle.net.aso.l;

import org.junit.Test;

import com.sun.org.apache.bcel.internal.generic.NEW;

import vlib.dao.impl.RulesDaoImpl;
import vlib.entity.ByClass;
import vlib.entity.FieldData;
import vlib.entity.JudgeData;
import vlib.entity.JudgeDetail;
import vlib.entity.MethodData;
import vlib.entity.ParamData;
import vlib.judger.JavaJudger;
import vlib.util.JsonUtil;

public class DBTest {

	@Test
	public void test() {
//		RulesDaoImpl rulesDaoImpl = new RulesDaoImpl();
//		JudgeDetail judgeDetail = new JudgeDetail();
//		judgeDetail.setType("java");
//		judgeDetail.setRule("class");
//
//		ArrayList<JudgeData> data = new ArrayList<JudgeData>();
//		
//			ByClass byClass = new ByClass();
//			byClass.setClassName("JavaProjJudger");
//			byClass.setClassVisibility("public");
//			byClass.setFieldList(null);
//			
//				ArrayList<MethodData> methodList = new ArrayList<MethodData>();
//		
//					MethodData methodData = new MethodData();
//					methodData.setMethodName("judgeJavaProj");
//					methodData.setVisibility("public");
//					methodData.setReturnType(null);
//					
//						ArrayList<ParamData> paramList = new ArrayList<ParamData>();
//					
//						ParamData paramData1 = new ParamData();
//						paramData1.setType("String");
//						paramData1.setTestData(new File("D:/test/proj/bin"));
//						paramList.add(paramData1);
//						
//						ParamData paramData2 = new ParamData();
//						paramData2.setType("Integer");
//						paramData2.setTestData(new Integer(1));
//						paramList.add(paramData2);
//						
//						ParamData paramData3 = new ParamData();
//						paramData3.setType("Integer");
//						paramData3.setTestData(new Integer(1));
//						paramList.add(paramData3);
//					
//					methodData.setParamList(paramList);
//					
//				methodList.add(methodData);
//
//			byClass.setMethodList(methodList);
//		
//		data.add(byClass);
//		judgeDetail.setData(data);
//		
//		String jsonstr = JsonUtil.JudgeDetailToJson(judgeDetail);
//		rulesDaoImpl.add(1, jsonstr);
		
		//param list
		ParamData paramData = new ParamData();
		paramData.setType("String");
		paramData.setTestData("Hello World");
		ArrayList<ParamData> paramList = new ArrayList<ParamData>();
		paramList.add(paramData);
		
		//method list
		MethodData methodData = new MethodData();
		methodData.setMethodName("StringEcho");
		methodData.setReturnType("void");
		methodData.setReturnObject(null);
		methodData.setParamList(paramList);
		ArrayList<MethodData> methodList = new ArrayList<MethodData>();
		methodList.add(methodData);
		
		//field list
		ArrayList<FieldData> fieldList = null;
		
		//class list
		ByClass byClass = new ByClass();
		byClass.setClassName("StringTest");
		byClass.setFieldList(fieldList);
		byClass.setMethodList(methodList);
		ArrayList<ByClass> classList = new ArrayList<ByClass>();
		classList.add(byClass);
		
		//JudgeDetail
		JudgeDetail judgeDetail = new JudgeDetail();
		judgeDetail.setType("java");
		judgeDetail.setRule("class");
		judgeDetail.setData(classList);
		
		JavaJudger javaJudger = new JavaJudger();
		System.out.println(javaJudger.GetTotalScore(judgeDetail));
		
//		String jsonstr = JSONObject.fromObject(judgeDetail).toString();
//		System.out.println(jsonstr);
		
//		RulesDaoImpl rulesDaoImpl = new RulesDaoImpl();
//		rulesDaoImpl.add(3, jsonstr);
	}
	
	@Test
	public void ReadJson() {
//		RulesDaoImpl rulesDaoImpl = new RulesDaoImpl();
//		String jsonstr = rulesDaoImpl.read(3);
//		System.out.println(jsonstr);
//		JudgeDetail judgeDetail = JsonUtil.jsonToJudgeDetail(jsonstr);
//		System.out.println(JsonUtil.JudgeDetailToJson(judgeDetail).toString());
//		
//		JavaJudger javaJudger = new JavaJudger();
//		javaJudger.GetTotalScore(judgeDetail);
	}

}
