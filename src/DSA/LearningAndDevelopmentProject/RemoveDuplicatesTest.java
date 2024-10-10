package DSA.LearningAndDevelopmentProject;

import java.util.LinkedList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RemoveDuplicatesTest {
        private LinkedList<Integer> list;

        @BeforeEach
        public void setUp() {
            list = new LinkedList<>();
        }

        @Test
        public void testCase1() {
            RemoveDuplicates.removeDuplicates(list);
            assertTrue(list.isEmpty());
        }

        @Test
        public void testCase2() {
            list.add(1);
            RemoveDuplicates.removeDuplicates(list);
            assertEquals(1, list.size());
        }

        @Test
        public void testCase3() {
            list.add(1);
            list.add(2);
            list.add(3);
            RemoveDuplicates.removeDuplicates(list);
            assertEquals(3, list.size());
        }

        @Test
        public void testCase6() {
            list.add(1);
            list.add(2);
            list.add(3);
            list.add(2);
            list.add(4);
            list.add(1);
            list.add(5);
            RemoveDuplicates.removeDuplicates(list);
            assertEquals(5, list.size());
        }

}
