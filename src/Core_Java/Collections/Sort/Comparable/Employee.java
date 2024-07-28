package Core_Java.Collections.Sort.Comparable;

public class Employee implements Comparable<Employee> {
    int id;
    String name;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    int age;

    public Employee(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Employee e1){
       return  this.age-e1.age;
    }

}
