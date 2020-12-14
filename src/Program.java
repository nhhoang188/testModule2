public class Program {
    public static void main(String[] args) {
        ContactManager contactManager = new ContactManager();
        contactManager.addContact();
        contactManager.addContact();
        contactManager.addContact();
        contactManager.showContact();
        contactManager.searcContact();
        contactManager.deleteContact();
        contactManager.showContact();
        contactManager.updateContact();
        contactManager.showContact();
    }
}
