package dk.lundogbendsen.springboot.ex06.servlets;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class HelloServlet extends HttpServlet {

    public HelloServlet() {
        System.out.println("Created HelloServlet");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("Hello world!!!");
        String name = req.getParameter("name");
        if (name!=null) {
            out.println("<p>And hello to you, " + name + "</p>");
        } else {
            out.println("<p>Try adding a name parameter, <a href='./servlet?name=Roy+Fielding'>./servlets?name=...</a></p>");
        }
    }
}
