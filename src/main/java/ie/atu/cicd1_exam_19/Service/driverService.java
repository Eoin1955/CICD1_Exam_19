package ie.atu.cicd1_exam_19.Service;

import ie.atu.cicd1_exam_19.Controller.ErrorHandling.DuplicateRegNumberException;
import ie.atu.cicd1_exam_19.Model.Driver;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class driverService {
    private final List<Driver> store = new ArrayList<>();

    public Optional<Driver> findByregNumber(String regNumber){
        for(Driver d: store){
            if(d.getRegNumber().equals(regNumber)){
                return Optional.of(d);
            }
        }
        return Optional.empty();
    }

    public Driver create(Driver driver){
        if(findByregNumber(driver.getRegNumber()).isPresent()){
            throw new DuplicateRegNumberException("Driver already exists!");
        }
        store.add(driver);
        return driver;
    }

    public Optional<Driver> update(Driver driver){
        Optional<Driver> found = findByregNumber(driver.getRegNumber());
        if(found.isPresent()){
            Driver update = found.get();
            update.setDriverName(driver.getDriverName());
            update.setPassengers(driver.getPassengers());
            update.setEmail(driver.getEmail());
            return Optional.of(update);}
        else{
            return Optional.empty();
        }
    }

    public Optional <Driver> deleteByregNumber(String regNumber){
        for(Driver d: store){
            if(d.getRegNumber().equals(regNumber)){
                store.remove(d);
                return Optional.of(d);
            }
        }
        return Optional.empty();
    }
}



