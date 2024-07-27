package Core_Java.String;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

    public final class ImmutableClass {
        private final int value;
        private final List<String> list;
        public ImmutableClass(int value, List<String> list) {
            this.value = value;
            this.list = new ArrayList<>(list); // Deep copy of mutable object
        }
        public int getValue() {
            return value;
        }
        public List<String> getList() {
            return new ArrayList<>(list); // Return a copy
        }
    }
