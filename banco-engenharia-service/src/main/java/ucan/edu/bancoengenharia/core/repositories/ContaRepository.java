package ucan.edu.bancoengenharia.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ucan.edu.bancoengenharia.core.model.Conta;

import java.util.Optional;
import java.util.UUID;

public interface ContaRepository extends JpaRepository<Conta, UUID> {
   // public int countAll();

    Optional<Conta> findContaById(UUID id);
}
