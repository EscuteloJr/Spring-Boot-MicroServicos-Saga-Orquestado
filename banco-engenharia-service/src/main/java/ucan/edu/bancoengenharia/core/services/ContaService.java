package ucan.edu.bancoengenharia.core.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ucan.edu.bancoengenharia.core.helpers.ContaHelper;
import ucan.edu.bancoengenharia.core.model.Conta;
import ucan.edu.bancoengenharia.core.repositories.ContaRepository;

@Service
@RequiredArgsConstructor
public class ContaService {
    private final ContaRepository repository;
    private final ContaHelper helper;

  /*  public Conta create(Conta conta) {

        var nextConta = repository.countAll() + 1;
        conta.setNumero(helper.gerarNumeroPadrao(nextConta));
        conta.setIban(helper.gerarIBAN(conta.getNumero()));

        return repository.save(conta);
    }*/
}
