package neww;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.insertPhone("TuanAnh", "123456789");
        phoneBook.insertPhone("AnhNgoc", "987654321");
        phoneBook.insertPhone("KieuChi", "555555555");
        phoneBook.sort();

        List<PhoneNumber> phoneList = phoneBook.getPhoneList();

        for (PhoneNumber phoneNumber : phoneList) {
            System.out.println("Name: " + phoneNumber.name() + ", Phone: " + phoneNumber.phone());
        }

        PhoneNumber foundPhoneNumber = phoneBook.searchPhone("Jane");
        if (foundPhoneNumber != null) {
            System.out.println("Phone number found: " + foundPhoneNumber.phone());
        } else {
            System.out.println("Phone number not found.");
        }
    }
}