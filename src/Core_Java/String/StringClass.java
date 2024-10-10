package Core_Java.String;

public class StringClass {
    public static void main(String[] args) {
        String s = "Amisha";
        System.out.println(s.charAt(2));
		System.out.println(s.indexOf('i'));
		System.out.println(s.concat(s));
		System.out.println(s.substring(1,4)+s.substring(5));
		System.out.println(s.replace('m', 'l'));
		System.out.println(s.isEmpty());
		System.out.println(s.contains("m"));
		System.out.println(s.equals("Amisha"));
		System.out.println(s.equalsIgnoreCase("AMisha"));
		System.out.println(s.valueOf("2"));
		System.out.println(s.trim());
        String x = "Kumari";
        String y = "Kumari";
        String z = new String("Kumari");
        System.out.println(x==z);
        System.out.println(x.compareTo(z));
        System.out.println(z.compareTo(x));
    }
}
/*
To make class Immutable -
Steps - 1.Make class final
        2.Make variables private and final
        3.Initialize all the variables with constructor
        4.No setter methods only getter methods
        5.Deep copy of mutable objects.
 */