package Core_Java.String;
import java.util.*;

public class StringBuilderProgram {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder("Hello ");
		sb.append(" java");
		sb.insert(6, "misu");
		sb.replace(6,9,"tryme");
		sb.delete(2, 4);
		System.out.println(sb.length());
		sb = sb.reverse();
		System.out.println(sb);
	}
}
