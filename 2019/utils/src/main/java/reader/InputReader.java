package reader;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputReader {

    public static List<Integer> readFromPathWithLineBreaks(String filePath) throws IOException {
        return Files.readAllLines(Paths.get(filePath), StandardCharsets.UTF_8)
                .stream()
                .mapToInt(Integer::parseInt)
                .mapToObj(Integer::valueOf)
                .collect(Collectors.toList());
    }

    public static List<Integer> readFromPathWithCommas(String filePath) throws IOException {
        return Arrays.stream(Files.readString(Paths.get(filePath), StandardCharsets.UTF_8)
                .split(","))
                .mapToInt(Integer::parseInt)
                .mapToObj(Integer::valueOf)
                .collect(Collectors.toList());
    }

    public static List<List<String>> readFromPathWithLineBreaksAndCommas(String filePath) throws IOException {
        return Files.readAllLines(Paths.get(filePath), StandardCharsets.UTF_8).stream()
                .map(s -> Arrays.asList(s.split(",")))
                .collect(Collectors.toList());
    }
}
