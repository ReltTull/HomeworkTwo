package gb.spring.HomeworkTwo;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class UniversityRepository {

    private List<Group> groups;
    private List<Student> students;

    public UniversityRepository() {
        groups = new ArrayList<>();
        groups.add(new Group("1010"));
        groups.add(new Group("1020"));

        students = new ArrayList<>();
        students.add(new Student(0, "Sasha", groups.get(0)));
        students.add(new Student(1, "Dima", groups.get(1)));
        students.add(new Student(2, "Lera", groups.get(0)));
        students.add(new Student(3, "Dasha", groups.get(1)));
        students.add(new Student(4, "Misha", groups.get(0)));
        students.add(new Student(5, "Masha", groups.get(1)));
        students.add(new Student(6, "Dina", groups.get(0)));
    }

    public List<Student> getAllStudents() {
        return List.copyOf(students);
    }

    public Student getStudent(long id) {
        return students.stream()
                .filter(student -> Objects.equals(student.getId(), id))
                .findFirst()
                .orElse(null);
    }

    public List<Student> getStudentsOfGroup(String groupName) {
        return students.stream()
                .filter(student -> student.getGroup().getName().equals(groupName))
                .collect(Collectors.toList());
    }

    public Student getStudentByName(String studentName) {
        return students.stream()
                .filter(student -> student.getStudentName().equals(studentName))
                .findFirst()
                .orElse(null);
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void deleteStudentById(Long id) {
        students.remove(id);
    }
}
