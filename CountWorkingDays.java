//import jdk.nashorn.internal.runtime.ParserException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
//import java.util.Date;
import java.util.Scanner;

public class CountWorkingDays {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<LocalDate> holidays = new ArrayList<>();
        holidays.add(LocalDate.of(1970, 1, 1));
        holidays.add(LocalDate.of(1970, 3, 3));
        holidays.add(LocalDate.of(1970, 5, 1));
        holidays.add(LocalDate.of(1970, 5, 6));
        holidays.add(LocalDate.of(1970, 5, 24));
        holidays.add(LocalDate.of(1970, 9, 6));
        holidays.add(LocalDate.of(1970, 9, 22));
        holidays.add(LocalDate.of(1970, 10, 1));
        holidays.add(LocalDate.of(1970, 12, 24));
        holidays.add(LocalDate.of(1970, 12, 25));
        holidays.add(LocalDate.of(1970, 12, 26));

        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String dateStr = scan.nextLine();
        LocalDate firstDate = LocalDate.parse(dateStr, df);
        dateStr = scan.nextLine();
        LocalDate secondDate = LocalDate.parse(dateStr, df);
        int count = 0;
        int total = 0;
        for (LocalDate date = firstDate; date.isBefore(secondDate.plusDays(1)); date = date.plusDays(1)) {
            if(date.getDayOfWeek().getValue() == 6 || date.getDayOfWeek().getValue() == 7) {
                count++;
            } else {
                for (LocalDate holiday : holidays) {
                    if (holiday.getDayOfMonth() == date.getDayOfMonth() &&
                            holiday.getMonth() == date.getMonth()) {
                        count++;
                        break;
                    }
                }
            }
            total++;
        }
        System.out.println(total - count);
    }
}
