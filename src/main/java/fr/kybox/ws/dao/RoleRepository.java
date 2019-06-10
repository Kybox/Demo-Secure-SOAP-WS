package fr.kybox.ws.dao;

import fr.kybox.ws.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
