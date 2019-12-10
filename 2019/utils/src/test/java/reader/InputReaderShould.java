package reader;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("InputReader should")
public class InputReaderShould {

    @Nested
    @DisplayName("on linebreak-separated input")
    class OnLineBreakSeparatedInput {

        private final String filePath = "src/test/java/reader/line-break-input";

        @Test
        @DisplayName("read the input file entirely")
        public void testReadTheInputFileEntirely() throws IOException {
            List<Integer> readInput = InputReader.readFromPathWithLineBreaks(filePath);
            assertEquals(4, readInput.size());
            assertEquals(1, readInput.get(0));
            assertEquals(22, readInput.get(1));
            assertEquals(333, readInput.get(2));
            assertEquals(4444, readInput.get(3));
        }

        @Test
        @DisplayName("throw a NoSuchFileException exception if the file does not exist")
        public void throwsNoSuchFileExceptionIfNoFileFound() {
            final String filePath = "src/test/filethatdoesnotexist";
            assertThrows(NoSuchFileException.class, () -> InputReader.readFromPathWithLineBreaks(filePath));
        }
    }

    @Nested
    @DisplayName("on comma-separated input ")
    class OnCommaSeparatedInput {

        private String filePath = "src/test/java/reader/comma-input";

        @Test
        @DisplayName("read the input file entirely")
        public void testReadTheInputFileEntirely() throws IOException {
            List<Integer> readInput = InputReader.readFromPathWithCommas(filePath);
            assertEquals(4, readInput.size());
            assertEquals(1, readInput.get(0));
            assertEquals(22, readInput.get(1));
            assertEquals(333, readInput.get(2));
            assertEquals(4444, readInput.get(3));
        }

        @Test
        @DisplayName("throw a NoSuchFileException exception if the file does not exist")
        public void throwsNoSuchFileExceptionIfNoFileFound() {
            final String filePath = "src/test/filethatdoesnotexist";
            assertThrows(NoSuchFileException.class, () -> InputReader.readFromPathWithCommas(filePath));
        }
    }

    @Nested
    @DisplayName("on linebreak-separated and comma-separated input ")
    class OnLineBreakAndCommaSeparatedInput {

        private String filePath = "src/test/java/reader/line-break-and-comma-input";

        @Test
        @DisplayName("read the input file entirely")
        public void testReadTheInputFileEntirely() throws IOException {
            List<List<String>> readInput = InputReader.readFromPathWithLineBreaksAndCommas(filePath);
            assertEquals(2, readInput.size());
            assertEquals(9, readInput.get(0).size());
            assertEquals(8, readInput.get(1).size());
            assertEquals(Arrays.asList("R75", "D30", "R83", "U83", "L12", "D49", "R71", "U7", "L72"), readInput.get(0));
            assertEquals(Arrays.asList("U62", "R66", "U55", "R34", "D71", "R55", "D58", "R83"), readInput.get(1));
        }

        @Test
        @DisplayName("throw a NoSuchFileException exception if the file does not exist")
        public void throwsNoSuchFileExceptionIfNoFileFound() {
            final String filePath = "src/test/filethatdoesnotexist";
            assertThrows(NoSuchFileException.class, () -> InputReader.readFromPathWithLineBreaksAndCommas(filePath));
        }
    }


}
