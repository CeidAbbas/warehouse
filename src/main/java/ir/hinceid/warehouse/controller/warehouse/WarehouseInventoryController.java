package ir.hinceid.warehouse.controller.warehouse;

import ir.hinceid.warehouse.controller.general.BaseController;
import ir.hinceid.warehouse.model.general.FileStorage;
import ir.hinceid.warehouse.model.general.Person;
import ir.hinceid.warehouse.model.references.BaseInformation;
import ir.hinceid.warehouse.model.warhouse.Ware;
import ir.hinceid.warehouse.model.warhouse.Warehouse;
import ir.hinceid.warehouse.model.warhouse.WarehouseInventory;
import ir.hinceid.warehouse.repository.interfaces.general.IFileStorageRepository;
import ir.hinceid.warehouse.repository.interfaces.warehouse.IWarehouseInventoryRepository;
import ir.hinceid.warehouse.service.general.FileStorageService;
import ir.hinceid.warehouse.viewModel.warehouse.WarehouseInventoryViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContextException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.util.*;

@RestController
@RequestMapping("/rest/warehouseInventory")
public class WarehouseInventoryController extends BaseController {

    @Qualifier("IWarehouseInventoryRepository")
    @Autowired
    private IWarehouseInventoryRepository iWarehouseInventoryRepository;

    @Autowired
    private FileStorageService fileStorageService;

    @Autowired
    private IFileStorageRepository iFileStorageRepository;

//    @Autowired
//    private IWarehouseInventoryRepository warehouseInventoryRepository;

    // getAll
    @GetMapping("getAll")
    public List<WarehouseInventoryViewModel> getAllWarehouseInventory() {
        List<WarehouseInventory> warehouseInventories = iWarehouseInventoryRepository.findAll();
        List<WarehouseInventoryViewModel> warehouseInventoryViewModels = new ArrayList<WarehouseInventoryViewModel>();
        warehouseInventories.forEach(warehouseInventory -> {
            WarehouseInventoryViewModel warehouseInventoryViewModel = new WarehouseInventoryViewModel();
            warehouseInventoryViewModel.setId(warehouseInventory.getId().toString());
            if (warehouseInventory.getCreatedDate().toString() != null)
                warehouseInventoryViewModel.setCreatedDate(warehouseInventory.getCreatedDate().toString());
//            warehouseInventoryViewModel.setCreatedUser(warehouseInventory.getCreatedUser().toString());
            if (warehouseInventory.getWarehouse() != null) {
                warehouseInventoryViewModel.setWarehouseId(warehouseInventory.getWarehouse().getId().toString());
                warehouseInventoryViewModel.setWarehouseTitle(warehouseInventory.getWarehouse().getName());
            }
            if (warehouseInventory.getWare() != null) {
                warehouseInventoryViewModel.setWareId(warehouseInventory.getWare().getId().toString());
                warehouseInventoryViewModel.setWareName(warehouseInventory.getWare().getName());
            }
            if (warehouseInventory.getProducer() != null) {
                warehouseInventoryViewModel.setProducerId(warehouseInventory.getProducer().getId().toString());
                warehouseInventoryViewModel.setProducerName(warehouseInventory.getProducer().getFullName());
            }
//            if (warehouseInventory.getWarehouseDestination() != null)
//                warehouseInventoryViewModel.setWarehouseDestinationId(warehouseInventory.getWarehouseDestination().getId().toString());
//                warehouseInventoryViewModel.setWarehouseDestinationTitle(warehouseInventory.getWarehouseDestination().getName());
            if (warehouseInventory.getReference() != null)
                warehouseInventoryViewModel.setReferenceId(warehouseInventory.getReference().getId().toString());
            if (warehouseInventory.getWarehouseHealthyStatus() != null) {
                warehouseInventoryViewModel.setWarehouseHealthyStatusId(warehouseInventory.getWarehouseHealthyStatus().getId().toString());
                warehouseInventoryViewModel.setWarehouseHealthyStatusTitle(warehouseInventory.getWarehouseHealthyStatus().getLabel());
            }
            if (warehouseInventory.getDeliveryHealthyStatus() != null) {
                warehouseInventoryViewModel.setDeliveryHealthyStatusId(warehouseInventory.getDeliveryHealthyStatus().getId().toString());
                warehouseInventoryViewModel.setDeliveryHealthyStatusTitle(warehouseInventory.getDeliveryHealthyStatus().getLabel());
            }
            if (warehouseInventory.getBuyOrigin() != null) {
                warehouseInventoryViewModel.setBuyOriginId(warehouseInventory.getBuyOrigin().getId().toString());
                warehouseInventoryViewModel.setBuyOriginTitle(warehouseInventory.getBuyOrigin().getLabel());
            }
            warehouseInventoryViewModel.setEntryDate(warehouseInventory.getEntryDate());
            warehouseInventoryViewModel.setExitDate(warehouseInventory.getExitDate());
            warehouseInventoryViewModel.setSerial(warehouseInventory.getSerial());
            warehouseInventoryViewModel.setContractNumber(warehouseInventory.getContractNumber());
            warehouseInventoryViewModel.setBarcode(warehouseInventory.getBarcode());
            warehouseInventoryViewModel.setDescription(warehouseInventory.getDescription());
            warehouseInventoryViewModel.setColor(warehouseInventory.getColor());
            warehouseInventoryViewModel.setExpirationDate(warehouseInventory.getExpirationDate());
            warehouseInventoryViewModel.setAppurtenance(warehouseInventory.getAppurtenance());
            warehouseInventoryViewModels.add(warehouseInventoryViewModel);
        });
        return warehouseInventoryViewModels;
    }

