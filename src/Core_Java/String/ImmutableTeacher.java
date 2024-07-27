package Core_Java.String;

import java.util.List;
import java.util.ArrayList;

    public final class ImmutableTeacher {
        private final int age;
        private final List<String> studentList;
        public ImmutableTeacher(int value, List<String> studentList) {
            this.age = value;
            this.studentList = new ArrayList<>(studentList); // Deep copy of mutable object
        }
        public int getValue() {
            return age;
        }
        public List<String> getList() {
            return new ArrayList<>(studentList); // Return a deep copy
        }
    }
