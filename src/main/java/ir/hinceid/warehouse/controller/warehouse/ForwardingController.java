package ir.hinceid.warehouse.controller.warehouse;

import ir.hinceid.warehouse.controller.general.BaseController;
import ir.hinceid.warehouse.model.general.Person;
import ir.hinceid.warehouse.model.references.BaseInformation;
import ir.hinceid.warehouse.model.warhouse.Forwarding;
import ir.hinceid.warehouse.model.warhouse.ForwardingPackage;
import ir.hinceid.warehouse.model.warhouse.Package;
import ir.hinceid.warehouse.repository.interfaces.IPersonRepository;
import ir.hinceid.warehouse.repository.interfaces.reference.IBaseInformationRepository;
import ir.hinceid.warehouse.repository.interfaces.warehouse.IForwardingPackageRepository;
import ir.hinceid.warehouse.repository.interfaces.warehouse.IForwardingRepository;
import ir.hinceid.warehouse.repository.interfaces.warehouse.IPackageRepository;
import ir.hinceid.warehouse.viewModel.warehouse.ForwardingPackageViewModel;
import ir.hinceid.warehouse.viewModel.warehouse.ForwardingViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/rest/forwarding")
public class ForwardingController extends BaseController {


    @Qualifier("IForwardingRepository")
    @Autowired
    private IForwardingRepository iForwardingRepository;

    @Qualifier("IPackageRepository")
    @Autowired
    private IPackageRepository iPackageRepository;

    @Qualifier("IPersonRepository")
    @Autowired
    private IPersonRepository iPersonRepository;

    @Qualifier("IBaseInformationRepository")
    @Autowired
    private IBaseInformationRepository iBaseInformationRepository;

    @Qualifier("IForwardingPackageRepository")
    @Autowired
    private IForwardingPackageRepository iForwardingPackageRepository;

    @GetMapping("/getAll")
    public List<ForwardingViewModel> getAllForwarding() {
        List<Forwarding> forwardings = iForwardingRepository.findAll();
        List<ForwardingViewModel> forwardingViewModels = new ArrayList<ForwardingViewModel>();
        forwardings.forEach(forwarding -> {
            ForwardingViewModel forwardingViewModel = new ForwardingViewModel();
            forwardingViewModel.setId(forwarding.getId().toString());
            if (forwarding.getTransporter() != null) {
                forwardingViewModel.setTransporterId(forwarding.getTransporter().getId().toString());
                forwardingViewModel.setTransporterFullName(forwarding.getTransporter().getFullName().toString());
            }
            if (forwarding.getPackages() != null) {
                forwardingViewModel.setPackagesId(forwarding.getPackages().getId().toString());
                forwardingViewModel.setPackagesBarcode(forwarding.getPackages().getBarcode().toString());
                forwardingViewModel.setPackagesColor(forwarding.getPackages().getColor().toString());
            }
            if (forwarding.getCarrier() != null) {
                forwardingViewModel.setCarrierId(forwarding.getCarrier().getId().toString());
                forwardingViewModel.setCarrierTitle(forwarding.getCarrier().getLabel().toString());
            }
            if (forwarding.getReceiver() != null) {
                forwardingViewModel.setReceiverId(forwarding.getReceiver().getId().toString());
                forwardingViewModel.setReceiverFullName(forwarding.getReceiver().getFullName().toString());
            }
            if (forwarding.getTransportDate() != null) {
                forwardingViewModel.setTransportDate(forwarding.getTransportDate());
            }
            if (forwarding.getReceiveDate() != null) {
                forwardingViewModel.setReceiveDate(forwarding.getReceiveDate());
            }
            if (forwarding.getDescription() != null) {
                forwardingViewModel.setDescription(forwarding.getDescription());
            }
            if (forwarding.getCarrierNumber() != null) {
                forwardingViewModel.setCarrierNumber(forwarding.getCarrierNumber());
            }
//            if (forwarding.() != null) {
//                forwardingViewModel.(forwarding.);
//            }
            forwardingViewModels.add(forwardingViewModel);
        });
        return forwardingViewModels;
    }

    @GetMapping("/load/{forwardingId}")
    public Optional<Forwarding> loadByForwardingId(@PathVariable String forwardingId) {
        return iForwardingRepository.findById(UUID.fromString(forwardingId));
    }

    @Transactional
    @PostMapping("save")
    public Forwarding saveForwarding(@RequestBody ForwardingViewModel entityViewModel) {
        Forwarding forwarding = new Forwarding();
        Optional<Package> packages = iPackageRepository.findById(UUID.fromString(entityViewModel.getPackagesId()));
        Optional<Person> transporter = iPersonRepository.findById(UUID.fromString(entityViewModel.getTransporterId()));
        Optional<Person> receiver = iPersonRepository.findById(UUID.fromString(entityViewModel.getReceiverId()));
        Optional<BaseInformation> carrier = iBaseInformationRepository.findById(UUID.fromString(entityViewModel.getCarrierId()));
        forwarding.setPackages(packages.get());
        forwarding.setTransporter(transporter.get());
        forwarding.setReceiver(receiver.get());
        forwarding.setCarrier(carrier.get());
        forwarding.setTransportDate(entityViewModel.getTransportDate());
        forwarding.setReceiveDate(entityViewModel.getReceiveDate());
        forwarding.setDescription(entityViewModel.getDescription());
        forwarding.setCarrierNumber(entityViewModel.getCarrierNumber());
        return iForwardingRepository.save(forwarding);
    }

    @Transactional
    @PostMapping("/addPackageToForwarding")
    public ForwardingPackage addPackageToForwarding(@RequestBody ForwardingPackageViewModel forwardingPackageViewModel) {
        ForwardingPackage forwardingPackage = new ForwardingPackage();
        Optional<Forwarding> forwarding = iForwardingRepository.findById(UUID.fromString(forwardingPackageViewModel.forwardingId));
        Optional<Package> packages = iPackageRepository.findById(UUID.fromString(forwardingPackageViewModel.packageId));
        forwardingPackage.setPackages(packages.get());
        forwardingPackage.setForwarding(forwarding.get());
        return iForwardingPackageRepository.save(forwardingPackage);
    }

    @GetMapping("/getForwardingPackage/{forwardingId}")
    public List<ForwardingPackage> getForwardingPackage(@PathVariable String forwardingId) {
        Optional<Forwarding> forwarding = iForwardingRepository.findById(UUID.fromString(forwardingId));
        return iForwardingPackageRepository.getByForwarding(forwarding.orElseGet(Forwarding::new));
    }
}
