package be.sander.thuis.services;

import be.sander.thuis.domain.Kattenbak;
import be.sander.thuis.repositories.KattenbakRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
public class DefaultKattenbakService implements KattenbakService{
    private final KattenbakRepository repository;

    public DefaultKattenbakService(KattenbakRepository repository){
        this.repository = repository;
    }

    @Override
    public List<Kattenbak> findAll() {
        return repository.findAll();
    }

    @Override
    public Long countByNaam(String naam) {
        return repository.countByNaam(naam);
    }

    @Override
    public List<Kattenbak> findAllByDatum() {
        return repository.findAllByDatum();
    }

    @Override
    @Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED)
    public void create(Kattenbak kattenbak) {
        repository.save(kattenbak);
    }
}
