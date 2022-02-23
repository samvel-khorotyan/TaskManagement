package servlet;

import manager.TaskManager;
import model.User;
import model.UserType;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/changeTaskStatus")
public class ChangeTaskStatusServlet extends HttpServlet {

    private TaskManager taskManager = new TaskManager();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");

        int taskId = Integer.parseInt(req.getParameter("taskId"));
        String taskStatus = req.getParameter("status");

        taskManager.updateTaskStatus(taskId, taskStatus);

        if (user.getUserType() == UserType.ADMIN) {
            req.getRequestDispatcher("/getAllTasks").forward(req, resp);
        } else {
            resp.sendRedirect("/getAllTasksByUserId");
        }
    }
}
