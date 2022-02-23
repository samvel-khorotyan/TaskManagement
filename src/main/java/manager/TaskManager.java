package manager;

import db.DBConnectionProvider;
import model.Task;
import model.TaskStatus;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class TaskManager {

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private Connection connection = DBConnectionProvider.getInstance().getConnection();
    private UserManager userManager = new UserManager();

    public boolean addTask(Task task) {
        String sql = "INSERT INTO taskmanagement.task (name,description,deadline,user_id,status) VALUES(?,?,?,?,?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, task.getName());
            preparedStatement.setString(2, task.getDescription());
            preparedStatement.setString(3, sdf.format(task.getDeadline()));
            preparedStatement.setInt(4, task.getUserId());
            preparedStatement.setString(5, task.getTaskStatus().name());

            preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();

            if (resultSet.next()) {
                task.setId(resultSet.getInt(1));
            }
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private Task getTaskFromResultSet(ResultSet resultSet) {
        try {
            return Task.builder()
                    .id(resultSet.getInt(1))
                    .name(resultSet.getString(2))
                    .description(resultSet.getString(3))
                    .deadline(resultSet.getDate(4))
                    .userId(resultSet.getInt(5))
                    .taskStatus(TaskStatus.valueOf(resultSet.getString(6)))
                    .user(userManager.getById(resultSet.getInt(5)))
                    .build();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Task> getTaskByUserId(int Id) {

        String sql = "SELECT * FROM taskmanagement.task WHERE user_id = " + Id;

        List<Task> list = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                list.add(getTaskFromResultSet(resultSet));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Task> getAllTasks() {

        String sql = "select * from taskmanagement.task";

        List<Task> list = new ArrayList<>();

        try {

            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            ResultSet resultSet = prepareStatement.executeQuery();

            while (resultSet.next()) {
                Task task = new Task();

                task.setId(resultSet.getInt(1));
                task.setName(resultSet.getString(2));
                task.setDescription(resultSet.getString(3));
                task.setDeadline(resultSet.getDate(4));
                task.setUserId(resultSet.getInt(5));
                task.setTaskStatus(TaskStatus.valueOf(resultSet.getString(6)));
                task.setUser(userManager.getById(resultSet.getInt(5)));

                list.add(task);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public Task getTaskById(int taskId) {

        String sql = "SELECT * FROM taskmanagement.task WHERE id = " + taskId;

        try {
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {
                return getTaskFromResultSet(resultSet);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean update(Task task) {

        String sql = "UPDATE taskmanagement.task SET name = ?, description = ?, deadline = ?, user_id = ?, status = ? WHERE id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, task.getName());
            preparedStatement.setString(2, task.getDescription());
            preparedStatement.setString(3, sdf.format(task.getDeadline()));
            preparedStatement.setInt(4, task.getUser().getId());
            preparedStatement.setString(5, task.getTaskStatus().name());

            preparedStatement.setInt(6, task.getId());

            preparedStatement.executeUpdate();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void updateTaskStatus(int taskId, String newStatus) {

        String sql = "UPDATE taskmanagement.task SET status = ? WHERE id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, newStatus);
            preparedStatement.setInt(2, taskId);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {

        String sql = "DELETE FROM taskmanagement.task WHERE id = " + id;

        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
