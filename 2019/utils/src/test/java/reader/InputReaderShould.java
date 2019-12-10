package reader;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.NoSuchFileException;
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


}
