package main;

import part1.FuelCounterUpper;
import reader.InputReader;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        String filePath = "2019/src/main/input";
        List<Integer> masses = InputReader.readFromPath(filePath);
        FuelCounterUpper fuelCounterUpper = new FuelCounterUpper(masses);
        System.out.println(fuelCounterUpper.processTotalFuel());
    }

}
