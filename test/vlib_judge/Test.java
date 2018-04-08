package vlib_judge;

import static org.junit.Assert.*;

import vlib.util.DownloadUtil;

public class Test {

	@org.junit.Test
	public void testDownload() {
		
		String path = "D:/Test/";
		String resUrl = "https://img.alicdn.com/tfs/TB1bK1ZiHSYBuNjSspiXXXNzpXa-520-280.jpg_q90_.webp";
		String fileName = "down.webp";
		
		DownloadUtil.getInternetRes(path, resUrl, fileName);
		
	}
	
	@org.junit.Test
	public void testGet() {
		
		
		
	}

}
