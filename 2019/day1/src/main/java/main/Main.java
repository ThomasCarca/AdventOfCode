package main;

import reader.InputReader;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        String filePath = "2019/day1/src/main/java/main/input";
        List<Integer> masses = InputReader.readFromPathWithLineBreaks(filePath);
        part1.FuelCounterUpper fuelCounterUpperPart1 = new part1.FuelCounterUpper(masses);
        part2.FuelCounterUpper fuelCounterUpperPart2 = new part2.FuelCounterUpper(masses);
        System.out.println("Part 1 : " + fuelCounterUpperPart1.processTotalFuel());
        System.out.println("Part 2 : " + fuelCounterUpperPart2.processTotalFuel());
    }

}
