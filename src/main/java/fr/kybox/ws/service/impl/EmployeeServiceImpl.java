package fr.kybox.ws.service.impl;

import fr.kybox.ws.dao.EmployeeRepository;
import fr.kybox.ws.msg.AddEmployeeReq;
import fr.kybox.ws.msg.AddEmployeeResp;
import fr.kybox.ws.msg.SearchEmployeeReq;
import fr.kybox.ws.msg.SearchEmployeeResp;
import fr.kybox.ws.service.EmployeeService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public SearchEmployeeResp searchEmployee(SearchEmployeeReq req) {

        SearchEmployeeResp resp = new SearchEmployeeResp();

        if (req.getKeyword().equals("all"))
            resp.withEmployeeList(employeeRepository.findAll());
        else resp.withEmployeeList(employeeRepository.findEmployees(req.getKeyword()));

        return resp;
    }

    @Override
    public AddEmployeeResp addEmployee(AddEmployeeReq req) {

        AddEmployeeResp resp = new AddEmployeeResp();
        employeeRepository.save(req.getEmployee());
        resp.setResponse("New employee saved !");

        return resp;
    }
}
