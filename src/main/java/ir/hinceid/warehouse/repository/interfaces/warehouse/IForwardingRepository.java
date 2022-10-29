package ir.hinceid.warehouse.repository.interfaces.warehouse;

import ir.hinceid.warehouse.model.warhouse.Forwarding;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IForwardingRepository extends JpaRepository<Forwarding, UUID> {
}
