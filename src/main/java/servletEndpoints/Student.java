package servletEndpoints;

import java.io.IOException;
import java.io.PrintWriter;

import javax.imageio.plugins.tiff.ExifGPSTagSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import mainWs.*;

/**
 * Servlet implementation class Student
 */
@WebServlet("/Student")
public class Student extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Student() {
	super();
	// TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	// TODO Auto-generated method stub

	PrintWriter out = response.getWriter();
	System.out.println(request.getHeader("Authorization"));
	if (!util.isAuthenticated(request.getHeader("Authorization"))) {
	    out.print("Not Authenticated ");
	} else {
	    String username = request.getParameter("username");
	    String password = request.getParameter("password");
	    String[] result = util.login(username, password);
	    JSONObject JsonResponse= new JSONObject();
	    JsonResponse.put(result[0], result[1]);
	    out.print(JsonResponse);
	}
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	// TODO Auto-generated method stub
	PrintWriter out = response.getWriter();
	System.out.println(request.getHeader("Authorization"));
	if (!util.isAuthenticated(request.getHeader("Authorization"))) {
	    out.print("Not Authenticated ");
	} else {
	    String username = request.getParameter("username");
	    String password = request.getParameter("password");
	    String student_name = request.getParameter("student_name");
	    String college_course = request.getParameter("college_course");
	    String[] result = util.register(username,password,student_name,college_course);
	    JSONObject JsonResponse= new JSONObject();
	    JsonResponse.put(result[0], result[1]);
	    out.print(JsonResponse);
	}

    }

}
