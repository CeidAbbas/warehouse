package ir.hinceid.warehouse.model.warhouse;

//import com.sun.istack.NotNull;
import ir.hinceid.warehouse.model.general.BaseModel;
import ir.hinceid.warehouse.model.general.Person;
import ir.hinceid.warehouse.model.references.BaseInformation;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "warehouseInventory")
public class WarehouseInventory extends BaseModel {

    //    @NotNull
    @ManyToOne
    @JoinColumn(name = "warehouse_id")
    public Warehouse warehouse;

    //    @NotNull
    @ManyToOne
    @JoinColumn(name = "ware_id")
    public Ware ware;

    @ManyToOne
    @JoinColumn(name = "person_id")
    public Person producer;

//    @ManyToOne
//    @JoinColumn(name = "warehouse_destination_id")
//    public Warehouse warehouseDestination;

    @ManyToOne
    @JoinColumn(name = "reference_id")
    public WarehouseInventory reference;

    @ManyToOne
    @JoinColumn(name = "warehouse_healthy_status_id")
    public BaseInformation warehouseHealthyStatus;

    @ManyToOne
    @JoinColumn(name = "delivery_healthy_status_id")
    public BaseInformation deliveryHealthyStatus;

    @ManyToOne
    @JoinColumn(name = "buy_origin_id")
    public BaseInformation buyOrigin;

    public String entryDate;

    public String exitDate;

    public String serial;

    public String contractNumber;

    public String barcode;

    public String description;

    public String color;

    public String expirationDate;

    public String appurtenance;
}
