package Examen.Examen.Repository;


import Examen.Examen.Entity.Concierto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ConciertoRepository extends CrudRepository<Concierto, Long> {

}
