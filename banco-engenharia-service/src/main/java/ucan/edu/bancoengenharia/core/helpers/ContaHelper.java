package ucan.edu.bancoengenharia.core.helpers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("banco-info")
public class ContaHelper {
    private String codigoBano;
    private String codigoPais;

    public  String gerarIBAN(String numeroConta) {
        String numeroFormatado = codigoPais + "-" + codigoBano +
                numeroConta.substring(0, 2) + "-" +
                numeroConta.substring(2, 6) + "-" +
                numeroConta.substring(6);

        return numeroFormatado;
    }
    public  String gerarNumeroPadrao(int numero) {
        return  String.format("%010d", numero);
    }
}
