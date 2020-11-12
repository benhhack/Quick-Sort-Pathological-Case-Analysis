package cases;

public class Result {

    private String name;
    private String sortedness;
    private String averageExecutionTime;

    public String getName() {
        return name;
    }

    public String getSortedness() {
        return sortedness;
    }

    public String getAverageExecutionTime() {
        return averageExecutionTime;
    }

    public Result(String name, String sortedness, String averageExecutionTime) {
        this.name = name;
        this.sortedness = sortedness;
        this.averageExecutionTime = averageExecutionTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Result result = (Result) o;
        return sortedness.equals(result.sortedness) &&
                name.equals(result.name);
    }

}
