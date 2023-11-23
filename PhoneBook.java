package neww;

import java.util.ArrayList;
import java.util.List;


public class PhoneBook extends Phone {
    private final List<PhoneNumber> phoneList;

    public PhoneBook() {
        phoneList = new ArrayList<>();
    }

    @Override
    public void insertPhone(String name, String phone) {
        PhoneNumber foundPhoneNumber = searchPhone(name);

        if (foundPhoneNumber == null) {
            List<String> phoneNumbers = new ArrayList<>();
            phoneNumbers.add(phone);
            PhoneNumber newPhoneNumber = new PhoneNumber(name, phoneNumbers);
            phoneList.add(newPhoneNumber);
        } else {
            List<String> existingPhoneNumbers = foundPhoneNumber.getPhone();
            if (!existingPhoneNumbers.contains(phone)) {
                existingPhoneNumbers.add(phone);
            }
        }
    }

    @Override
    public PhoneNumber searchPhone(String name) {
        for (PhoneNumber phoneNumber : phoneList) {
            if (phoneNumber.getName().equals(name)) {
                return phoneNumber;
            }
        }
        return null;
    }

    @Override
    public void sort() {
        phoneList.sort((p1, p2) -> p1.getName().compareToIgnoreCase(p2.getName()));
    }                   

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.insertPhone("TuanAnh", "123456789");
        phoneBook.insertPhone("AnhNgoc", "987654321");
        phoneBook.insertPhone("KieuChi", "555555555");
        phoneBook.sort();

        for (PhoneNumber phoneNumber : phoneBook.phoneList) {
            System.out.println("Name: " + phoneNumber.getName() + ", Phone: " + phoneNumber.getPhone());
        }

        PhoneNumber foundPhoneNumber = phoneBook.searchPhone("Jane");
        if (foundPhoneNumber != null) {
            System.out.println("Phone number found: " + foundPhoneNumber.getPhone());
        } else {
            System.out.println("Phone number not found.");
        }
    }
}
