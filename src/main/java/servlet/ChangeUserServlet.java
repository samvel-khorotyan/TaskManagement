package servlet;

import manager.UserManager;
import model.User;
import model.UserType;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/changeUser")
public class ChangeUserServlet extends HttpServlet {

    private UserManager userManager = new UserManager();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));

        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String userType = req.getParameter("type");

        userManager.update(User.builder()
                .id(id)
                .name(name)
                .surname(surname)
                .email(email)
                .password(password)
                .userType(UserType.valueOf(userType))
                .build());

        resp.sendRedirect("/adminHome");
    }
}
