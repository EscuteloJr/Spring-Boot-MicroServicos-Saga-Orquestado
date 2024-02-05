package edu.ucan.sdp2.bancodireito.direito;

import edu.ucan.sdp2.bancodireito.direito.core.models.DataTeste;
import edu.ucan.sdp2.bancodireito.direito.core.models.Detalhes;
import edu.ucan.sdp2.bancodireito.direito.core.producer.MyProducer;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@SpringBootApplication
public class DireitoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DireitoApplication.class, args);
    }

}

@Component
@RequiredArgsConstructor
class Init{

    private final MyProducer producer;


//    @Value("${bank.topics}")
//    private String topic;
//    @PostConstruct
//    public void initTeste(){
//        producer.enviarEvento(DataTeste.builder()
//                        .id("64429e9a7a8b646915b37360")
//                        .transactionID("1682087576536_99d2ca6c-f074-41a6-92e0-21700148b519")
//                        .detalhes(Detalhes.builder()
//                                .descricaTransacao("Tranferencia")
//                                .montante(4.09)
//                                .moedaTipo("AO")
//                                .dataTransacao(LocalDateTime.now().atOffset(ZoneOffset.UTC))
//                                .localDaTransacao("BANCO-DIR")
//                                .build())
//                .build());
//    }

}