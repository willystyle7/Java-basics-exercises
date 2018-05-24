import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
 
public class Ex04ForceBook01 {
    private static Pattern sideUserPattern = Pattern.compile("(?<forceSide>.+)\\s+\\|\\s+(?<forceUser>.+)");
    private static Pattern changeSidePattern = Pattern.compile("(?<forceUser>.+)\\s+->\\s+(?<forceSide>.+)");
    private static HashMap<String, String> users = new HashMap<>();
 
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
 
        String input;
        while (! "Lumpawaroo".equals(input = reader.readLine())) {
            joinSide(input);
            changeSide(input);
        }
 
        TreeMap<String, TreeSet<String>> forceSide = groupByForceSIde();
        printResult(forceSide);
 
    }
 
    private static void printResult(TreeMap<String, TreeSet<String>> forceSide) {
        forceSide.entrySet().stream()
                .filter(s -> s.getValue().size() > 0)
                .sorted((s1, s2) -> Integer.compare(s2.getValue().size(), s1.getValue().size()))
                .forEach(s -> {
                    System.out.println(String.format("Side: %s, Members: %d", s.getKey(), s.getValue().size()));
                    s.getValue().forEach(u -> {
                        System.out.println(String.format("! %s", u));
                    });
                });
    }
 
    private static TreeMap<String, TreeSet<String>> groupByForceSIde() {
        TreeMap<String, TreeSet<String>> forceSide = new TreeMap<>();
        for (Map.Entry<String, String> sides : users.entrySet()) {
            forceSide.putIfAbsent(sides.getValue(), new TreeSet<>());
            forceSide.get(sides.getValue()).add(sides.getKey());
        }
        return forceSide;
    }
 
    private static void changeSide(String input) {
        Matcher changeSideMatcher = changeSidePattern.matcher(input);
        if (changeSideMatcher.find()) {
            String forceUser = changeSideMatcher.group("forceUser");
            String forceSide = changeSideMatcher.group("forceSide");
            users.put(forceUser, forceSide);
            System.out.println(String.format("%s joins the %s side!", forceUser, forceSide));
        }
    }
 
    private static void joinSide(String input) {
        Matcher sideUserMatcher = sideUserPattern.matcher(input);
        if (sideUserMatcher.find()) {
            String forceUser = sideUserMatcher.group("forceUser");
            String forceSide = sideUserMatcher.group("forceSide");
            users.putIfAbsent(forceUser, forceSide);
        }
    }
}