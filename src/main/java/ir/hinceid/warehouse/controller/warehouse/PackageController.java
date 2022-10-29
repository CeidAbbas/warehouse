package ir.hinceid.warehouse.controller.warehouse;

import ir.hinceid.warehouse.controller.general.BaseController;
import ir.hinceid.warehouse.model.warhouse.Package;
import ir.hinceid.warehouse.repository.interfaces.warehouse.IPackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/rest/package")
public class PackageController extends BaseController {

    @Qualifier("IPackageRepository")
    @Autowired
    private IPackageRepository iPackageRepository;

    @GetMapping("/getAll")
    public List<Package> getAllPackage() {
        return iPackageRepository.findAll();
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
}
