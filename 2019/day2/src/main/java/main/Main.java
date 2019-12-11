package main;

import part1.IntCodeReader;
import part2.IntCodeReaderGenerator;
import reader.InputReader;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        String filePath = "2019/day2/src/main/java/main/input";
        List<Integer> intCodeProgram = InputReader.readFromPathWithCommas(filePath);
        IntCodeReader intCodeReader = new IntCodeReader(intCodeProgram, 12, 2);
        IntCodeReaderGenerator intCodeReaderGenerator = new IntCodeReaderGenerator(intCodeProgram, 19690720);
        System.out.println("Part 1 : " + intCodeReader.valueAtFirstPositionAfterProgramHalts());
        System.out.println("Part 2 : " + intCodeReaderGenerator.findOperationWithDiscoveredInputs());
    }

}
