package id.web.ilham.dmp.repository;

import id.web.ilham.dmp.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRolesRepository extends JpaRepository<UserRole, String> {
    @Query(value = "select r.name as name from user_role ur " +
            "join role r on r.id = ur.role_id " +
            "where user_id = :userId", nativeQuery = true)
    List<String> findRoles(String userId);
}
