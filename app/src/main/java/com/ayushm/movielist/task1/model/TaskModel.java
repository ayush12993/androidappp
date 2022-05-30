package com.ayushm.movielist.task1.model;

public class TaskModel {


    String taskTitle,taskBody;

    public TaskModel(String taskTitle, String taskBody) {
        this.taskTitle = taskTitle;
        this.taskBody = taskBody;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public String getTaskBody() {
        return taskBody;
    }

    public void setTaskBody(String taskBody) {
        this.taskBody = taskBody;
    }
}
