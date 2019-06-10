package fr.kybox.ws.endpoint;

import fr.kybox.ws.msg.AddRoleReq;
import fr.kybox.ws.msg.AddRoleResp;
import fr.kybox.ws.msg.GetRoleListReq;
import fr.kybox.ws.msg.GetRoleListResp;
import fr.kybox.ws.service.RoleService;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class RoleEndpoint {

    private static final String NAMESPACE_URI = "http://msg.ws.kybox.fr";

    private final RoleService roleService;

    public RoleEndpoint(RoleService roleService) {
        this.roleService = roleService;
    }

    @ResponsePayload
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetRoleListReq")
    public GetRoleListResp getRoleList(@RequestPayload GetRoleListReq req) {

        return roleService.getRoleList(req);
    }

    @ResponsePayload
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "AddRoleReq")
    public AddRoleResp addRole(@RequestPayload AddRoleReq req) {

        return roleService.addRole(req);
    }
}
