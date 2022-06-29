package Examen.Examen.Service;


import Examen.Examen.Entity.Concierto;
import java.util.List;

public interface IConciertoService {

    public List<Concierto> getAllConcierto();

    public void saveConcierto(Concierto concierto);

    public void delete(long id);

    public Concierto getConciertoById(long id);

}
