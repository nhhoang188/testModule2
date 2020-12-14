import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ContactManager extends Regex_Form {
    static List<Contact> contactList = new ArrayList<>();

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
            for (Contact contact : contactList) {
                if (update.equals(contact.getName()) || update.equals(contact.getPhone())) {
                    contact.setName(InputField.inputName());
                    contact.setName(InputField.inputPhone());
                    contact.setName(InputField.inputAdress());
                    contact.setName(InputField.inputEmail());
                    contact.setName(InputField.inputFacebook());
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

    public void searcContact() {
        boolean flag = true;
        while (flag) {
            System.out.println("Enter name or phone.");
            String search = sc.nextLine();
            int index = 0;
            Pattern pattern = Pattern.compile(search);
            for (Contact contact : contactList) {
                Matcher matcherName = pattern.matcher(contact.getName().toLowerCase());
                Matcher matcherName1 = pattern.matcher(contact.getName().toLowerCase());
                Matcher matcherPhone = pattern.matcher(contact.getPhone());
                if (matcherPhone.find() || matcherName.find() || matcherName1.find()) {
                    System.out.println(contact);
                    flag = false;
                    index++;
                }
            }
            if (index == 0) {
                System.out.println("Opp!! please enter name or phone again.");
            }
        }
    }

    public void readContactFromFileCSV(String path) {
        List<Contact> contactList1 = new ArrayList<>();
        String line = null;
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        assert fileReader != null;
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        while (true) {
            try {
                if ((line = bufferedReader.readLine()) == null) break;
            } catch (IOException exception) {
                System.out.println(exception);
            }
            assert line != null;
            String[] temp = line.split(COMMA_DELIMITER);
            String name = temp[0];
            String phone = temp[1];
            String adress = temp[2];
            String email = temp[3];
            String fb = temp[4];
            contactList1.add(new Contact(name, phone, adress, email, fb));
        }
        try {
            bufferedReader.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        for (Contact contact : contactList1) {
            System.out.println(contact);
        }
    }

    public void writeContactFromFileCSV(String path) {
        FileWriter fileWriter = null;
        File file = new File(path + ".csv");
        try {
            fileWriter = new FileWriter(file);
            for (Contact contact : contactList) {
                fileWriter.append(contact.getName());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(contact.getPhone());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(contact.getAddress());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(contact.getEmail());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(contact.getFacebook());
                fileWriter.append(NEW_LINE_SEPARATOR);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
