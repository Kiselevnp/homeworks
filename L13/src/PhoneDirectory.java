import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneDirectory {
    private final Map<String, List<String>> directory;

    public PhoneDirectory() {
        this.directory = new HashMap<>();
    }

    public void add(String surname, String phoneNumber) {
        directory.putIfAbsent(surname, new ArrayList<>());
        directory.get(surname).add(phoneNumber);
    }

    public List<String> get(String surname) {
        return directory.getOrDefault(surname, new ArrayList<>());
    }

    public static void main(String[] args) {
        PhoneDirectory phoneDirectory = new PhoneDirectory();

        phoneDirectory.add("Ivanov", "89998887766");
        phoneDirectory.add("Petrov", "89997776655");
        phoneDirectory.add("Ivanov", "89996665544");
        phoneDirectory.add("Sidorov", "89995554433");

        System.out.println("Телефоны Иванова: " + phoneDirectory.get("Ivanov"));
        System.out.println("Телефоны Петрова: " + phoneDirectory.get("Petrov"));
        System.out.println("Телефоны Сидорова: " + phoneDirectory.get("Sidorov"));
    }
}
