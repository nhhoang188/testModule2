import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputField extends Regex_Form {
    public static String inputName() {
        System.out.println("Enter Name:");
        return sc.nextLine();
    }

    public static String inputAdress() {
        System.out.println("Enter adress:");
        return sc.nextLine();
    }

   public static String inputEmail() {
        while (true) {
            System.out.println("Enter Email:");
            String email = sc.nextLine();
            Pattern pattern = Pattern.compile(EMAIL_FORM);
            Matcher matcher = pattern.matcher(email);
            try {
                if (matcher.find()) {
                    return email;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Wrong format, please try again!");
            }
        }
    }
    public static String inputPhone(){
        while (true) {
            System.out.println("Enter Phone:");
            String phone = sc.nextLine();
            Pattern pattern = Pattern.compile(PHONE_FORM);
            Matcher matcher = pattern.matcher(phone);
            try {
                if (matcher.find()) {
                    return phone;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Wrong format, please try again!");
            }
        }
    }
    public static String inputFacebook(){
        System.out.println("Enter facebook link:");
        return sc.nextLine();
    }
}

