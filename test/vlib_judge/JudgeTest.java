package vlib_judge;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.sun.org.apache.bcel.internal.generic.NEW;

import vlib.entity.ByClass;
import vlib.entity.FieldData;
import vlib.entity.JudgeData;
import vlib.entity.JudgeDetail;
import vlib.entity.JudgeResult;
import vlib.entity.MethodData;
import vlib.entity.ParamData;
import vlib.judger.JavaJudger;

public class JudgeTest {

	@Test
	public void test() {
		JavaJudger javaJudger = new JavaJudger();
		JudgeResult judgeResult = null;
		try {
			judgeResult = javaJudger.judge("D:/wmy/JavaWorkSpace/Test/bin", getTestJudgeDetail());
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("TotalScore:"+judgeResult.getTotalScore());
		System.out.println("Score:"+judgeResult.getScore());
		System.out.println("Detail:"+judgeResult.getJudgeDetail());
	}
	
	private JudgeDetail getTestJudgeDetail() {
		
		ParamData paramData = new ParamData();
		paramData.setType("String");
		paramData.setTestData("Hello World");
		ArrayList<ParamData> paramList = new ArrayList<ParamData>();
		paramList.add(paramData);
		
		//method list
		MethodData methodData = new MethodData();
		methodData.setMethodName("StringEcho");
		methodData.setReturnType("String");
		methodData.setReturnObject(new String("Hello World"));
		methodData.setParamList(paramList);
		ArrayList<MethodData> methodList = new ArrayList<MethodData>();
		methodList.add(methodData);
		
		//field list
		FieldData fieldData1 = new FieldData();
		fieldData1.setName("hello");
		fieldData1.setType("int");
		FieldData fieldData2 = new FieldData();
		fieldData2.setName("helloWorld");
		fieldData2.setType("String");
		ArrayList<FieldData> fieldList = new ArrayList<FieldData>();
		fieldList.add(fieldData1);
		fieldList.add(fieldData2);
		
		//class list
		ByClass byClass = new ByClass();
		byClass.setClassName("StringTest");
		byClass.setClassVisibility("public");
		byClass.setFieldList(fieldList);
		byClass.setMethodList(methodList);
		ArrayList<JudgeData> classList = new ArrayList<JudgeData>();
		classList.add(byClass);
		
		//JudgeDetail
		JudgeDetail judgeDetail = new JudgeDetail();
		judgeDetail.setType("java");
		judgeDetail.setRule("class");
		judgeDetail.setData(classList);
		
		return judgeDetail;
	}

}
