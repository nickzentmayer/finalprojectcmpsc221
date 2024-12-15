package servletTest;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/redirect")
public class Redirect extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    	response.getWriter().append("<!DOCTYPE html>\n"
    			+ "<html>\n"
    			+ "<head>\n"
    			+ "    <title>Redirecting...</title>\n"
    			+ "    <script>\n"
    			+ "        window.location.href = \"http://${window.location.hostname}:${window.location.port};\n"
    			+ "    </script>\n"
    			+ "</head>\n"
    			+ "<body>\n"
    			+ "    <p>If you are not redirected automatically, <a href=\"/\">click here</a>.</p>\n"
    			+ "</body>\n"
    			+ "</html>\n"
    			+ "");

    }
}

/*
If cooked: break glass

<servlet>
    <description></description>
    <display-name>Redirect</display-name>
    <servlet-name>Redirect</servlet-name>
    <servlet-class>servletTest.Redirect</servlet-class>
  </servlet>
  
  <servlet-mapping>
    <servlet-name>Redirect</servlet-name>
    <url-pattern>/</url-pattern>
  </servlet-mapping>
*/