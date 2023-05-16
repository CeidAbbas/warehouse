package ir.hinceid.warehouse.repository.interfaces.warehouse;

import ir.hinceid.warehouse.model.warhouse.Forwarding;
import ir.hinceid.warehouse.model.warhouse.ForwardingPackage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface IForwardingPackageRepository extends JpaRepository<ForwardingPackage, UUID> {
    List<ForwardingPackage> getByForwarding(Forwarding forwarding);
}
