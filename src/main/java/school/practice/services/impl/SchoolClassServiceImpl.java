package school.practice.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import school.practice.dtos.SchoolClassDto;
import school.practice.models.SchoolClass;
import school.practice.repositories.SchoolClassRepository;
import school.practice.services.SchoolClassService;
@Service
public class SchoolClassServiceImpl implements SchoolClassService<Long> {
    @Autowired
    SchoolClassRepository schoolClassRepository;
    @Override
    public void register(SchoolClassDto schoolClass) {}

    @Override
    public void expel(SchoolClassDto schoolClass){schoolClassRepository.deleteById(schoolClass.getId());}

}
