package school.practice.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import school.practice.models.Director;
import school.practice.repositories.DirectorRepository;
import school.practice.services.DirectorService;
@Service
public class DirectorServiceImpl implements DirectorService {
    @Autowired
    private DirectorService directorService;


    @Override
    public void register(Director director) {

    }
}
