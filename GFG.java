// Java program to demonstrate working of
// split(regex, limit) with small limit
public class GFG {

    public static void main(String args[])
    {

        // Custom input string
        String s = "2, Doi Bo Mountain, Lao Cai, ";

        // taking small limit
        String[] arr = s.split(", ");
        System.out.println(arr.length);
        for (String a : arr)
            System.out.println(a);
    }
}