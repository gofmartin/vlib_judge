package vlib_judge;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Test {

	@org.junit.Test
	public void test() {
		
		
		
	}
	
	public void getInternetRes(String savepath, String resurl, String fileName) {
        URL url = null;
        HttpURLConnection con = null;
        InputStream in = null;
        FileOutputStream out = null;
        try {
            url = new URL(resurl);
            //建立http连接，得到连接对象
            con = (HttpURLConnection) url.openConnection();
            //con.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
            in = con.getInputStream();
            byte[] data = getByteData(in);//转化为byte数组

            File file = new File(savepath);
            if (!file.exists()) {
                file.mkdirs();
            }

            File res = new File(file + File.separator + fileName);
            out = new FileOutputStream(res);
            out.write(data);
            System.out.println("downloaded successfully!");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != out)
                    out.close();
                if (null != in)
                    in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
	
	private byte[] getByteData(InputStream in) throws IOException {
		
        byte[] b = new byte[1024];
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        int len = 0;
        while ((len = in.read(b)) != -1) {
            bos.write(b, 0, len);
        }
        if(null != bos){
            bos.close();
        }
        return bos.toByteArray();
        
    }

}
