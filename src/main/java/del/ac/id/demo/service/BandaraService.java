package del.ac.id.demo.service;

import del.ac.id.demo.jpa.BandaraRepository;
import del.ac.id.demo.jpa.Bandara;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List; 

@Service
public class BandaraService {

    @Autowired
    private BandaraRepository bandaraRepository;

    public void create(Bandara bandara) {
        bandaraRepository.save(bandara);
    }

    public List<Bandara> listAllBandara() {
        return bandaraRepository.findAll();
    }

}
