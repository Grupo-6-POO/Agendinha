package entities;
import Enums.Priority;
import Enums.Status;
import services.Manager;
import services.TaskManager;

import java.util.Scanner;

public class Task extends Manager{
    private String title;
    private String description;
    private Status status;
    private Priority priority;
    private Integer progress;
   // private Calendar initialDeadLine;
   // private Calendar deadLine;
    private boolean isRepeating;

    public Task (){

    }

    public Task( String title , String description, Status status, Priority priority, Integer progress, boolean isRepeating){
        this.title = title;
        this.description = description;
        this.status = Status.PENDING;
        this.priority = priority;
        this.progress = progress;
        this.isRepeating = isRepeating;
    }

    //Obs: Estava dando erro então eu tive q adicionar isso aq (era isso ou transforma em abstrata
    public Manager add() { return null; }
    public void delete(){    }
    public void update(){}
    public void read(){}


    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description;}

    public Status getStatus() { return status;}
    public void setStatus(Status status) { this.status = status; }

    public Priority getPriority() { return priority; }
    public void setPriority(Priority priority) { this.priority = priority; }

    public Integer getProgress() { return progress; }
    public void setProgress(Integer progress) { this.progress = progress; }

    public boolean getRepeating() { return isRepeating; }
    public void setRepeating(boolean repeating) { isRepeating = repeating; }
}
