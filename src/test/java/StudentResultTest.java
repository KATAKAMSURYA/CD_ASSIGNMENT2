import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentResultTest {

    @Test
    void testCalculateTotal() {

        StudentResult student = new StudentResult(
                "Surya",
                "4JAIN24CS001",
                new int[]{85, 90, 80, 75, 95}
        );

        assertEquals(425, student.calculateTotal());
    }

    @Test
    void testCalculatePercentage() {

        StudentResult student = new StudentResult(
                "Surya",
                "4JAIN24CS001",
                new int[]{80, 90, 70, 60, 100}
        );

        assertEquals(80.0, student.calculatePercentage());
    }

    @Test
    void testCalculateGrade() {

        StudentResult student = new StudentResult(
                "Surya",
                "4JAIN24CS001",
                new int[]{95,92,90,95,98}
        );

        assertEquals("A+", student.calculateGrade());
    }

    @Test
    void testStudentPasses() {

        StudentResult student = new StudentResult(
                "Surya",
                "4JAIN24CS001",
                new int[]{75, 80, 70, 85, 90}
        );

        assertTrue(student.isPassed());
    }

    @Test
    void testStudentFailsWhenSubjectMarkIsBelow40() {

        StudentResult student = new StudentResult(
                "Rahul",
                "4JAIN24CS002",
                new int[]{75, 80, 35, 85, 90}
        );

        assertFalse(student.isPassed());
    }

    @Test
    void testInvalidMarks() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new StudentResult(
                        "Student",
                        "4JAIN24CS003",
                        new int[]{80, 105, 70, 90, 85}
                )
        );
    }
}
