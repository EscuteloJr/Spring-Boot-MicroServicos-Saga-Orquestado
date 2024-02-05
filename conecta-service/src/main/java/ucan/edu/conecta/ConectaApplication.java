package ucan.edu.conecta;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import ucan.edu.conecta.core.producer.SagaOrquestradorProducer;

@SpringBootApplication
public class ConectaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConectaApplication.class, args);
                
	}
        
       

}


@Component
@RequiredArgsConstructor
class Init{

	private final SagaOrquestradorProducer producer;

	@Value("${bank.topics}")
	private String topic;
	@PostConstruct
	public void initTeste(){
		producer.enviarEvento("teste", topic);
	}

}