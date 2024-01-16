package gb.spring.HomeworkTwo;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
public class Student {

    private static Long idCounter = 1L;
    private final Long id;
    private String studentName;
    private String groupName;
    private Group group;

    @JsonCreator
    public Student(long id, String name, Group group) {
        this.id = id;
        this.studentName = name;
        this.group = group;
    }

    public Group getGroup() {
        return group;
    }

    public Student(String name, Group group) {
        this.id = idCounter++;
        this.studentName = name;
        this.group = group;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentName='" + studentName + '\'' +
                ", groupName='" + groupName + '\'' +
                '}';
    }
}
