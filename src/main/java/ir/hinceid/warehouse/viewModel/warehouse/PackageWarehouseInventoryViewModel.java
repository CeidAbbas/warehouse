package ir.hinceid.warehouse.viewModel.warehouse;

import ir.hinceid.warehouse.viewModel.general.BaseViewModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PackageWarehouseInventoryViewModel extends BaseViewModel {
    public String warehouseInventoryId;
    public String packageId;
}
