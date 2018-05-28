package example;

import example.entity.Department;
import example.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class Application {

    @Autowired
    DepartmentRepository departmentRepository;

    @RequestMapping("/")
    String home() {

        departmentRepository.deleteAll();

        Department department = new Department();
        department.setName("开发部");
        departmentRepository.save(department);

        return "hello";
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
