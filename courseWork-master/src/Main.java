import java.util.HashMap;
import java.util.Map;

public class Main {
    public final Map<String, Employee> map;

    public Main() {
        this.map = new HashMap<>();
    }

    public void addEmploee(String name, String lastName, String patronomic, int departament, int salary) {
        String key = name + " " + lastName;
        if (key == null || map.containsKey(key)) {
            throw new Exs();
        } else {
            map.put(key, new Employee(name, lastName, patronomic, departament, salary));
        }
    }

    public void removeEmploee(String name, String lastName) {
        String key = name + " " + lastName;
        if (map.containsKey(key)) {
            map.remove(key);
            System.out.println("Сотрудник удален: " + key);
        } else {
            System.out.println("Сотрудник не найден" + key);
        }
    }

    public Employee foundEmployee(String name, String lastName) {
        String key = name + " " + lastName;
        return map.get(key);
    }

    public void printAllEmployees() {
        System.out.println("Список всех сотрудников:");
        for (String key : map.keySet()) {
            System.out.println(key);
        }
    }


    public static void main(String[] args) {
        Main main = new Main();
        main.addEmploee("Алексей", "Глотов", "Дмитриевич", 1, 45687);
        main.addEmploee("Игорь", "Акакий", "Игоревич", 1, 52000);
        main.addEmploee("Никита", "Акакий", "Игоревич", 3, 52000);
        main.removeEmploee("Игорь", "Акакий");
        Employee foundEmployee = main.foundEmployee("Игорь", "Акакий");
        if (foundEmployee != null) {
            System.out.println("Найден сотрудник: " + foundEmployee.getName() + " " + foundEmployee.getSurname());
        } else {
            System.out.println("Сотрудник не найден");
        }
        main.printAllEmployees();
    }
}