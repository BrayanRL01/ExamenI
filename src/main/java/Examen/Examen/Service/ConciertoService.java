package Examen.Examen.Service;


import Examen.Examen.Entity.Concierto;
import Examen.Examen.Repository.ConciertoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConciertoService implements IConciertoService {

    @Autowired
    private ConciertoRepository conciertoRepository;

    @Override
    public List<Concierto> getAllConcierto() {
        return (List<Concierto>) conciertoRepository.findAll();
    }

    @Override
    public void saveConcierto(Concierto concierto) {
        conciertoRepository.save(concierto);
    }

    @Override
    public void delete(long id) {
        conciertoRepository.deleteById(id);
    }

    @Override
    public Concierto getConciertoById(long id) {
        return conciertoRepository.findById(id).orElse(null);
    }

}
