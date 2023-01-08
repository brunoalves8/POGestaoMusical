package FrontEnd;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Calendar;
import java.util.Scanner;

public class Consola {

    private final Scanner scan = new Scanner(System.in);

    public void escrever(String mensagem) {
        System.out.println(mensagem);
    }

    public void escreverErro(String mensagem) {
        System.err.println(mensagem);
    }

    public String lerString(String mensagem) {
        escrever(mensagem);
        return scan.nextLine();
    }

    public int lerInteiro(String mensagem) {
        Integer numero = null;
        String texto;

        do {
            escrever(mensagem);
            texto = scan.nextLine();

            try {
                numero = Integer.parseInt(texto);
            } catch (NumberFormatException e) {
                escreverErro(texto + " não é um número inteiro válido.");
            }

        } while (numero == null);

        return numero;
    }

    public int lerOpcoesMenusInteiros(String[] opcoes) {
        Integer numero = null;
        String texto = "";

        do {
            escrever("Selecione uma das seguintes opcões:");
            for (int i = 0; i < opcoes.length; i++) {
                escrever((i + 1) + " - " + opcoes[i]);
            }

            try {
                texto = scan.nextLine();
                numero = Integer.parseInt(texto);
            } catch (NumberFormatException e) {
                escreverErro(texto + " não é uma opção válida");
            }

            if (numero == null || numero <= 0 || numero > opcoes.length) {
                numero = null;
                escreverErro(texto + " não é uma opção válida");
            }

        } while (numero == null);

        return numero;
    }

    public double lerDecimal(String mensagem) {
        Double numero = null;
        String texto;

        do {
            escrever(mensagem);
            texto = scan.nextLine();

            try {
                numero = Double.parseDouble(texto);
            } catch (NumberFormatException e) {
                escreverErro(texto + " não é um número decimal válido.");
            }
        } while (numero == null);

        return numero;
    }

    public LocalDate lerData(String mensagem) {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate data = null;
        String text;
        do {
            escrever(mensagem);
            text = scan.nextLine();
            try {
                data = LocalDate.parse(text, formato);
            } catch (DateTimeParseException e) {
                escreverErro(text + " não é uma de data válida! Deve ser do tipo DD/MM/AAAA");
            }

        } while (data == null);

        return data;
       
    }

}
