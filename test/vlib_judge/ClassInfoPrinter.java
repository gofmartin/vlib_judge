package vlib_judge;

import static org.junit.Assert.*;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

import org.junit.Test;

import vlib.util.Utils;

public class ClassInfoPrinter {

	@Test
	public void test() throws NoSuchMethodException, SecurityException, ClassNotFoundException {
		ArrayList<Class> clazzList = (ArrayList<Class>) Utils.classLoader("D:/wmy/JavaWorkSpace/Test/bin");
		
		//遍历类列表
		if(clazzList == null) {
			return;
		}
		for(Class clazz : clazzList) {
			//类名
			System.out.println("className:" + clazz.getName());
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
		
	}

}
