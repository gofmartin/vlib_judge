package vlib_judge;

import static org.junit.Assert.*;

import org.junit.Test;

import vlib.entity.JudgeDetail;
import vlib.judger.JavaJudger;

public class JudgeTest {

	@Test
	public void test() {
		JavaJudger javaJudger = new JavaJudger();
		try {
			javaJudger.judge("D:/wmy/JavaWorkSpace/Test/bin", null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
