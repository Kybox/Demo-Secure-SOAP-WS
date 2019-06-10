package fr.kybox.ws.service;

import fr.kybox.ws.msg.AddEmployeeReq;
import fr.kybox.ws.msg.AddEmployeeResp;
import fr.kybox.ws.msg.SearchEmployeeReq;
import fr.kybox.ws.msg.SearchEmployeeResp;

public interface EmployeeService {

    SearchEmployeeResp searchEmployee(SearchEmployeeReq req);
    AddEmployeeResp addEmployee(AddEmployeeReq req);
}
