package entities;
import services.Manager;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Task extends Manager <Task> implements Serializable {
    private String title;
    private String status;
    private String priority;
    private Calendar initialDeadLine;
    private LocalDate deadLine;
    Category category;

    public Task(){}

    public Task( String title, String priority, String status, LocalDate deadLine){
        this.title = title;
        this.priority = priority;
        this.status = status;
        this.deadLine = deadLine;
    }

    public String getTitle() { return title;}
    public void setTitle(String title) { this.title = title; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getPriority() { return priority; }
    public void setPriority(String priority) { this.priority = priority; }

    public LocalDate getDeadLine() { return deadLine; }
    public void setDeadLine(LocalDate deadLine) { this.deadLine = deadLine;
    }
    public Category getCategory() { return category; }

    @Override
    public Task add(Task obj) {
        return null;
    }

    @Override
    public void delete(Task obj) {

    }

    @Override
    public void read(Task obj) {

    }

    @Override
    public void update(Task obj) {

    }
}
