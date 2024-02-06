package ucan.edu.bancoeconomia.core.services;

import net.sf.jsqlparser.util.validation.ValidationException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import ucan.edu.bancoeconomia.core.mappers.HttpResponseMapper;
import ucan.edu.bancoeconomia.core.mappers.ResponseMessage;
import ucan.edu.bancoeconomia.core.utils.JsonUtil;

import java.util.List;
import java.util.UUID;
/*
public abstract class GenericoService<T> {

    protected JpaRepository<T, UUID> repository;

    public ResponseEntity<ResponseMessage<T>> buscarPorId(String id)  {
        T entity = repository
                .findById(UUID.fromString(id))
                .orElseThrow(() -> new ValidationException("Não foi possivel localizar o objecto"));
        return new HttpResponseMapper<T>(entity).sucesso("Objecto carregado com sucesso");
    }


    public ResponseEntity<ResponseMessage<T>> deletar(String id) {
        T entity = repository
                .findById(UUID.fromString(id))
                .orElseThrow(() -> new ValidationException("Não foi possivel deletar o objecto"));
        repository.delete(entity);
        return new HttpResponseMapper<T>(entity).sucesso("O Objecto foi eliminado com sucesso");
    }

    public ResponseEntity<ResponseMessage<List<T>>> listar()  {
        var list =  repository
                .findAll();
        var response = new HttpResponseMapper<List<T>>(list);
        if (list.isEmpty()){
            return response.naoEncontrado("Não foram encontrado dados");
        }
        return response.sucesso("Os diagnosticos foram carregadas com sucesso!");
    }

    public ResponseEntity<ResponseMessage<T>> criar(DiagnosticoDto newDiagnostico) {
        final var validacao = DiagnosticoValidator.validarCriacao(newDiagnostico);
        if (!validacao.isValid()) {
            return  new HttpResponseMapper<Diagnostico>(null).parametrosInvalido(validacao.getMessage());
        }
        final Diagnostico diagnostico = DiagnosticoMapper.fromDto(newDiagnostico);
        final HttpResponseMapper<Diagnostico> diagnosticoResponse =  new HttpResponseMapper<>(diagnosticoRepository.save(diagnostico));
        return diagnosticoResponse.criado("O diagnostico foi criada com sucesso!");
    }



    public ResponseEntity<ResponseMessage<Diagnostico>> editar(String id, DiagnosticoDto diagnosticoDto) throws EntityExceptions.IdConvertionException{

        final var validacao = DiagnosticoValidator.validarEdicao(diagnosticoDto);
        if (!validacao.isValid()) {
            return  new HttpResponseMapper<Diagnostico>(null).parametrosInvalido(validacao.getMessage());
        }

        var diagnosticoAlterada = diagnosticoRepository.findById(UUID.fromString(id)).map(p -> {
            final Diagnostico diagnostico = DiagnosticoMapper.fromDto(diagnosticoDto);
            diagnostico.setId(p.getId());
            return diagnostico;
        }).orElseThrow(DiagnosticoExceptions.DiagnosticoNotFoundExceptions::new);

        final HttpResponseMapper<Diagnostico> diagnosticoResponse =  new HttpResponseMapper<>(diagnosticoRepository.save(diagnosticoAlterada));
        return diagnosticoResponse.criado("A diagnostico foi criada com sucesso!");
    }
}*/
