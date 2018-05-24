import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Ex01PadawanEquipment {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Double money = Double.valueOf(reader.readLine());
        Integer studentCount = Integer.valueOf(reader.readLine());
        Double lightSaberPrice = Double.valueOf(reader.readLine());
        Double robePrice = Double.valueOf(reader.readLine());
        Double beltPrice = Double.valueOf(reader.readLine());
 
        Integer lightSaberCount = (int) Math.ceil(studentCount * 1.10);
        Integer robeCount = studentCount;
        Integer beltCount = (studentCount == 0) ? 0 : studentCount - (studentCount / 6);
 
        Double moneyNeeded = (lightSaberPrice * lightSaberCount) +
                (robePrice * robeCount) + (beltPrice * beltCount);
 
 
        Double diff = money - moneyNeeded;
 
        if (diff >= 0) {
            System.out.println(String.format("The money is enough - it would cost %.2flv.", moneyNeeded));
        } else {
            System.out.println(String.format("Ivan Cho will need %.2flv more.", Math.abs(diff)));
        }
 
    }
}