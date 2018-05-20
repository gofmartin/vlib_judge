package vlib.judger;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import oracle.net.aso.i;
import vlib.core.AdvancedJudger;
import vlib.dao.impl.RulesDaoImpl;
import vlib.entity.ByClass;
import vlib.entity.FieldData;
import vlib.entity.JudgeData;
import vlib.entity.JudgeDetail;
import vlib.entity.JudgeResult;
import vlib.entity.MethodData;
import vlib.entity.ParamData;
import vlib.util.Utils;

public class JavaJudger implements AdvancedJudger {
	
	public JudgeResult judgeJavaProj(String FilePath, int expid) {
		
		ArrayList<Class> clazzList = null;
		try {
			clazzList = (ArrayList<Class>) Utils.classLoader(FilePath);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		JudgeResult judgeResult = new JudgeResult();
		
		RulesDaoImpl rulesDaoImpl = new RulesDaoImpl();
		JudgeDetail detail = rulesDaoImpl.read(expid);
		
		//设置总分
		judgeResult.setTotalScore(GetTotalScore(detail));
		int score = 0;
		//遍历类规则列表
		for(JudgeData jd : detail.getData()) {
			//转换
			ByClass bc = (ByClass) jd;
			for(Class c : clazzList) {
				if(c.getName().toLowerCase().contains(bc.getClassName().toLowerCase())) {
					//same class name
					score++;
					//******test
					judgeResult.addJudgeDetail("类名相同：["+c.getName()+"]");
					//*****
					
					for(FieldData fd : bc.getFieldList()) {
						for(Field f : c.getDeclaredFields()) {
							if(f.getName().equalsIgnoreCase(fd.getName())) {
								score++;
								//*****test
								judgeResult.addJudgeDetail("变量类别相同：["+f.getName()+"]");
								//*****
							}
							if(f.getType().getName().toLowerCase().contains(fd.getType().toLowerCase())) {
								score++;
								//*****test
								judgeResult.addJudgeDetail("变量名相同：["+f.getType().getName()+"]");
								//*****
							}
						}
					}
					
					for(MethodData md : bc.getMethodList()) {
						for(Method m : c.getDeclaredMethods()) {
							if(m.getName().equalsIgnoreCase(md.getMethodName())) {
								score++;
								//*****test
								judgeResult.addJudgeDetail("方法名相同：["+m.getName()+"]");
								//*****
							}
							if(m.getReturnType().getName().toLowerCase().contains(md.getReturnType().toLowerCase())) {
								score++;
								//*****test
								judgeResult.addJudgeDetail("返回值类型相同：["+m.getReturnType().getName()+"]");
								//*****
							}
							
							Class[] ptl = m.getParameterTypes();
							if(ptl.length == md.getParamList().size()) {
								Object[] objs = new Object[ptl.length];
								int ptscore = 0;
								
								for(int i=0; i<ptl.length; i++) {
									if(ptl[i].getName().toLowerCase().contains(md.getParamList().get(i).getType().toLowerCase())) {
										ptscore++;
										//*****test
										judgeResult.addJudgeDetail("参数类型相同：["+ptl[i].getName()+"]");
										//*****
									}
									else
										break;
								}
								
								if(ptscore==ptl.length) {
									score += ptscore;
									for(int i=0; i<ptl.length; i++) {
										objs[i] = md.getParamList().get(i).getTestData();
									}
									try {
										
										Object temp = m.invoke(c.newInstance(), objs);
										if(temp.equals(md.getReturnObject())) {
											score++;
											//*****test
											judgeResult.addJudgeDetail("输出值相同：["+temp+"]");
											//*****
										}
									} catch (Exception e) {
										e.printStackTrace();
									}
								}
							}
						}
					}
				}
			}
			
		}
		
		judgeResult.setScore(score);
		
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
		
		List<ByClass> datas = judgeDetail.getData();
		if(datas != null) {
			for(ByClass clzz : datas) {
				//类名
				System.out.println("className:"+clzz.getClassName());
				TotalScore ++;
				
				if(clzz.getFieldList() != null) {
					for(FieldData fd : clzz.getFieldList()) {
						//变量名
						System.out.println("  fieldName:" + fd.getName());
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
						//期望返回值
						System.out.println("  methodReturnObject:" + md.getReturnObject());
						TotalScore++;
						
						if(md.getParamList() != null) {
							for(ParamData pd : md.getParamList()) {
								//参数类型
								System.out.println("    paramType:" + pd.getType());
								TotalScore ++;
								//参数数据
								System.out.println("    paramData:" + pd.getTestData());
							}
						}
					}
				}
			}
		}
		
		return TotalScore;
	}

	@Override
	public JudgeResult judgeCProj(String projurl, int expid) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public JudgeResult judgeCSProj(String projurl, int expid) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public JudgeResult judgeDBProj(String projurl, int expid) {
		// TODO Auto-generated method stub
		return null;
	}

}
