package vlib.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import vlib.dao.impl.RulesDaoImpl;

public class SaveRuleAction extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public SaveRuleAction() {
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

		String expid = request.getParameter("expid");
		String rule = request.getParameter("rule");
		
		//Test
		System.out.println("expid:" + expid);
		System.out.println("rule:" + rule);
		//end of test
		
		RulesDaoImpl rulesDaoImpl = new RulesDaoImpl();
		rulesDaoImpl.add(Integer.parseInt(expid), rule);
		
		JSONObject jsonObject = new JSONObject();
		
		jsonObject.put("result", "success");
		
		response.setContentType("text/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out = response.getWriter();
		out.println(jsonObject);
		
		out.flush();
		out.close();
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
