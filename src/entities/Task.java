package entities;
import Enums.Priority;
import Enums.Status;
import services.Manager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Task extends Manager <Task> implements Serializable {
    private String title;
    private String description;
    private Status status = Status.PENDING;
    private Priority priority;
    private Calendar initialDeadLine;
    private Calendar deadLine;
    private boolean isRepeating = false;
    private boolean isConcluded = false;
    Category category;

    public Task(){}

    public Task( String title, String description, Priority priority, Category category){
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.category = category;
    }

    public String getTitle() { return title;}
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }

    public Priority getPriority() { return priority; }
    public void setPriority(Priority priority) { this.priority = priority; }

    public boolean getRepeating() { return isRepeating; }
    public void setRepeating(boolean repeating) { isRepeating = repeating; }

    public boolean isConcluded() { return isConcluded; }
    public void setConcluded(boolean concluded) { isConcluded = concluded; }

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
