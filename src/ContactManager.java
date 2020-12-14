import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ContactManager extends Regex_Form {
    static List<Contact> contactList = new ArrayList<>();


    public static List<Contact> getContactList() {
        return contactList;
    }

    public static void setContactList(List<Contact> contactList) {
        ContactManager.contactList = contactList;
    }

    public void addContact() {
        Contact contact = new Contact(InputField.inputName(), InputField.inputPhone(), InputField.inputAdress(), InputField.inputEmail(), InputField.inputFacebook());
        contactList.add(contact);
    }

    public void showContact() {
        for (Contact contact : contactList) {
            System.out.println(contact);
        }
    }

    public void updateContact() {
        boolean flag = true;
        while (flag) {
            System.out.println("Enter name or phone contact you want update.");
            String update = sc.nextLine();
            int index = 0;
            for (int i = 0; i < contactList.size(); i++) {
                if (update.equals(contactList.get(i).getName()) || update.equals(contactList.get(i).getPhone())) {
                    contactList.get(i).setName(InputField.inputName());
                    contactList.get(i).setName(InputField.inputPhone());
                    contactList.get(i).setName(InputField.inputAdress());
                    contactList.get(i).setName(InputField.inputEmail());
                    contactList.get(i).setName(InputField.inputFacebook());
                    flag = false;
                    index++;
                }
            }
            if (index == 0) {
                System.out.println("Opp!! please enter name or phone again.");
            }
        }
    }

    public void deleteContact() {
        boolean flag = true;
        while (flag) {
            System.out.println("Enter name or phone contact you want delete.");
            String delete = sc.nextLine();
            int index = 0;
            for (int i = 0; i < contactList.size(); i++) {
                if (delete.equals(contactList.get(i).getName()) || delete.equals(contactList.get(i).getPhone())) {
                    contactList.remove(i);
                    flag = false;
                    index++;
                }
            }
            if (index == 0) {
                System.out.println("Opp!! please enter name or phone again.");
            }
        }
    }
    public void searcContact(){
        boolean flag = true;
        while (flag) {
            System.out.println("Enter name or phone.");
            String search = sc.nextLine();
            int index = 0;
            Pattern pattern = Pattern.compile(search);
            for (int i = 0; i < contactList.size(); i++) {
                Matcher matcherName = pattern.matcher(contactList.get(i).getName().toLowerCase());
                Matcher matcherName1 = pattern.matcher(contactList.get(i).getName().toLowerCase());
                Matcher matcherPhone = pattern.matcher(contactList.get(i).getPhone());
                if (matcherPhone.find() || matcherName.find() || matcherName1.find()){
                    System.out.println(contactList.get(i));
                    flag = false;
                    index++;
                }
            }
            if (index == 0) {
                System.out.println("Opp!! please enter name or phone again.");
            }
        }
    }
    public void writeContactFromFileCSV(){

    }
}
