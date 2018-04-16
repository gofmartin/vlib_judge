package vlib_judge;

import static org.junit.Assert.*;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;

import org.junit.Test;

import vlib.judger.JavaJudger;

public class LoaderTest {

	@Test
	public void test() {
		JavaJudger javaJudger = new JavaJudger();
		ArrayList<Class> classList = null;
		try {
			classList = (ArrayList<Class>) javaJudger.classLoader("D:/wmy/JavaWorkSpace/AdapterTest/bin");
			//遍历classlist
			for(Class class1 : classList) {
				System.out.println("class name:"+class1.getName());
				System.out.println("class method:");
				Method[] methods = class1.getMethods();
				for(Method m : methods) {
					System.out.println("-" + m.getName());
					Parameter[] parameters = m.getParameters();
					for(Parameter p : parameters) {
						System.out.println("--" + p.getName() + ":" + p.getType());
					}
				}
//				System.out.println("class param:");
//				Field[] fieldArray = class1.getFields();
//				for(Field f : fieldArray) {
//					System.out.println("-" + f.getName());
//				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
