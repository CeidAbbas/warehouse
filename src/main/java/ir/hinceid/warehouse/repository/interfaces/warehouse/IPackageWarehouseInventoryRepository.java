package ir.hinceid.warehouse.repository.interfaces.warehouse;

import ir.hinceid.warehouse.model.warhouse.Package;
import ir.hinceid.warehouse.model.warhouse.PackageWarehouseInventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface IPackageWarehouseInventoryRepository extends JpaRepository<PackageWarehouseInventory, UUID> {
    List<PackageWarehouseInventory> getByPackages(Package packages);
}
