package Core_Java.Mutithreading;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.Arrays;

public class ThreadDumpExample {
    public static void main(String[] args) {
        // Capture thread dump
        takeThreadDump();
    }

    public static void takeThreadDump() {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(true, true);

        for (ThreadInfo threadInfo : threadInfos) {
            System.out.println(threadInfo.toString());
            Arrays.stream(threadInfo.getStackTrace())
                    .forEach(System.out::println);
        }
    }
}

