package codinpad.service;

import codinpad.model.Resident;
import codinpad.repository.ResidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResidentService {

    @Autowired
    private ResidentRepository residentRepository;

    public Resident saveResident(Resident resident) {
        return residentRepository.save(resident);
    }
}
