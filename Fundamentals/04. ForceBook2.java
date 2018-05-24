import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
 
public class Ex04ForceBook {
    static class ForceUser {
        private String forceUser;
        private String forceSide;
 
        public ForceUser(String forceUser, String forceSide) {
            this.forceUser = forceUser;
            this.forceSide = forceSide;
        }
 
        public String getForceUser() {
            return forceUser;
        }
 
        public void changeForceSide(String forceSide) {
            this.forceSide = forceSide;
            System.out.println(String.format("%s joins the %s side!", this.forceUser, this.forceSide));
        }
 
        public String getForceSide() {
            return forceSide;
        }
 
        @Override
        public String toString() {
            return String.format("! %s", this.forceUser);
        }
    }
 
    private static List<ForceUser> forceUsers;
    private static Pattern sideUserPattern = Pattern.compile("(?<forceSide>.+)\\s+\\|\\s+(?<forceUser>.+)");
    private static Pattern changeSidePattern = Pattern.compile("(?<forceUser>.+)\\s+->\\s+(?<forceSide>.+)");
 
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        forceUsers = new ArrayList<>();
 
        String input;
        while (! "Lumpawaroo".equals(input = reader.readLine())) {
            Matcher sideUserMatcher = sideUserPattern.matcher(input);
            Matcher changeSideMatcher = changeSidePattern.matcher(input);
            Optional<ForceUser> forceUserOptional;
 
            if (sideUserMatcher.find()) {
                String forceUser = sideUserMatcher.group("forceUser");
                String forceSide = sideUserMatcher.group("forceSide");
                forceUserOptional = getForceUser(forceUser);
                if (! forceUserOptional.isPresent()) {
                    forceUsers.add(new ForceUser(forceUser, forceSide));
                }
            }
 
            if (changeSideMatcher.find()) {
                String forceUser = changeSideMatcher.group("forceUser");
                String forceSide = changeSideMatcher.group("forceSide");
                forceUserOptional = getForceUser(forceUser);
                if (forceUserOptional.isPresent()) {
                    forceUsers.stream().filter(e -> e.getForceUser().equals(forceUser))
                            .forEach(u -> u.changeForceSide(forceSide));
                } else {
                    forceUsers.add(new ForceUser(forceUser, forceSide));
                    System.out.println(String.format("%s joins the %s side!", forceUser, forceSide));
                }
            }
        }
 
        Map<String, List<ForceUser>> result =
                forceUsers.stream().collect(Collectors.groupingBy(ForceUser::getForceSide));
 
        result.entrySet().stream()
                .filter(s -> s.getValue().size() > 0)
                .sorted((s1, s2) -> {
                    int index = Integer.compare(s2.getValue().size(), s1.getValue().size());
                    return (index != 0) ? index : s1.getKey().compareTo(s2.getKey());
                })
                .forEach(s -> {
                    System.out.println(String.format("Side: %s, Members: %d", s.getKey(), s.getValue().size()));
                    s.getValue().stream()
                            .sorted(Comparator.comparing(ForceUser::getForceUser))
                            .forEach(System.out::println);
                });
    }
 
    private static Optional<ForceUser> getForceUser(String forceUser) {
        return forceUsers.stream().filter(e -> e.getForceUser().equals(forceUser)).findAny();
    }
}