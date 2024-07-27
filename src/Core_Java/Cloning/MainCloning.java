package Core_Java.Cloning;

public class MainCloning {
    public static void main(String[] args) throws CloneNotSupportedException {
        try {
            Address address = new Address("New York", "NY");
            PersonDp person1 = new PersonDp("John", address);
            PersonDp person2 = (PersonDp) person1.clone();

            System.out.println(person1);
            System.out.println(person2);

            person2.name = "Jane";
            person2.address.city = "Los Angeles";

            System.out.println("Deep copy");
            System.out.println(person1); // Address is modified in both objects
            System.out.println(person2);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
