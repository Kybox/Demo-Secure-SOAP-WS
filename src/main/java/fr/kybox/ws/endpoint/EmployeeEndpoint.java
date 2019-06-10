package fr.kybox.ws.endpoint;

import fr.kybox.ws.msg.AddEmployeeReq;
import fr.kybox.ws.msg.AddEmployeeResp;
import fr.kybox.ws.msg.SearchEmployeeReq;
import fr.kybox.ws.msg.SearchEmployeeResp;
import fr.kybox.ws.service.EmployeeService;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class EmployeeEndpoint {

    private static final String NAMESPACE_URI = "http://msg.ws.kybox.fr";

    private final EmployeeService employeeService;

    public EmployeeEndpoint(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @ResponsePayload
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "SearchEmployeeReq")
    public SearchEmployeeResp searchEmployee(@RequestPayload SearchEmployeeReq req) {

        return employeeService.searchEmployee(req);
    }

    @ResponsePayload
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "AddEmployeeReq")
    public AddEmployeeResp addEmployee(@RequestPayload AddEmployeeReq req) {

        return employeeService.addEmployee(req);
    }
}
