import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Program {
    public static void main(String[] args) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm, dd/MM/yyyy");
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Today is: " + dtf.format(now));
        MenuShow.showMenu();
    }
}
