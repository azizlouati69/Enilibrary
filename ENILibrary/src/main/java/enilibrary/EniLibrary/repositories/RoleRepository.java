
package enilibrary.EniLibrary.repositories;

import enilibrary.EniLibrary.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {



}

