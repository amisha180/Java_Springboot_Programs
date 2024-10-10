package Core_Java.String;

public class StringBufferProgram {
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer("Amisha");
		sb.append("Kumari");
		System.out.println(sb);
		//all the methods are same as StringBuilder
	}
}
/*
Key Differences between StringBuilder and StringBuffer:

Thread Safety:

StringBuffer is thread-safe because it is synchronized. This means that multiple threads can safely access
and modify a StringBuffer instance, but only one thread can modify the object at a time, due to the
synchronized methods.
StringBuilder is not thread-safe, meaning it does not use synchronization. It is designed for use in
single-threaded environments where you don't need to worry about multiple threads modifying the same
instance concurrently.

Performance:

StringBuffer is slower because of the overhead of synchronization. Each method call that modifies the
object is synchronized, which adds a performance cost in multithreaded environments.
StringBuilder is faster because it doesn't use synchronization. This makes it the preferred choice in
single-threaded environments where thread safety is not a concern.

Use Case:

StringBuffer is preferred in multithreaded program
StringBuilder is preferred in single-threaded programs
 */