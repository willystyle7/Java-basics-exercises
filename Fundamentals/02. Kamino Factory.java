import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
 
public class Ex02KaminoFactory {
    static class Sequence {
        private Integer sequenceNumber;
        private Integer startIndex;
        private Integer length;
        private Integer sum;
        private Integer[] sequence;
 
        public Sequence(Integer sequenceNumber, Integer startIndex, Integer length, Integer sum, Integer[] sequence) {
            this.sequenceNumber = sequenceNumber;
            this.startIndex = startIndex;
            this.length = length;
            this.sum = sum;
            this.sequence = sequence;
        }
 
        public Integer getStartIndex() {
            return startIndex;
        }
 
        public Integer getLength() {
            return length;
        }
 
        public Integer getSum() {
            return sum;
        }
 
        @Override
        public String toString() {
            StringBuilder output = new StringBuilder();
            output.append(String.format("Best DNA sample %d with sum: %d.%n",this.sequenceNumber,this.sum));
            output.append(Arrays.stream(this.sequence).map(String::valueOf).collect(Collectors.joining(" ")));
            return output.toString();
        }
    }
 
    private static List<Sequence> sequences = new ArrayList<>();
 
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Integer length = Integer.valueOf(reader.readLine());
 
 
        Integer sequenceCount = 1;
 
        String input;
        while (! "Clone them!".equals(input = reader.readLine())) {
            Integer[] numbers = Arrays.stream(input.split("!"))
                    .filter(e -> ! e.equals("")).map(Integer::valueOf).toArray(Integer[]::new);
 
            Integer startIndex = 0;
            Integer bestLength = 1;
            Integer currentLength = 1;
 
            for (int i = 0; i < numbers.length - 1; i++) {
                if (Objects.equals(numbers[i], 1) && Objects.equals(numbers[i + 1], 1)) {
                    currentLength++;
                    if (i == numbers.length - 2 && currentLength > bestLength) {
                        bestLength = currentLength;
                        startIndex = i - currentLength + 2;
                    }
                } else if (currentLength > bestLength) {
                    bestLength = currentLength;
                    startIndex = i - currentLength + 1;
                    currentLength = 1;
                } else {
                    currentLength = 1;
                }
 
            }
 
            Integer sum = Arrays.stream(numbers).reduce(0, (a, b) -> a + b);
            sequences.add(new Sequence(sequenceCount, startIndex, length, sum, numbers));
 
            sequenceCount++;
        }
 
 
        Optional<Sequence> best = sequences.stream()
                .sorted((a, b) -> {
                    int index = Integer.compare(b.getLength(),a.getLength());
                    index = (index != 0) ? index : Integer.compare(a.getStartIndex(),b.getStartIndex());
                    return (index != 0) ? index : Integer.compare(b.getSum(),a.getSum());
                }).findAny();
 
        best.ifPresent(sequence -> System.out.println(sequence.toString()));
 
 
 
    }
}