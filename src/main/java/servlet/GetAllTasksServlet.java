package servlet;

import manager.TaskManager;
import model.Task;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/getAllTasks")
public class GetAllTasksServlet extends HttpServlet {

    private TaskManager taskManager = new TaskManager();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Task> tasks = taskManager.getAllTasks();

        req.setAttribute("tasks", tasks);

        req.getRequestDispatcher("/WEB-INF/getAllTasks.jsp").forward(req, resp);

    }
}
