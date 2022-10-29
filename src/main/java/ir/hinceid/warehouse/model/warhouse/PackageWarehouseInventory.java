package ir.hinceid.warehouse.model.warhouse;

import ir.hinceid.warehouse.model.general.BaseModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Getter @Setter
@Table(name = PackageWarehouseInventory.tableName)
public class PackageWarehouseInventory extends BaseModel {
    public static final String tableName = "package_warehouse_inventory";

    @ManyToOne()
    @JoinColumn(name = "package_id")
    private Package packages;

    @ManyToOne()
    @JoinColumn(name = "warhouse_inventory_id")
    private WarehouseInventory warehouseInventory;
}
