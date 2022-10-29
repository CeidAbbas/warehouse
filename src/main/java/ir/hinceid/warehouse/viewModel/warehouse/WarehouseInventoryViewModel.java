package ir.hinceid.warehouse.viewModel.warehouse;

import ir.hinceid.warehouse.viewModel.general.BaseViewModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WarehouseInventoryViewModel extends BaseViewModel {
    public String warehouseId;
    public String warehouseTitle;
    public String wareId;
    public String wareName;
    public String producerId;
    public String producerName;
    public String forwardingId;
    public String referenceId;
    public String warehouseHealthyStatusId;
    public String warehouseHealthyStatusTitle;
    public String deliveryHealthyStatusId;
    public String deliveryHealthyStatusTitle;
    public String buyOriginId;
    public String buyOriginTitle;
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
