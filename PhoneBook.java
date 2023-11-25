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
            List<String> existingPhoneNumbers = foundPhoneNumber.phone();
            if (!existingPhoneNumbers.contains(phone)) {
                existingPhoneNumbers.add(phone);
            }
        }
    }

    @Override
    public PhoneNumber searchPhone(String name) {
        for (PhoneNumber phoneNumber : phoneList) {
            if (phoneNumber.name().equals(name)) {
                return phoneNumber;
            }
        }
        return null;
    }

    @Override
    public void sort() {
        phoneList.sort((p1, p2) -> p1.name().compareToIgnoreCase(p2.name()));
    }

    public List<PhoneNumber> getPhoneList() {
        return phoneList;
    }
}
