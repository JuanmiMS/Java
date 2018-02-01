package jar;

public class RemoveSpaces {

    public static String noSpace(final String x) {
        return x.replaceAll("\\s+","");
    }
}