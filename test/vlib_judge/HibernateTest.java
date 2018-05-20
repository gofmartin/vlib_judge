package vlib_judge;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import vlib.dao.impl.RulesDaoImpl;
import vlib.entity.ByClass;
import vlib.entity.FieldData;
import vlib.entity.JudgeDetail;
import vlib.entity.MethodData;
import vlib.entity.ParamData;

public class HibernateTest {
	
	@Test
	public void test() {
		//save test
//		RulesDaoImpl rulesDaoImpl = new RulesDaoImpl();
//		rulesDaoImpl.add(generateJudgeDetail());
		//**********
		//read test
		RulesDaoImpl rulesDaoImpl = new RulesDaoImpl();
		JudgeDetail judgeDetail = rulesDaoImpl.read(11);
		System.out.println(judgeDetail.getData().get(0).getMethodList().get(0).getReturnType());
		//**********
	}
	
private JudgeDetail generateJudgeDetail() {
		
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
		byClass.setFieldList(fieldList);
		byClass.setMethodList(methodList);
		ArrayList<ByClass> classList = new ArrayList<ByClass>();
		classList.add(byClass);
		
		//JudgeDetail
		JudgeDetail judgeDetail = new JudgeDetail();
		judgeDetail.setExpid(11);
		judgeDetail.setType("java");
		judgeDetail.setRule("class");
		judgeDetail.setData(classList);
		
		return judgeDetail;
	}

}
