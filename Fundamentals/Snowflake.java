import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
 
public class Snowflake {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
 
        final Pattern surface = Pattern.compile("^[^A-Za-z0-9]+$");
        final Pattern mantle = Pattern.compile("^[\\d_]+$");
        final Pattern core = Pattern.compile("^[^A-Za-z0-9]+[\\d_]+(?<core>[A-Za-z]+)[\\d_]+[^A-Za-z0-9]+$");
 
        int length = 0;
 
        for (int i = 0; i < 5; i++) {
            String line = reader.readLine();
 
            if (i == 0 || i == 4) {
                Matcher matcher = surface.matcher(line);
 
                if (!matcher.find()) {
                    System.out.println("Invalid");
                    return;
                }
            } else if (i == 1 || i == 3) {
                Matcher matcher = mantle.matcher(line);
 
                if (!matcher.find()) {
                    System.out.println("Invalid");
                    return;
                }
            } else {
                Matcher matcher = core.matcher(line);
 
                if (!matcher.find()) {
                    System.out.println("Invalid");
                    return;
                } else {
                    length = matcher.group("core").length();
                }
            }
        }
 
        System.out.println("Valid");
        System.out.println(length);
    }
}