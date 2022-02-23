package servlet;

import manager.TaskManager;
import model.Task;
import model.TaskStatus;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@WebServlet(urlPatterns = "/changeTask")
public class ChangeTaskServlet extends HttpServlet {

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private TaskManager taskManager = new TaskManager();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));

        String name = req.getParameter("name");
        String description = req.getParameter("description");
        String deadline = req.getParameter("deadline");
        int userId = Integer.parseInt(req.getParameter("userId"));
        String status = req.getParameter("status");

        Task task = taskManager.getTaskById(id);


        try {
            task.setName(name);
            task.setDescription(description);
            task.setDeadline(sdf.parse(deadline));
            task.setUserId(userId);
            task.setTaskStatus(TaskStatus.valueOf(status));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        taskManager.update(task);

        req.getRequestDispatcher("/getAllTasks").forward(req,resp);
    }
}
