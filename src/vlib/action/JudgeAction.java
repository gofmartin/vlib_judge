package vlib.action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.InvalidRemoteException;
import org.eclipse.jgit.api.errors.TransportException;

import vlib.dao.impl.RulesDaoImpl;
import vlib.entity.JudgeDetail;
import vlib.entity.JudgeResult;
import vlib.judger.JavaJudger;
import vlib.util.GitUtil;

public class JudgeAction extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public JudgeAction() {
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

		String path = request.getParameter("path");
		String expid_str = request.getParameter("expid");
		int expid = Integer.parseInt(expid_str.trim());
		
		String repopath = "D:/bishe/repo/";
		String repoName = GitUtil.getRepoName(path);
		String classPath = repopath+"/bin";
		try {
			GitUtil.cloneFromGitlab(path, repopath);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		JavaJudger judger = new JavaJudger();
		JudgeResult result = null;
		try {
			result = judger.judgeJavaProj(classPath, expid);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		GitUtil.delDir(new File(repopath));
		
		request.setAttribute("result", result);
		request.getRequestDispatcher("showresult.jsp").forward(request, response);
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
