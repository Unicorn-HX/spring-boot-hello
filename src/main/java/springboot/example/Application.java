package springboot.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springboot.example.entity.Department;
import springboot.example.entity.Role;
import springboot.example.entity.User;
import springboot.example.repository.DepartmentRepository;
import springboot.example.repository.UserRepository;

import java.util.Date;
import java.util.List;

@SpringBootApplication
@RestController
public class Application {

    @Autowired
    DepartmentRepository departmentRepository;

    @RequestMapping("/")
    String home() {

        departmentRepository.deleteAll();

        Department deparment = new Department();
        deparment.setName("开发部");
        departmentRepository.save(deparment);

        return "hello";
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
