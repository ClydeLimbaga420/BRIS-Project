package codinpad.controller;//change this

import codinpad.model.Resident;//change this
import codinpad.service.ResidentService;//change this
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/residents")
@CrossOrigin(origins = "*") // Allow frontend access
public class ResidentController {

    private final ResidentService residentService;

    @Autowired
    public ResidentController(ResidentService residentService) {
        this.residentService = residentService;
    }

    @PostMapping
    public ResponseEntity<Resident> addResident(@RequestBody Resident resident) {
        Resident savedResident = residentService.saveResident(resident);
        return ResponseEntity.ok(savedResident);
    }
}
