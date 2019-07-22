package com.fitness.model.service;

import com.fitness.model.model.Task;
import com.fitness.model.repository.TaskRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;


    public Iterable<Task> findAll() {
        return taskRepository.findAll();
    }


    public Task findById(Long id) throws NotFoundException {
        return taskRepository.findById(id).orElseThrow(()->{
            return new NotFoundException("Task not found");
        });
    }


    public void toggleComplete(Long id) throws NotFoundException {
        Task task = taskRepository.findById(id).orElseThrow(()->{
            return new NotFoundException("Task not found");
        });
        task.setComplete(!task.isComplete());
        taskRepository.save(task);
    }


    public void save(Task task) {
        taskRepository.save(task);
    }
}
