package gb.spring.HomeworkTwo;

import java.util.List;

public class Group {
    private final String name;
    private List<Student> students;

    private UniversityRepository studentsInGroup;

    public Group(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
