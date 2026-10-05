public class StudentResult {

    private String studentName;
    private String usn;
    private int[] marks;

    public StudentResult(String studentName, String usn, int[] marks) {

        if (studentName == null || studentName.isBlank()) {
            throw new IllegalArgumentException("Student name cannot be empty");
        }

        if (usn == null || usn.isBlank()) {
            throw new IllegalArgumentException("USN cannot be empty");
        }

        if (marks == null || marks.length == 0) {
            throw new IllegalArgumentException("Marks cannot be empty");
        }

        for (int mark : marks) {
            if (mark < 0 || mark > 100) {
                throw new IllegalArgumentException(
                        "Marks must be between 0 and 100"
                );
            }
        }

        this.studentName = studentName;
        this.usn = usn;
        this.marks = marks;
    }

    // Operation 1: Calculate total marks
    public int calculateTotal() {
        int total = 0;

        for (int mark : marks) {
            total += mark;
        }

        return total;
    }

    // Operation 2: Calculate percentage
    public double calculatePercentage() {
        return (double) calculateTotal() / marks.length;
    }

    // Operation 3: Calculate grade
    public String calculateGrade() {
        double percentage = calculatePercentage();

        if (percentage >= 90) {
            return "A+";
        } else if (percentage >= 80) {
            return "A";
        } else if (percentage >= 70) {
            return "B";
        } else if (percentage >= 60) {
            return "C";
        } else if (percentage >= 50) {
            return "D";
        } else {
            return "F";
        }
    }

    // Operation 4: Check pass/fail
    public boolean isPassed() {

        for (int mark : marks) {
            if (mark < 40) {
                return false;
            }
        }

        return calculatePercentage() >= 40;
    }

    // Operation 5: Generate result summary
    public String getResultSummary() {

        return "Student Name: " + studentName
                + "\nUSN: " + usn
                + "\nTotal Marks: " + calculateTotal()
                + "\nPercentage: "
                + String.format("%.2f", calculatePercentage())
                + "\nGrade: " + calculateGrade()
                + "\nResult: " + (isPassed() ? "PASS" : "FAIL");
    }
}
