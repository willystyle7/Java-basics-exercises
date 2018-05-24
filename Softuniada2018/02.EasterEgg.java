package Softuniada2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EasterEgg {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int width = 5 * n;
        StringBuilder sb = new StringBuilder();
        sb.append(repeatSymbol(".", 2 * n))
                .append(repeatSymbol("*", n))
                .append(repeatSymbol(".", 2 * n))
                .append(System.lineSeparator());
        for (int i = 1; i <= n / 2; i++) {
            sb.append(repeatSymbol(".", 2 * n - 2 * i))
                    .append(repeatSymbol("*", i))
                    .append(repeatSymbol("+", n + 2 * i))
                    .append(repeatSymbol("*", i))
                    .append(repeatSymbol(".", 2 * n - 2 * i))
                    .append(System.lineSeparator());
        }
        for (int i = 1; i <= n / 2; i++) {
            sb.append(repeatSymbol(".", n - i))
                    .append(repeatSymbol("*", 2))
                    .append(repeatSymbol("=", width - 2 * n - 4 + i * 2))
                    .append(repeatSymbol("*", 2))
                    .append(repeatSymbol(".", n - i))
                    .append(System.lineSeparator());
        }
        sb.append(repeatSymbol(".", n / 2))
                .append(repeatSymbol("*", 2))
                .append(repeatSymbol("~", (width - 16 - n) / 2))
                .append("HAPPY EASTER")
                .append(repeatSymbol("~", (width - 16 - n) / 2))
                .append(repeatSymbol("*", 2))
                .append(repeatSymbol(".", n / 2))
                .append(System.lineSeparator());
        for (int i = 1; i <= n / 2; i++) {
            sb.append(repeatSymbol(".", n / 2 - 1 + i))
                    .append(repeatSymbol("*", 2))
                    .append(repeatSymbol("=", width - n - 2 - 2 * i))
                    .append(repeatSymbol("*", 2))
                    .append(repeatSymbol(".", n / 2 - 1 + i))
                    .append(System.lineSeparator());
        }
        for (int i = 1; i <= n / 2; i++) {
            sb.append(repeatSymbol(".", n - 2 + 2 * i))
                    .append(repeatSymbol("*", n / 2 + 1 - i))
                    .append(repeatSymbol("+", 2 * n - 2 * (i - 1)))
                    .append(repeatSymbol("*", n / 2 + 1 - i))
                    .append(repeatSymbol(".", n - 2 + 2 * i))
                    .append(System.lineSeparator());
        }
        sb.append(repeatSymbol(".", 2 * n))
                .append(repeatSymbol("*", n))
                .append(repeatSymbol(".", 2 * n))
                .append(System.lineSeparator());
        System.out.println(sb);
    }

    private static String repeatSymbol(String symbol, int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(symbol);
        }
        return sb.toString();
    }
}