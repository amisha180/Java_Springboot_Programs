package DSA.LearningAndDevelopmentProject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

public class FindMiddleElementTest {

    LinkedList<Integer> lists = new LinkedList<>();

    @Test
    public void testCase1() {
        assertNull(FindMiddleElement.findMiddle(lists));
    }

    @Test
    public void testCase2() {
        lists.add(1);
        assertEquals(1, FindMiddleElement.findMiddle(lists));
    }

    @Test
    public void testCase3() {
        lists.add(1);
        lists.add(2);
        assertEquals(2, FindMiddleElement.findMiddle(lists));
    }

    @Test
    public void testCase4() {
        lists.add(1);
        lists.add(2);
        lists.add(3);
        assertEquals(2, FindMiddleElement.findMiddle(lists));
    }

    @Test
    public void testCase5() {
        lists.add(1);
        lists.add(2);
        lists.add(3);
        lists.add(4);
        assertEquals(3, FindMiddleElement.findMiddle(lists));
    }

    @Test
    public void testCase6() {
        lists.add(1);
        lists.add(2);
        lists.add(3);
        lists.add(4);
        lists.add(5);
        lists.add(6);
        lists.add(7);
        assertEquals(4, FindMiddleElement.findMiddle(lists));
    }
}

