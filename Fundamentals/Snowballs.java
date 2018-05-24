import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
 
public class Snowballs {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
 
        int n = Integer.parseInt(reader.readLine());
 
        String output = "";
        BigInteger maxSnowballValue = new BigInteger(String.valueOf(-1));
 
        for (int i = 0; i < n; i++) {
            int snowballSnow = Integer.parseInt(reader.readLine());
            int snowballTime = Integer.parseInt(reader.readLine());
            int snowballQuality = Integer.parseInt(reader.readLine());
 
            BigInteger currentValue = new BigInteger(String.valueOf(snowballSnow))
                    .divide(BigInteger.valueOf(snowballTime))
                    .pow(snowballQuality);
 
            if (currentValue.compareTo(maxSnowballValue) > 0) {
                maxSnowballValue = new BigInteger(String.valueOf(currentValue));
                output = String.format("%s : %s = %s (%s)", snowballSnow, snowballTime, currentValue, snowballQuality);
            }
        }
 
        System.out.println(output);
    }
}