import javafx.util.Pair;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
 
public class Snowwhite {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
 
        LinkedHashMap<Pair<String, String>, Integer> dwarfs = new LinkedHashMap<>();
        HashMap<String, Integer> colors = new HashMap<>();
 
        String line;
        while (!"Once upon a time".equals(line=reader.readLine())) {
            String[] tokens = line.split(" <:> ");
            String dwarfName = tokens[0];
            String dwarfHatColor = tokens[1];
            Integer dwarfPhysics = Integer.parseInt(tokens[2]);
 
            Pair<String, String> dwarf = new Pair<>(dwarfName, dwarfHatColor);
 
            if (dwarfs.containsKey(dwarf)) {
                Integer oldPhysics = dwarfs.get(dwarf);
                if (dwarfPhysics > oldPhysics) {
                    dwarfs.put(dwarf, dwarfPhysics);
                }
            } else {
                dwarfs.put(dwarf, dwarfPhysics);
                colors.putIfAbsent(dwarfHatColor, 0);
                colors.put(dwarfHatColor, colors.get(dwarfHatColor) + 1);
            }
        }
 
        dwarfs.entrySet()
                .stream()
                .sorted((d1, d2) -> {
                    int result = Integer.compare(d2.getValue(), d1.getValue());
 
                    if (result == 0) {
                        result = Integer.compare(colors.get(d2.getKey().getValue()),
                                colors.get(d1.getKey().getValue()));
                    }
 
                    return result;
                })
                .forEach(d -> System.out.printf("(%s) %s <-> %d%n",
                        d.getKey().getValue(),
                        d.getKey().getKey(),
                        d.getValue()));
    }
}