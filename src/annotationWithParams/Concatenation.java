package annotationWithParams;

public class Concatenation {

    @Concatenate(a = "hello", b = "mars")
    public static void concat(String a, String b) {
        System.out.println(a + " " + b);
    }
}
