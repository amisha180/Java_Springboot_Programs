package Core_Java.String;

import java.util.Date;

final class ImmutablePerson {
    private final String name;
    private final int age;
    private final Date birthDate;
    public ImmutablePerson( String name,int age,Date birthDate){
        this.name = name;
        this.age = age;
        this.birthDate = new Date(birthDate.getTime());    //defensive copy of mutable object
    }
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public Date getBirthDate(){
        return new Date(birthDate.getTime());  //defensive copy of mutable object
    }
}
