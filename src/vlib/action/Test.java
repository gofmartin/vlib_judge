package vlib.action;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Test extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public Test() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
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
