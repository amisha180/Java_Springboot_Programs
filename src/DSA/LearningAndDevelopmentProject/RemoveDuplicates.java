package DSA.LearningAndDevelopmentProject;
import java.util.LinkedList;
import java.util.HashSet;
public class RemoveDuplicates {
        public static void removeDuplicates(LinkedList<Integer> list) {
            if (list == null || list.isEmpty()) {
                return;
            }

            HashSet<Integer> set = new HashSet<>();

           for(int i=0;i< list.size();i++) {
                if (set.contains(list.get(i))) {
                    list.remove(i);
                } else {
                    set.add(list.get(i));
                }
            }
        }
    }
