package mankind;

public class Worker extends Human {
    private double weekSalary;
    private double workHoursPerDay;

    public Worker(String firstName, String lastName, double weekSalary, double workHoursPerDay) {
        super(firstName, lastName);
        this.setWeekSalary(weekSalary);
        this.setWorkHoursPerDay(workHoursPerDay);
    }

    private void setWeekSalary(double weekSalary) {
        if (weekSalary < 10) {
            throw new IllegalArgumentException("Expected value mismatch!Argument: weekSalary");
        }
        this.weekSalary = weekSalary;
    }

    private void setWorkHoursPerDay(double workHoursPerDay) {
        if (workHoursPerDay < 1 || workHoursPerDay > 12) {
            throw new IllegalArgumentException("Expected value mismatch!Argument: workHoursPerDay");
        }
        this.workHoursPerDay = workHoursPerDay;
    }

    @Override
    protected void setLastName(String lastName) {
        if (lastName.length() < 3) {
            throw new IllegalArgumentException("Expected length more than 3 symbols!Argument: lastName");
        }
        super.setLastName(lastName);
    }

    private double calculateSalaryPerHour() {
        double salary = this.weekSalary / 7;
        return salary / this.workHoursPerDay;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("First Name: ").append(super.getFirstName()).append(System.lineSeparator());
        sb.append("Last Name: ").append(super.getLastName()).append(System.lineSeparator());
        sb.append("Week salary: ").append(String.format("%.2f", this.weekSalary)).append(System.lineSeparator());
        sb.append("Hours per day: ").append(String.format("%.2f", this.workHoursPerDay)).append(System.lineSeparator());
        sb.append("Salary per hour: ").append(String.format("%.2f", this.calculateSalaryPerHour())).append(System.lineSeparator());

        return sb.toString();
    }
}
