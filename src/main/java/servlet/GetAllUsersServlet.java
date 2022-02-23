package servlet;

import manager.UserManager;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/getAllUsers")
public class GetAllUsersServlet extends HttpServlet {

    private UserManager userManager = new UserManager();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<User> users = userManager.getAllUsers();

        req.setAttribute("users",users);

        req.getRequestDispatcher("/WEB-INF/getAllUsers.jsp").forward(req,resp);
    }
}
