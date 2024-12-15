package servletTest;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.FileWriter;
import java.io.IOException;


@WebServlet("/addCourse")
public class AddCourseServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String courseName = request.getParameter("courseTitle");
        String courseCode = request.getParameter("courseId");
        String instructor = request.getParameter("dept");
        String semester = request.getParameter("credits");

        // Save the course information to a CSV file
        try (FileWriter writer = new FileWriter("/Users/nickzentmayer/Documents/CMPSC 221/course_info.csv", true)) {
            writer.append(courseName)
                  .append(',')
                  .append(courseCode)
                  .append(',')
                  .append(instructor)
                  .append(',')
                  .append(semester)
                  .append('\n');
        } catch (IOException e) {
            e.printStackTrace();
        }

        response.setContentType("text/html");
        response.getWriter().println("<link rel=\"stylesheet\" href=\"style.css\" />");
        response.getWriter().println("<h1>Course Information Submitted</h1>");
        response.getWriter().println("<p>Course Title: " + courseName + "</p>");
        response.getWriter().println("<p>Course ID: " + courseCode + "</p>");
        response.getWriter().println("<p>Dept: " + instructor + "</p>");
        response.getWriter().println("<p>Credits: " + semester + "</p>");
        response.getWriter().println("<br>");
        response.getWriter().println("<a href=\"/\"><button class=\"actionButtons\">Return</button></a>");
    }
}