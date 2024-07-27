package Core_Java.Cloning;

public class Address  implements Cloneable{
        String city;
        String state;

        public Address(String city, String state) {
            this.city = city;
            this.state = state;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone(); // Shallow copy of Address
        }

        @Override
        public String toString() {
            return city + ", " + state;
        }
}
