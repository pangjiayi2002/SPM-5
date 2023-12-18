package service.task;

import Pojo.Task;

import java.util.List;

public interface TaskService {
    public boolean add(Task notice);

    List<Task> getAll() throws Exception;

    public Task getById(String id);

    public boolean modify(Task notice);

    public boolean deleteById(String id);

}
