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
/*StringBuilder is designed for efficient string manipulation where multiple modifications
 (append, insert, delete) are needed. Its internal char[] array allows for in-place modifications
 without creating new objects.*/