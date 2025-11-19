package ie.atu.cicd1_exam_19.Service;

import ie.atu.cicd1_exam_19.Model.Driver;
import org.springframework.stereotype.Service;

import javax.lang.model.element.NestingKind;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class driverService {
    private final List<Driver> store = new ArrayList<>();

    public List<Driver> findAll(){
        return new ArrayList<>(store);
    }

    public Optional<Driver> findByregNumber(String regNumber){
        for(Driver d: store){
            if(d.getRegNumber().equals(regNumber)){
                return Optional.of(d);
            }
        }
        return Optional.empty();
    }
}
