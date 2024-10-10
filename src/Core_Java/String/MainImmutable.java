package Core_Java.String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class MainImmutable {
    public static void main(String[] args) {
        //ImmutablePerson
        Date birthDate = new Date();
        ImmutablePerson person = new ImmutablePerson("Ram",12,birthDate);
        System.out.println(person.getName());
        System.out.println(person.getAge());
        System.out.println(person.getBirthDate());

        birthDate.setTime(birthDate.getTime() + 1000000000L);   // Attempt to modify the original date
        System.out.println(person.getBirthDate());   // Date in the event remains unchanged

        //ImmutableTeacher
        List<String> list = Arrays.asList("rahul","tina","karina","aishwarya");
        ImmutableTeacher teacher = new ImmutableTeacher(34,list);
        System.out.println(teacher.getValue());
        System.out.println(teacher.getList());

        // Attempt to modify the student list through the reference
        //list.add("rajesh");  //// Throws UnsupportedOperationException
        System.out.println(teacher.getList());

    }
}
