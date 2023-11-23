package neww;

import java.util.List;

public class PhoneNumber {
    private String name;
    private List<String> phone;

    public PhoneNumber(String name, List<String> phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getPhone() {
        return phone;
    }

    public void setPhone(List<String> phone) {
        this.phone = phone;
    }
}
