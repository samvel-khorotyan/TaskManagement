package servlet;

import manager.TaskManager;
import model.Task;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/getAllTasksByUserId")
public class GetAllTasksByUserIdServlet extends HttpServlet {

    private TaskManager taskManager = new TaskManager();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");

        List<Task> tasks = taskManager.getTaskByUserId(user.getId());

        req.setAttribute("tasks", tasks);

        req.getRequestDispatcher("/WEB-INF/getAllTasksByUserId.jsp").forward(req, resp);

    }
}
