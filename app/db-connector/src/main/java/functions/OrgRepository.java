package functions;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrgRepository extends CrudRepository<Org, Long> {
    List<Org> findOrgByCountry(String country);
}
