package entities;
import Enums.Priority;
import Enums.Status;
import services.Manager;

public class Task extends Manager {
    private String title;
    private String description;
    private Status status;
    private Priority priority;
    private Calendar initialDeadLine;
    private Calendar deadLine;
    private boolean isRepeating = false;
    private boolean isConcluded = false;
    Category category;


    public Task( String title, String description, Status status, Priority priority, Category category){
        this.title = title;
        this.description = description;
        this.status = Status.PENDING;
        this.priority = priority;
        this.category = category;
    }

    public String getTitle() { return title;}
    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }

    public Priority getPriority() {
        return priority;
    }
    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public boolean getRepeating() {
        return isRepeating;
    }
    public void setRepeating(boolean repeating) {
        isRepeating = repeating;
    }

    public boolean isConcluded() {
        return isConcluded;
    }
    public void setConcluded(boolean concluded) {
        isConcluded = concluded;
    }

    @Override
    public Task Add() {
        return null;
    }

    @Override
    public void Delete() {

    }

    @Override
    public void Read() {

    }

    @Override
    public void Update() {

    }
}
