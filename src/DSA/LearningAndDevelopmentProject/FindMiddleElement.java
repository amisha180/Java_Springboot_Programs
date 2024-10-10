package DSA.LearningAndDevelopmentProject;
import java.util.LinkedList;


public class FindMiddleElement {

    public static Integer findMiddle(LinkedList<Integer> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }

        int slowIndex = 0;
        int fastIndex = 0;

        while (fastIndex < list.size() && fastIndex + 1 < list.size()) {
            slowIndex++;
            fastIndex += 2;
        }

        return list.get(slowIndex);
    }
}
