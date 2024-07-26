package Core_Java.Collections.HashMap;
import java.util.HashMap;
    public class HashMapExp {
        public static void main(String[] args) {
            HashMap<Employee, String> map = new HashMap<>();
            System.out.println(map.put(new Employee(1,"amy"), "engineer"));
            System.out.println(map.put(new Employee(2,"misa"), "Actor"));
            System.out.println(map.put(new Employee(1,"amy"), "engineer2"));
            map.entrySet().forEach(e->System.out.println(e.getKey().id+" "+e.getKey().name+" "+e.getValue()));
            System.out.println();
        }

}
