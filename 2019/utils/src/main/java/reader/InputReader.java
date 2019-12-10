package reader;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputReader {

    public static List<Integer> readFromPathWithLineBreaks(String filePath) throws IOException {
        ArrayList<Integer> input = new ArrayList<>();
        List<Integer> readLines = Files.readAllLines(Paths.get(filePath), StandardCharsets.UTF_8)
                .stream()
                .mapToInt(Integer::parseInt)
                .mapToObj(Integer::valueOf)
                .collect(Collectors.toList());
        return readLines;
    }

    public static List<Integer> readFromPathWithCommas(String filePath) throws IOException {
        ArrayList<Integer> input = new ArrayList<>();
        List<Integer> readLines = Arrays.stream(Files.readString(Paths.get(filePath), StandardCharsets.UTF_8)
                .split(","))
                .mapToInt(Integer::parseInt)
                .mapToObj(Integer::valueOf)
                .collect(Collectors.toList());
        return readLines;
    }
}
