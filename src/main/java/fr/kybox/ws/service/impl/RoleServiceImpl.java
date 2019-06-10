package fr.kybox.ws.service.impl;

import fr.kybox.ws.dao.RoleRepository;
import fr.kybox.ws.msg.AddRoleReq;
import fr.kybox.ws.msg.AddRoleResp;
import fr.kybox.ws.msg.GetRoleListReq;
import fr.kybox.ws.msg.GetRoleListResp;
import fr.kybox.ws.service.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public AddRoleResp addRole(AddRoleReq req) {

        AddRoleResp resp = new AddRoleResp();
        roleRepository.save(req.getRole());
        resp.setResponse("New role added.");

        return resp;
    }

    @Override
    public GetRoleListResp getRoleList(GetRoleListReq req) {

        GetRoleListResp resp = new GetRoleListResp();
        resp.withRoleList(roleRepository.findAll());

        return resp;
    }
}
