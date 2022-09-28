package ir.hinceid.warehouse.controller.general;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/login")
public class LoginController extends BaseController {

    @GetMapping("checkConnection")
    public boolean checkConnection(){
        return true;
    }
}
