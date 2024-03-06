import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class StudentTest {
    private List<Student> students;

    @BeforeAll
    public void initClass() {
        students = new ArrayList<>();
    }

    @AfterEach
    public void cleanClass() {
        students.clear();
    }

    @BeforeEach
    private void initMethod() {
        Student student1 = new Student("Fiona", 18);
        Student student2 = new Student("James", 20);
        students.add(student1);
        students.add(student2);
    }

    @Test
    public void testMethod1TestDataCreation() {
        assertNotNull(students);
        assertEquals(2, students.size());
    }

    @Test
    public void testMethod2TestStudentEnrolment() {
        Student student = students.get(0);
        student.enrollCourse("Alpro");
        student.enrollCourse("PPPL");
        assertEquals(2, student.getEnrolledCourses().size());
        assertEquals("Alpro", student.getEnrolledCourses().get(0));
        assertEquals("PPPL", student.getEnrolledCourses().get(1));
        System.out.println(students);
    }

    @Test
    public void testMethod3TestStudentGrade() {
        Student student = students.get(0);
        student.setGrade("OOP", "B");
        student.setGrade("Statistika", "C");
        assertEquals("B", student.getGrade("OOP"));
        assertEquals("C", student.getGrade("Statistika"));
    }
}
