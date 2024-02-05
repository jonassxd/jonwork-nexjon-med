package nexjon.clinic.api.medico;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public interface MedicoRepository extends JpaRepository<Medico, Long> {

    @Query("select m from Medico m ")
    Medico escolherMedicoRandomLivreNaData(Especialidade especialidade, LocalDateTime data);
}
