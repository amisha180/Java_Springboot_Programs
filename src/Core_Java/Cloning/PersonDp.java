package Core_Java.Cloning;

public class PersonDp implements Cloneable {
    String name;
    Address address;

    public PersonDp(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        PersonDp cloned = (PersonDp) super.clone();
        cloned.address = (Address) address.clone(); // Deep copy of Address
        return cloned;
    }

    @Override
    public String toString() {
        return name + " lives at " + address;
    }
}


