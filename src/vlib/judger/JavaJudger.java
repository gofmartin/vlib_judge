package vlib.judger;

import java.io.File;
import java.io.FileFilter;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import vlib.entity.ByClass;
import vlib.entity.FieldData;
import vlib.entity.JudgeData;
import vlib.entity.JudgeDetail;
import vlib.entity.JudgeResult;
import vlib.entity.MethodData;
import vlib.entity.ParamData;
import vlib.util.Utils;

public class JavaJudger {
	
public JudgeResult judge(String FilePath, JudgeDetail detail) throws NoSuchMethodException, SecurityException, ClassNotFoundException {
		
		ArrayList<Class> clazzList = (ArrayList<Class>) Utils.classLoader(FilePath);
		JudgeResult judgeResult = new JudgeResult();
		
		//遍历类列表
		if(clazzList == null) {
			return judgeResult;
		}
		for(Class clazz : clazzList) {
			//类名
			System.out.println("className:" + clazz.getName());
			//可见性 无法实现
			
			//变量
			System.out.println("FieldList:");
			if(clazz.getFields() != null) {
				for(Field f : clazz.getDeclaredFields()) {
					//变量名
					System.out.println("  FieldName:" + f.getName());
					//变量类型
					System.out.println("  FieldType:" + f.getType().getName());
				}
			} else {
				System.out.println("none");
			}
			
			//
			System.out.println("MethodList:");
			if(clazz.getMethods() != null) {
				for(Method m : clazz.getDeclaredMethods()) {
					//方法名
					System.out.println("  MethodName:" + m.getName());
					//方法返回值类型
					System.out.println("  MethodReturnType:" + m.getReturnType().getName());
					//参数列表
					System.out.println("  ParamTypeList:");
					for(Class p : m.getParameterTypes()) {
						//参数类型
						System.out.println("    paramType:" + p.getName());
					}
				}
			} else {
				System.out.println("none");
			}
		}
		
		return judgeResult;
	}
	
//	public JudgeResult judge(String FilePath, JudgeDetail detail) throws NoSuchMethodException, SecurityException, ClassNotFoundException {
//		
//		ArrayList<Class> clazzList = (ArrayList<Class>) Utils.classLoader(FilePath);
//		if(detail.getRule().equalsIgnoreCase("class")) {
//			//根据类判定
//			//ArrayList<JudgeData> clazzRules = (ArrayList<JudgeData>) detail.getData();
//			for(JudgeData clazzRule : detail.getData()) {
//				//获取一个类的判分项
//				ByClass judgeClass = (ByClass) clazzRule;
//				//查找有没有相同的类名
//				for(Class c : clazzList) {
//					if(judgeClass.getClassName().equalsIgnoreCase(c.getName())) {
//						
//						//遍历变量列表
//						for(FieldData fd : judgeClass.fieldList) {
//							try {
//								
//								Field f = c.getDeclaredField(fd.getName());
//								//尝试获取变量类型
//								
//							} catch (Exception e) {
//								System.out.println("no such field--"+fd.getName());
//							}
//						}
//						
//						//遍历方法列表
//						
//						break;
//					}
//				}
//			}
//		}
//		else if(detail.rule.equalsIgnoreCase("inandout")) {
//			//根据输入输出判定
//		}
//		
//		return null;
//	}
	
	public int GetTotalScore(JudgeDetail judgeDetail) {
		int TotalScore = 0;
		
		ArrayList<JudgeData> datas = (ArrayList<JudgeData>) judgeDetail.getData();
		if(datas != null) {
			for(JudgeData clazzdata : datas) {
				ByClass clzz = (ByClass) clazzdata;
				//类名
				System.out.println("className:"+clzz.getClassName());
				TotalScore ++;
				//类可见性
				System.out.println("classVisibility:" + clzz.getClassVisibility());
				TotalScore ++;
				
				if(clzz.getFieldList() != null) {
					for(FieldData fd : clzz.getFieldList()) {
						//变量名
						System.out.println("  fieldName:" + fd.getName());
						TotalScore ++;
						//变量可见性
						System.out.println("  fieldVisibility:" + fd.getVisibility());
						TotalScore ++;
						//变量类型
						System.out.println("  fieldType:" + fd.getType());
						TotalScore ++;
					}
				}
				if(clzz.getMethodList() != null) {
					for(MethodData md : clzz.getMethodList()) {
						//方法名
						System.out.println("  methodName:" + md.getMethodName());
						TotalScore ++;
						//返回值类型
						System.out.println("  methodReturnType:" + md.getReturnType());
						TotalScore ++;
						//方法可见性
						System.out.println("  methodVisibility:" + md.getVisibility());
						TotalScore ++;
						
						if(md.getParamList() != null) {
							for(ParamData pd : md.getParamList()) {
								//参数类型
								System.out.println("    paramType:" + pd.getType());
								TotalScore ++;
								//参数数据
								System.out.println("    paramData:" + pd.getTestData());
								TotalScore ++;
							}
						}
					}
				}
			}
		}
		
		return TotalScore;
	}
	
}
