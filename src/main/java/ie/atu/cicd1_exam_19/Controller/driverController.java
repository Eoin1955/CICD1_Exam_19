package ie.atu.cicd1_exam_19.Controller;

import ie.atu.cicd1_exam_19.Model.Driver;
import ie.atu.cicd1_exam_19.Service.driverService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/bookings")
public class driverController {
    private driverService driverService;

    public driverController(driverService driverService) {this.driverService = driverService;}

    @GetMapping("/{regNumber}")
    public ResponseEntity<Driver> findByregNumber(@PathVariable String regNumber){
        Optional<Driver> driver = driverService.findByregNumber(regNumber);
        if(driver.isPresent()){
            return ResponseEntity.ok().body(driver.get());
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Driver> create(@Valid @RequestBody Driver driver){
        Driver created = driverService.create(driver);
        return ResponseEntity.created(URI.create("/bookings"+ created.getRegNumber())).body(created);
    }

    @PutMapping("/{regNumber}")
    public ResponseEntity<Driver> update(@Valid @RequestBody Driver driver){
        Optional<Driver> updated = driverService.update(driver);
        if(updated.isPresent()){
            return ResponseEntity.ok().body(updated.get());
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{regNumber}")
    public ResponseEntity<Driver> delete(@PathVariable String regNumber){
        Optional<Driver> driver = driverService.findByregNumber(regNumber);
        if(driver.isPresent()){
            driverService.deleteByregNumber(regNumber);
            return ResponseEntity.noContent().build();
        }
        else{return ResponseEntity.notFound().build();}
    }
}

