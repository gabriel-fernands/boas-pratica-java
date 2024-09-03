package br.com.alura;

import br.com.alura.client.ClientHttpConfiguration;
import br.com.alura.service.AbrigoService;
import br.com.alura.service.PetService;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

import java.util.Scanner;

public class AdopetConsoleApplication {

    public static void main(String[] args) {
        ClientHttpConfiguration client = new ClientHttpConfiguration();
        AbrigoService abrigoService = new AbrigoService(client);
        PetService petService = new PetService(client);
        Scanner scanner = new Scanner(System.in);

        System.out.println("##### BOAS VINDAS AO SISTEMA ADOPET CONSOLE #####");
        try {
            int opcaoEscolhida = 0;
            while (opcaoEscolhida != 5) {
                System.out.println("\nDIGITE O NÚMERO DA OPERAÇÃO DESEJADA:");
                System.out.println("1 -> Listar abrigos cadastrados");
                System.out.println("2 -> Cadastrar novo abrigo");
                System.out.println("3 -> Listar pets do abrigo");
                System.out.println("4 -> Importar pets do abrigo");
                System.out.println("5 -> Sair");

                String textoDigitado = scanner.nextLine().trim();

                if (!textoDigitado.isEmpty()) {
                    try {
                        opcaoEscolhida = Integer.parseInt(textoDigitado);

                        if (opcaoEscolhida == 1) {
                            abrigoService.listarAbrigo();
                        } else if (opcaoEscolhida == 2) {
                            abrigoService.cadastrarAbrigo();
                        } else if (opcaoEscolhida == 3) {
                            petService.listaPetDoAbrigo();
                        } else if (opcaoEscolhida == 4) {
                            petService.importaPetsDoAbrigo();
                        } else if (opcaoEscolhida == 5) {
                            break;
                        } else {
                            System.out.println("NÚMERO INVÁLIDO!");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Por favor, insira um número válido.");
                    }
                } else {
                    System.out.println("Entrada vazia! Por favor, insira um número.");
                }
            }
            System.out.println("Finalizando o programa...");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
