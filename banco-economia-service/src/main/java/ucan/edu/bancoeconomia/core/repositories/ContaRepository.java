package ucan.edu.bancoeconomia.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ucan.edu.bancoeconomia.core.model.Conta;

import java.util.Optional;
import java.util.UUID;

public interface ContaRepository extends JpaRepository<Conta, UUID> {
   // public int countAll();

    Optional<Conta> findContaById(UUID id);
}
