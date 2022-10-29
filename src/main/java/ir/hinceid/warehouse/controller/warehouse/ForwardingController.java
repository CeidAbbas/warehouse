package ir.hinceid.warehouse.controller.warehouse;

import ir.hinceid.warehouse.model.warhouse.Forwarding;
import ir.hinceid.warehouse.repository.interfaces.warehouse.IForwardingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/rest/forwarding")
public class ForwardingController {


    @Qualifier("IForwardingRepository")
    @Autowired
    private IForwardingRepository iForwardingRepository;

    @GetMapping("/getAll")
    public List<Forwarding> getAllForwarding() {
        return iForwardingRepository.findAll();
    }

    @GetMapping("/load/{forwardingId}")
    public Optional<Forwarding> loadByForwardingId(@PathVariable String forwardingId) {
        return iForwardingRepository.findById(UUID.fromString(forwardingId));
    }

    @Transactional
    @PostMapping("/save")
    public Forwarding saveForwarding(@RequestBody Forwarding entity) {
        return iForwardingRepository.save(entity);
    }
}
