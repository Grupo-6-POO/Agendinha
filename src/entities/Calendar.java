package entities;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Calendar  {
    private Date deadLine;
    private Date initialDeadLine;

    public Calendar(Date deadLine, Date initialDeadLine) {
        this.deadLine = deadLine;
        this.initialDeadLine = initialDeadLine;
    }

    public void verifyInicialDeadLine(){
        //Visualiza o dia e hora exata do momento que é chamada a função
        Date date = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println(date);
    }

    public void verifyDeadLine(){
    }

    public Date getInitialDeadLine() {
        return initialDeadLine;
    }
    public Date getDeadLine() {
        return deadLine;
    }


}
