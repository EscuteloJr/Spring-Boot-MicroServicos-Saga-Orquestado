/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ucan.edu.bancoeconomia.core.repositories;

import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import ucan.edu.bancoeconomia.core.model.Transacao;

/**
 *
 * @author escutelo
 */
public interface TransacaoRepository extends JpaRepository<Transacao, UUID>{
    Boolean existsByIdAndContaId(UUID transacaoId, UUID contaId);
    Optional<Transacao> findByIdAndContaId(UUID transacaoId, UUID contaId);
}
