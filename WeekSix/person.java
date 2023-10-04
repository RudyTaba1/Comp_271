package WeekSix;
import java.util.Date;

public class person {
    private String name;
    private String Lname;
    private Date dob;

    public person(){
        this.name = "Rudy";
        this.Lname =" Tabachnik";
        
        }
    public String toString(){
       return "my name is " + this.name + this.Lname;
    }
}
