package ir.hinceid.warehouse.controller.warehouse;

import ir.hinceid.warehouse.controller.general.BaseController;
import ir.hinceid.warehouse.model.warhouse.Package;
import ir.hinceid.warehouse.model.warhouse.PackageWarehouseInventory;
import ir.hinceid.warehouse.model.warhouse.WarehouseInventory;
import ir.hinceid.warehouse.repository.interfaces.warehouse.IPackageRepository;
import ir.hinceid.warehouse.repository.interfaces.warehouse.IPackageWarehouseInventoryRepository;
import ir.hinceid.warehouse.repository.interfaces.warehouse.IWarehouseInventoryRepository;
import ir.hinceid.warehouse.viewModel.warehouse.PackageWarehouseInventoryViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/rest/packageWarehouseInventory")
public class PackageWarehouseInventoryController extends BaseController {

    @Qualifier("IPackageWarehouseInventoryRepository")
    @Autowired
    private IPackageWarehouseInventoryRepository iPackageWarehouseInventoryRepository;

    @Qualifier("IWarehouseInventoryRepository")
    @Autowired
    private IWarehouseInventoryRepository iWarehouseInventoryRepository;

    @Qualifier("IPackageRepository")
    @Autowired
    private IPackageRepository iPackageRepository;

    @GetMapping("/load/{packageId}")
    public List<PackageWarehouseInventory> getByPackageId(@PathVariable String packageId) {
        Optional<Package> packages = iPackageRepository.findById(UUID.fromString(packageId));
        return iPackageWarehouseInventoryRepository.getByPackages(packages.get());
    }

    @Transactional
    @PostMapping("save")
    public PackageWarehouseInventory savePackageWarehouseInventory(@RequestBody PackageWarehouseInventoryViewModel packageWarehouseInventoryViewModel) {
//    public Boolean savePackageWarehouseInventory(@RequestBody List<PackageWarehouseInventoryViewModel> packageWarehouseInventoryViewModels) {
//        packageWarehouseInventoryViewModels.forEach(packageWarehouseInventoryViewModel -> {
            PackageWarehouseInventory packageWarehouseInventory = new PackageWarehouseInventory();
            Optional<WarehouseInventory> warehouseInventory = iWarehouseInventoryRepository.findById(UUID.fromString(packageWarehouseInventoryViewModel.warehouseInventoryId));
            Optional<Package> packages = iPackageRepository.findById(UUID.fromString(packageWarehouseInventoryViewModel.packageId));
            packageWarehouseInventory.setWarehouseInventory(warehouseInventory.get());
            packageWarehouseInventory.setPackages(packages.get());
        return iPackageWarehouseInventoryRepository.save(packageWarehouseInventory);
//        });                                                                                                   `
    }
}
