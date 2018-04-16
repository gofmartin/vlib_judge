package vlib_judge;

import static org.junit.Assert.*;

import org.junit.Test;

import vlib.util.HttpUtil;

public class HttpTest {

	@Test
	public void testGet() {

		String url = "http://www.baidu.com";
		String param = "";
		
		String str = HttpUtil.sendGet(url, param);
		System.out.println(str);
		
	}
	
	@Test
	public void testPost() {
		
		String url = "localhost:8080";
		String param = "detail=";
		
		String str = HttpUtil.sendPost(url, param);
		System.out.println(str);
		
	}

}
