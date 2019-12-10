package part2;

import java.util.List;

public class FuelCounterUpper {
    private List<Integer> masses;

    public FuelCounterUpper(List<Integer> masses) {
        this.masses = masses;
    }

    public Long processTotalFuel() {
        Long totalFuel = masses.stream()
                .map(this::massToTotalFuel)
                .reduce(Long::sum).get();
        return totalFuel;
    }

    private Long massToTotalFuel(Integer mass) {
        long fuel = massToFuel(mass);
        if (fuel < 0) return 0L;
        return fuel + massToTotalFuel((int) fuel);
    }

    private long massToFuel(Integer mass) {
        return (long) Math.floor(mass / 3) - 2;
    }
}
