public class MenuShow extends Regex_Form {
   static ContactManager contactManager = new ContactManager();
    public static void showMenu() {
        System.out.println("1. Add New Contact.");
        System.out.println("2. Show All Contact.");
        System.out.println("3. Update Contact.");
        System.out.println("4. Delete Contact.");
        System.out.println("5. Search Contact.");
        System.out.println("6. Read Contact From File.");
        System.out.println("7. Write Contact To File.");
        System.out.println("8. Exit.");
        String choose = sc.nextLine();
        switch (choose) {
            case "1":
                contactManager.addContact();
                showMenu();
                break;
            case "2":
                contactManager.showContact();
                showMenu();
                break;
            case "3":
                contactManager.updateContact();
                showMenu();
                break;
            case "4":
                contactManager.deleteContact();
                showMenu();
                break;
            case "5":
                contactManager.searcContact();
                showMenu();
                break;
            case "6":
                System.out.println("enter source file contact .csv");
                String path = sc.nextLine();
                contactManager.readContactFromFileCSV(path);
                showMenu();
                break;
            case "7":
                System.out.println("enter source file contact ");
                String path1 = sc.nextLine();
                contactManager.writeContactFromFileCSV(path1);
                showMenu();
                break;
            case "8":
                System.out.println("Nice to bring you the useful information. Goodbye, see you again!");
                System.exit(0);
                break;
            default:
                System.out.println("Oops!! Please enter again ...");
                sc.nextLine();
                showMenu();
        }
    }
}
