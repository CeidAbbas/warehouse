package ir.hinceid.warehouse.controller.reference;

import ir.hinceid.warehouse.controller.general.BaseController;
import ir.hinceid.warehouse.model.references.BaseInformation;
import ir.hinceid.warehouse.repository.interfaces.reference.IBaseInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@RequestMapping("/rest/baseInformation")
public class BaseInformationController extends BaseController {

    @Qualifier("IBaseInformationRepository")
    @Autowired
    private IBaseInformationRepository iBaseInformationRepository;

    // getAll
    @GetMapping("getAll")
    public List<BaseInformation> getAllBaseInformation() {
        List<BaseInformation> baseInformations = new ArrayList<BaseInformation>();
        baseInformations = iBaseInformationRepository.findAll();
//        List<BaseInformation> base = baseInformations.stream().filter(baseInformation -> {
//            return (Integer)baseInformation.getHierarchy() < 1000;
//        });
        return baseInformations;
    }

    // load
    @GetMapping("load/{baseInformationId}")
    public Optional<BaseInformation> loadBaseInformation(@PathVariable String baseInformationId) {
        if (baseInformationId != "")
            return iBaseInformationRepository.findById(UUID.fromString(baseInformationId));
        return Optional.empty();
    }

    // save or update

    /**
     *
     * @param baseInformation مدل دریافتی از کاربر برای ذخیره سازی
     * @Param parent آی دی والد
     * @return
     */
    @PostMapping("save/{parent}")
    public BaseInformation saveBaseInformation(@RequestBody BaseInformation baseInformation,@PathVariable String parent) {
//        List<BaseInformation> baseInformations = iBaseInformationRepository.loadByWareType();
        if (baseInformation.getId() == null) {
            baseInformation.setId(UUID.randomUUID());
            BaseInformation baseInformationParent = new BaseInformation();
            baseInformationParent.setId(UUID.fromString(parent));
            baseInformation.setParent(baseInformationParent);
        }
        baseInformation.setCreatedDate(new Date());
        return iBaseInformationRepository.save(baseInformation);
    }

}
