package helper;

import helper.InputReader;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("InputReader should")
public class InputReaderShould {

    @Test
    @DisplayName("read the input file entirely")
    public void testReadTheInputFileEntirely() throws IOException {
        String filePath = "src/test/helper/input";
        List<Integer> readInput = InputReader.readFromPath(filePath);
        assertEquals(4, readInput.size());
        assertEquals(1, readInput.get(0));
        assertEquals(22, readInput.get(1));
        assertEquals(333, readInput.get(2));
        assertEquals(4444, readInput.get(3));
    }

    @Test
    @DisplayName("throw a NoSuchFileException exception if the file does not exist")
    public void throwsNoSuchFileExceptionIfNoFileFound() throws IOException {
        String filePath = "src/test/filethatdoesnotexist";
        assertThrows(NoSuchFileException.class, () -> {
            InputReader.readFromPath(filePath);
        });
    }


}
