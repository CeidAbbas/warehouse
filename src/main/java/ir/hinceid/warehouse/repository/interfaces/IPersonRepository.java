package ir.hinceid.warehouse.repository.interfaces;

import ir.hinceid.warehouse.model.general.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonRepository extends JpaRepository<Person, Long> {
}
