package part1;

import java.util.List;

public class FuelCounterUpper {
    private List<Integer> masses;

    public FuelCounterUpper(List<Integer> masses) {
        this.masses = masses;
    }

    public Long processTotalFuel() {
        Long totalFuel = masses.stream()
                .map(this::massToFuel)
                .reduce(Long::sum).get();
        return totalFuel;
    }

    private Long massToFuel(Integer mass) {
        return (long) Math.floor(mass / 3) - 2;
    }
}
