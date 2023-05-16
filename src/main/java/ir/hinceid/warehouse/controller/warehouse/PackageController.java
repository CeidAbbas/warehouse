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
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/rest/package")
public class PackageController extends BaseController {

    @Qualifier("IPackageRepository")
    @Autowired
    private IPackageRepository iPackageRepository;

    @Qualifier("IWarehouseInventoryRepository")
    @Autowired
    private IWarehouseInventoryRepository iWarehouseInventoryRepository;

    @Qualifier("IPackageWarehouseInventoryRepository")
    @Autowired
    private IPackageWarehouseInventoryRepository iPackageWarehouseInventoryRepository;
    
    @GetMapping("/getAll")
    public List<Package> getAllPackage() {
        return iPackageRepository.findAll();
    }

    @GetMapping("/getAllWarehouseInventory/{packageId}")
    public List<WarehouseInventory> getAllWarehouseInventoryByPackageId(@PathVariable String packageId) {
        Optional<Package> packages = iPackageRepository.findById(UUID.fromString(packageId));
        List<PackageWarehouseInventory> packageWarehouseInventories = iPackageWarehouseInventoryRepository.getByPackages(packages.get());
        List<WarehouseInventory> warehouseInventories = new ArrayList<WarehouseInventory>();
        packageWarehouseInventories.forEach(packageWarehouseInventory -> {
            warehouseInventories.add(iWarehouseInventoryRepository.findById(packageWarehouseInventory.getWarehouseInventory().getId()).get());
        });
        return warehouseInventories;
    }

    @GetMapping("/load/{packageId}")
    public Optional<Package> loadByPackageId(@PathVariable String packageId) {
        return iPackageRepository.findById(UUID.fromString(packageId));
    }

    @Transactional
    @PostMapping("/save")
    public Package savePackage(@RequestBody Package entity) {
        return iPackageRepository.save(entity);
    }

    @Transactional
    @PostMapping("/savePackageWarehouseInventory")
    public PackageWarehouseInventory savePackageWarehouseInventory(@RequestBody PackageWarehouseInventoryViewModel packageWarehouseInventoryViewModel) {
        PackageWarehouseInventory packageWarehouseInventory = new PackageWarehouseInventory();
        Optional<WarehouseInventory> warehouseInventory = iWarehouseInventoryRepository.findById(UUID.fromString(packageWarehouseInventoryViewModel.warehouseInventoryId));
        Optional<Package> packages = iPackageRepository.findById(UUID.fromString(packageWarehouseInventoryViewModel.packageId));
        packageWarehouseInventory.setWarehouseInventory(warehouseInventory.get());
        packageWarehouseInventory.setPackages(packages.get());
        return iPackageWarehouseInventoryRepository.save(packageWarehouseInventory);
    }
}
