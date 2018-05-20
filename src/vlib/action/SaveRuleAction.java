package vlib.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import vlib.dao.impl.RulesDaoImpl;
import vlib.entity.ByClass;
import vlib.entity.FieldData;
import vlib.entity.JudgeDetail;
import vlib.entity.MethodData;
import vlib.entity.ParamData;

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
		
		String dataString = request.getParameter("data");
		JSONObject jsonObject = JSONObject.fromObject(dataString);
		
		JudgeDetail judgeDetail = new JudgeDetail();
		judgeDetail.setExpid(Integer.parseInt(jsonObject.getString("expid").trim()));
		judgeDetail.setType(jsonObject.getString("exptype"));
		judgeDetail.setRule(jsonObject.getString("judgetype"));
		ArrayList<ByClass> classes = new ArrayList<ByClass>();
		
		JSONArray classlist = jsonObject.getJSONArray("data");
		for(int i=0; i<classlist.size(); i++) {
			JSONObject clazz = classlist.getJSONObject(i);
			ByClass bc = new ByClass();
			bc.setClassName(clazz.getString("classname"));
			ArrayList<FieldData> fields = new ArrayList<FieldData>();
			ArrayList<MethodData> methods = new ArrayList<MethodData>();
			
			//
			JSONArray fieldlist = clazz.getJSONArray("fieldlist");
			for(int j=0; j<fieldlist.size(); j++) {
				JSONObject field = fieldlist.getJSONObject(j);
				FieldData fd = new FieldData();
				fd.setName(field.getString("fieldname"));
				fd.setType(field.getString("fieldtype"));
				
				fields.add(fd);
			}
			bc.setFieldList(fields);
			//*****
			
			//
			JSONArray methodlist = clazz.getJSONArray("methodlist");
			for(int k=0; k<methodlist.size(); k++) {
				JSONObject method = methodlist.getJSONObject(k);
				MethodData md = new MethodData();
				md.setMethodName(method.getString("methodname"));
				md.setReturnType(method.getString("returntype"));
				md.setReturnObject(method.getString("returndata"));
				ArrayList<ParamData> params = new ArrayList<ParamData>();
				
				//
				JSONArray paramlist = method.getJSONArray("paramlist");
				for(int l=0; l<paramlist.size(); l++) {
					JSONObject param = paramlist.getJSONObject(l);
					ParamData pd = new ParamData();
					pd.setType(param.getString("paramtype"));
					pd.setTestData(param.getString("paramdata"));
					
					params.add(pd);
				}
				md.setParamList(params);
				//*****
				
				methods.add(md);
			}
			bc.setMethodList(methods);
			//*****
			
			classes.add(bc);
		}
		
		judgeDetail.setData(classes);
		
		RulesDaoImpl rulesDaoImpl = new RulesDaoImpl();
		rulesDaoImpl.add(judgeDetail);
		
		
		//返回部分
		JSONObject returnObject = new JSONObject();
		returnObject.put("result", "success");
		response.setContentType("text/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out = response.getWriter();
		out.println(jsonObject);
		
		out.flush();
		out.close();
		//*****

//		String expid = request.getParameter("expid");
//		String rule = request.getParameter("rule");
//		
//		//Test
//		System.out.println("expid:" + expid);
//		System.out.println("rule:" + rule);
//		//end of test
//		
//		RulesDaoImpl rulesDaoImpl = new RulesDaoImpl();
////		rulesDaoImpl.add(rule);
//		
//		JSONObject jsonObject = new JSONObject();
//		
//		jsonObject.put("result", "success");
//		
//		response.setContentType("text/json; charset=utf-8");
//		PrintWriter out = response.getWriter();
//		
//		out = response.getWriter();
//		out.println(jsonObject);
//		
//		out.flush();
//		out.close();
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
