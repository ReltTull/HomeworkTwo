package gb.spring.HomeworkTwo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private UniversityRepository universityRepository;

    @Autowired
    public StudentController(UniversityRepository universityRepository) {
        this.universityRepository = universityRepository;
    }

    /**
     * 3.1 GET /student/{id} - получить студента по ID
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Student getStudentByID(@PathVariable long id) {
        return universityRepository.getStudent(id);
    }

    /**
     * 3.2 GET /student - получить всех студентов
     * @return
     */
    @GetMapping("/all")
    @ResponseBody
    public List<Student> getStudent() {
        return universityRepository.getAllStudents();
    }

    @GetMapping("/{groupName}/students")
    @ResponseBody
    public List<Student> getStudentsByGroup(@PathVariable String groupName) {
        return universityRepository.getStudentsOfGroup(groupName);
    }

    /**
     * 3.3 GET /student/search?name='studentName' - получить список студентов, чье имя содержит подстроку studentName
     * @param name
     * @return
     */
    @GetMapping("/{studentName}")
    @ResponseBody
    public Student getStudentByName(@PathVariable String name) {
        return universityRepository.getStudentByName(name);
    }

    /**
     * * 3.5 POST /student - создать студента (принимает JSON)
     * @param student
     */
    @PostMapping
    public void createStudent(@RequestBody Student student) {
        universityRepository.addStudent(student);
    }

    /**
     * 3.6 DELETE /student/{id} - удалить студента
     * @param id
     */
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        universityRepository.deleteStudentById(id);
    }
}
