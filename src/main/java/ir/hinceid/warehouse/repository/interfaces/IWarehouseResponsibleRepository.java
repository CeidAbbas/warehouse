package ir.hinceid.warehouse.repository.interfaces;

import ir.hinceid.warehouse.model.warhouse.WarehouseResponsible;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface IWarehouseResponsibleRepository extends JpaRepository<WarehouseResponsible, UUID> {

//    @Query(" FROM WarehouseResponsible e WHERE status = :flag ")
    List<WarehouseResponsible> findByStatus(boolean status);

//    List<WarehouseResponsible> findByAll();

}
