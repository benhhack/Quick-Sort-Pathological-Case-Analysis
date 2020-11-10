package cases;

public class Result {

    private String name;
    private double sortedness;
    private String averageExecutionTime;

    public String getName() {
        return name;
    }

    public double getSortedness() {
        return sortedness;
    }

    public String getAverageExecutionTime() {
        return averageExecutionTime;
    }

    public Result(String name, double sortedness, String averageExecutionTime) {
        this.name = name;
        this.sortedness = sortedness;
        this.averageExecutionTime = averageExecutionTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Result result = (Result) o;
        return Double.compare(result.sortedness, sortedness) == 0 &&
                name.equals(result.name);
    }

}
