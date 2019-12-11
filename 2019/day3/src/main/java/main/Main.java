package main;

import part1.Circuit;
import part1.CircuitMeasurement;
import part1.Wire;
import reader.InputReader;

import java.io.IOException;
import java.util.List;

public class Main {

    private final static String inputFile = "2019/day3/src/main/java/main/input";

    public static void main(String[] args) throws IOException {
        List<List<String>> wiresInstructions = InputReader.readFromPathWithLineBreaksAndCommas(inputFile);

        Wire wire1 = new Wire(wiresInstructions.get(0));
        Wire wire2 = new Wire(wiresInstructions.get(1));


        Circuit circuit = new Circuit(wire1, wire2);

        CircuitMeasurement circuitMeasurement = new CircuitMeasurement(circuit);

        // SLOW. Implementation should be optimized.
        System.out.println("Part 1 : " + circuitMeasurement.distanceBetweenCenterAndClosestIntersection());

    }

}