    // getByWarehouseId
    @GetMapping("getByWarehouseId/{warehouseId}")
    public List<WarehouseInventoryViewModel> getByWarehouseId(@PathVariable String warehouseId) {
        List<WarehouseInventory> warehouseInventories = iWarehouseInventoryRepository.getByWarehouseId(UUID.fromString(warehouseId));
//        List<WarehouseInventory> warehouseInventories = iWarehouseInventoryRepository.getByWarehouseId(UUID.fromString(warehouseId));
        List<WarehouseInventoryViewModel> warehouseInventoryViewModels = new ArrayList<WarehouseInventoryViewModel>();
        warehouseInventories.forEach(warehouseInventory -> {
            WarehouseInventoryViewModel warehouseInventoryViewModel = new WarehouseInventoryViewModel();
            warehouseInventoryViewModel.setId(warehouseInventory.getId().toString());
            if (warehouseInventory.getCreatedDate().toString() != null)
                warehouseInventoryViewModel.setCreatedDate(warehouseInventory.getCreatedDate().toString());
//            warehouseInventoryViewModel.setCreatedUser(warehouseInventory.getCreatedUser().toString());
            if (warehouseInventory.getWarehouse() != null) {
                warehouseInventoryViewModel.setWarehouseId(warehouseInventory.getWarehouse().getId().toString());
                warehouseInventoryViewModel.setWarehouseTitle(warehouseInventory.getWarehouse().getName());
            }
            if (warehouseInventory.getWare() != null) {
                warehouseInventoryViewModel.setWareId(warehouseInventory.getWare().getId().toString());
                warehouseInventoryViewModel.setWareName(warehouseInventory.getWare().getName());
            }
            if (warehouseInventory.getProducer() != null) {
                warehouseInventoryViewModel.setProducerId(warehouseInventory.getProducer().getId().toString());
                warehouseInventoryViewModel.setProducerName(warehouseInventory.getProducer().getFullName());
            }
//            if (warehouseInventory.getForwarding() != null)
//                warehouseInventoryViewModel.setForwardingId(warehouseInventory.getForwarding().getId().toString());
            if (warehouseInventory.getReference() != null)
                warehouseInventoryViewModel.setReferenceId(warehouseInventory.getReference().getId().toString());
            if (warehouseInventory.getWarehouseHealthyStatus() != null) {
                warehouseInventoryViewModel.setWarehouseHealthyStatusId(warehouseInventory.getWarehouseHealthyStatus().getId().toString());
                warehouseInventoryViewModel.setWarehouseHealthyStatusTitle(warehouseInventory.getWarehouseHealthyStatus().getLabel());
            }
            if (warehouseInventory.getDeliveryHealthyStatus() != null) {
                warehouseInventoryViewModel.setDeliveryHealthyStatusId(warehouseInventory.getDeliveryHealthyStatus().getId().toString());
                warehouseInventoryViewModel.setDeliveryHealthyStatusTitle(warehouseInventory.getDeliveryHealthyStatus().getLabel());
            }
            if (warehouseInventory.getBuyOrigin() != null) {
                warehouseInventoryViewModel.setBuyOriginId(warehouseInventory.getBuyOrigin().getId().toString());
                warehouseInventoryViewModel.setBuyOriginTitle(warehouseInventory.getBuyOrigin().getLabel());
            }
            warehouseInventoryViewModel.setEntryDate(warehouseInventory.getEntryDate());
            warehouseInventoryViewModel.setExitDate(warehouseInventory.getExitDate());
            warehouseInventoryViewModel.setSerial(warehouseInventory.getSerial());
            warehouseInventoryViewModel.setContractNumber(warehouseInventory.getContractNumber());
            warehouseInventoryViewModel.setBarcode(warehouseInventory.getBarcode());
            warehouseInventoryViewModel.setDescription(warehouseInventory.getDescription());
            warehouseInventoryViewModel.setColor(warehouseInventory.getColor());
            warehouseInventoryViewModel.setExpirationDate(warehouseInventory.getExpirationDate());
            warehouseInventoryViewModel.setAppurtenance(warehouseInventory.getAppurtenance());
            warehouseInventoryViewModels.add(warehouseInventoryViewModel);
        });
        return warehouseInventoryViewModels;
    }

