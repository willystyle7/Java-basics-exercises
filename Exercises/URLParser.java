import java.util.Scanner;

public class URLParser {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String url = scan.nextLine();
        String protocol = "";
        if (url.contains(":")) {
            protocol = url.substring(0, url.indexOf(":"));
            url = url.substring(url.indexOf(":") + 3);
        }
        String server = "";
        if (url.contains("/")) {
            server = url.substring(0, url.indexOf("/"));
        } else {
            server = url;
        }
        String resource = url.contains("/") ? url.substring(url.indexOf("/") + 1) : "";

        System.out.printf("[protocol] = \"%s\"%n", protocol);
        System.out.printf("[server] = \"%s\"%n", server);
        System.out.printf("[resource] = \"%s\"", resource);
    }
}
