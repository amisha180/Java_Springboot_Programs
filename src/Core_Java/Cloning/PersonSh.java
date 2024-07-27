package Core_Java.Cloning;

public class PersonSh implements Cloneable {
    String name;
    Address address;

    public PersonSh(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
      return  super.clone();
    }

    @Override
    public String toString() {
        return name + " lives at " + address;
    }
}

