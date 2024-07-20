package Core_Java.Collections.HashMap;

import java.util.Objects;

public class Employee {
    int id;
    String name;
    Employee(int id , String name){
        this.id = id;
        this.name = name;
    }
    @Override
    public int hashCode(){
       return Objects.hash(id,name);
    }
    @Override
    public boolean equals(Object obj){
        if(this==obj){
            return true;
        }
        if(obj==null && getClass()!=obj.getClass())
            return false;
        Employee emp = (Employee) obj;
        return emp.id ==id && emp.name.equals(name);
    }
}
