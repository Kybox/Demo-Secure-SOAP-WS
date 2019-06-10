package fr.kybox.ws;

import fr.kybox.ws.dao.EmployeeRepository;
import fr.kybox.ws.model.Employee;
import fr.kybox.ws.model.Role;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class SecureSoapWsApplication implements CommandLineRunner {

    private final EmployeeRepository employeeRepository;

    public SecureSoapWsApplication(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(SecureSoapWsApplication.class, args);
    }

    @Override
    public void run(String... args) {

        employeeRepository.save(new Employee()
                .withFirstName("Marcel")
                .withLastName("Duran")
                .withRoleList(new Role().withName("Developer")));

        employeeRepository.save(new Employee()
                .withFirstName("Robert")
                .withLastName("Roger")
                .withRoleList(new Role().withName("Tech lead")));

        employeeRepository.save(new Employee()
                .withFirstName("Darren")
                .withLastName("King")
                .withRoleList(new Role().withName("Scrum master")));

    }
}