    @GetMapping("load/{warehouseInventoryId}")
    public Optional<WarehouseInventoryViewModel> loadWarehouseInventory(@PathVariable String warehouseInventoryId) {
        if (warehouseInventoryId != "")
            return null;
        return Optional.empty();
    }


    @PostMapping("saveFile/{warehouseInventoryId}")
    @Transactional
//    public WarehouseInventory saveWarehouseInventory(@RequestBody WarehouseInventoryViewModel warehouseInventoryViewModel, @RequestParam("file") File file) throws IOException {
    public WarehouseInventory saveWarehouseInventoryFile(@RequestPart("file")MultipartFile file, @PathVariable String warehouseInventoryId) throws IOException {

        FileStorage fileStorage = new FileStorage(file.getOriginalFilename(), file.getBytes(), UUID.fromString(warehouseInventoryId),"warehouseInventory");
        FileStorage savedFileStorage = iFileStorageRepository.save(fileStorage);
        return null;
    }

    @PostMapping("save")
    @Transactional
//    public WarehouseInventory saveWarehouseInventory(@RequestBody WarehouseInventoryViewModel warehouseInventoryViewModel, @RequestParam("file") File file) throws IOException {
    public WarehouseInventory saveWarehouseInventory(@RequestPart("file")MultipartFile file) throws IOException {

        FileStorage fileStorage = new FileStorage(file.getOriginalFilename(), file.getBytes());
        FileStorage savedFileStorage = iFileStorageRepository.save(fileStorage);
        WarehouseInventoryViewModel warehouseInventoryViewModel = new WarehouseInventoryViewModel();
//    public WarehouseInventory saveWarehouseInventory(@RequestBody WarehouseInventoryViewModel warehouseInventoryViewModel, @RequestPart("file")MultipartFile file) throws IOException {
        WarehouseInventory warehouseInventory = new WarehouseInventory();
        if (warehouseInventoryViewModel.getId() == null || Objects.equals(warehouseInventory.getId(), ""))
            warehouseInventory.setId(UUID.randomUUID());
        if (warehouseInventoryViewModel.getWarehouseId() != null) {
            Warehouse warehouse = new Warehouse();
            warehouse.setId(UUID.fromString(warehouseInventoryViewModel.getWarehouseId()));
            warehouseInventory.setWarehouse(warehouse);
        }
        if (warehouseInventoryViewModel.getWareId() != null) {
        Ware ware = new Ware();
        ware.setId(UUID.fromString(warehouseInventoryViewModel.getWareId()));
        warehouseInventory.setWare(ware);
        }
//        if (warehouseInventoryViewModel.getWarehouseDestinationId() != null) {
//            Warehouse warehouseDestination = new Warehouse();
//            warehouseDestination.setId(UUID.fromString(warehouseInventoryViewModel.getWarehouseDestinationId()));
//            warehouseInventory.setWarehouseDestination(warehouseDestination);
//        }
        if (warehouseInventoryViewModel.getProducerId() != null) {
            Person producer = new Person();
            producer.setId(UUID.fromString(warehouseInventoryViewModel.getProducerId()));
            warehouseInventory.setProducer(producer);
        }
        if (warehouseInventoryViewModel.getReferenceId() != null) {
            WarehouseInventory reference = new WarehouseInventory();
            reference.setId(UUID.fromString(warehouseInventoryViewModel.getReferenceId()));
            warehouseInventory.setReference(reference);
        }
        if (warehouseInventoryViewModel.getWarehouseHealthyStatusId() != null){
            BaseInformation warehouseHealthyStatus = new BaseInformation();
            warehouseHealthyStatus.setId(UUID.fromString(warehouseInventoryViewModel.getWarehouseHealthyStatusId()));
            warehouseInventory.setWarehouseHealthyStatus(warehouseHealthyStatus);
        }
        if (warehouseInventoryViewModel.getDeliveryHealthyStatusId() != null) {
            BaseInformation deliveryHealthyStatus = new BaseInformation();
            deliveryHealthyStatus.setId(UUID.fromString(warehouseInventoryViewModel.getDeliveryHealthyStatusId()));
            warehouseInventory.setDeliveryHealthyStatus(deliveryHealthyStatus);
        }
        if (warehouseInventoryViewModel.getBuyOriginId() != null && !Objects.equals(warehouseInventoryViewModel.getBuyOriginId(), "")) {
            BaseInformation buyOrigin = new BaseInformation();
            buyOrigin.setId(UUID.fromString(warehouseInventoryViewModel.getBuyOriginId()));
            warehouseInventory.setBuyOrigin(buyOrigin);
        }
        if (warehouseInventoryViewModel.getEntryDate() != null)
            warehouseInventory.setEntryDate(warehouseInventoryViewModel.getEntryDate());
        else {}
        if (warehouseInventoryViewModel.getExitDate() != null)
            warehouseInventory.setExitDate(warehouseInventoryViewModel.getExitDate());
        else {}
        if (warehouseInventoryViewModel.getSerial() != null)
            warehouseInventory.setSerial(warehouseInventoryViewModel.getSerial());
        if (warehouseInventoryViewModel.getContractNumber() != null)
            warehouseInventory.setContractNumber(warehouseInventoryViewModel.getContractNumber());
        if (warehouseInventoryViewModel.getDescription() != null)
            warehouseInventory.setDescription(warehouseInventoryViewModel.getDescription());
//        if (warehouseInventoryViewModel.() != null)
//            warehouseInventory.(warehouseInventoryViewModel.());
        if (warehouseInventoryViewModel.getExpirationDate() != null)
            warehouseInventory.setExpirationDate(warehouseInventoryViewModel.getExpirationDate());
        if (warehouseInventoryViewModel.getAppurtenance() != null)
            warehouseInventory.setAppurtenance(warehouseInventoryViewModel.getAppurtenance());
//        if (file.isEmpty()) {
//            FileStorage fileStorage = fileStorageService.saveFile(warehouseInventoryViewModel.getWarehouseInventoryFile());
//            warehouseInventory.setWarehouseInventoryFile(fileStorage);
//        }
        warehouseInventory.setCreatedDate(new Date());
//        throw new ApplicationContextException("a");
        return iWarehouseInventoryRepository.save(new WarehouseInventory());
    }

    @DeleteMapping("delete/{warehouseInventoryId}")
    public void deleteWarehouseInventory(@PathVariable String warehouseInventoryId) {
        iWarehouseInventoryRepository.deleteById(UUID.fromString(warehouseInventoryId));
    }

    @GetMapping("getImage/{imageId}")
    public List<FileStorage> getImage(@PathVariable("imageId") String imageId) throws IOException {

        List<FileStorage> byRelatedAndScope = iFileStorageRepository.findByRelatedAndScope(UUID.fromString(imageId), "warehouseInventory");
        return byRelatedAndScope;
    }
}
