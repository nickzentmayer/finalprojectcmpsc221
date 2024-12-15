package servletTest;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Servlet implementation class ShowCourse
 */
@WebServlet("/showCourse")
public class ShowCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowCourse() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
        response.getWriter().println("<link rel=\"stylesheet\" href=\"style.css\" />");
        response.getWriter().println("<html>");
        response.getWriter().println("<body>");
        response.getWriter().println("<h1>Course Information</h1>");
        File f = new File("/Users/nickzentmayer/Documents/CMPSC 221/course_info.csv");
        if(f.exists()) {
        Scanner data = new Scanner(f);
        response.getWriter().println("<div id=\"data\">");
        response.getWriter().println("<table>");
        response.getWriter().println("<tr>");
        response.getWriter().println("<th>Title</th>");
        response.getWriter().println("<th>ID</th>");
        response.getWriter().println("<th>Department</th>");
        response.getWriter().println("<th>Credits</th>");
        response.getWriter().println("</tr>");
	    while(data.hasNextLine()) {
	        	String row = data.nextLine();
	        	response.getWriter().print("<tr>");
	        	response.getWriter().print("<td>" + row.substring(0, row.indexOf(',')) + "</td>");
	        	row = row.substring(row.indexOf(',') + 1);
	        	response.getWriter().print("<td>" + row.substring(0, row.indexOf(',')) + "</td>");
	        	row = row.substring(row.indexOf(',') + 1);
	        	response.getWriter().print("<td>" + row.substring(0, row.indexOf(',')) + "</td>");
	        	row = row.substring(row.indexOf(',') + 1);
	        	response.getWriter().print("<td>" + row + "</td>");
	        	response.getWriter().print("</tr>");
	       }
	    response.getWriter().println("</table>");
	    response.getWriter().println("</div>");
	    response.getWriter().println("</body>");
	    response.getWriter().println("</html>");
	    data.close();
        }
        else response.getWriter().println("<p style=\"color: red;\">course_info.csv not found</p>");
        response.getWriter().println("<br>");
        response.getWriter().println("<a href=\"/\"><button class=\"actionButtons\">Return</button></a>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
