package fr.kybox.ws.service;

import fr.kybox.ws.msg.AddRoleReq;
import fr.kybox.ws.msg.AddRoleResp;
import fr.kybox.ws.msg.GetRoleListReq;
import fr.kybox.ws.msg.GetRoleListResp;

public interface RoleService {

    AddRoleResp addRole(AddRoleReq req);
    GetRoleListResp getRoleList(GetRoleListReq req);
}
