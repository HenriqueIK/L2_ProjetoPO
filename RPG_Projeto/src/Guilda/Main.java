package Guilda;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

import Exceptions.InfoInvalida;

// Tema do projeto: Você trabalha em uma guilda de aventureiros em um mundo de RPG, e precisa criar
// um programa que registre os nomes, classe, pontos de vida, pontos de magia e nivel dos personagens
// classes disponiveis: Guerreiro, Feiticeiro e Curandeiro

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in); // criando scanner para ler as entradas

        Personagem p = new Personagem(); // criando personagem

        Arquivo a = new Arquivo(); // criando arquivo

        boolean flag = true; // boolean para auxilio

        while (flag){
            ArrayList<Personagem> personagems = a.ler(); // ArrayList auxiliar para ler dados dos personagens

            System.out.println("====== Bem-Vindo aos arquivos da Guilda Dos Aventureiros! ======");
            System.out.println("1 - Criar personagem");
            System.out.println("2 - Listar personagens");
            System.out.println("3 - Ver a quantidade de personagens em cada classe");
            System.out.println("4 - Listar personagens em ordem crescente(Nivel)");
            System.out.println("5 - Sair do sistema");
            System.out.println("================================================================");

            int op = sc.nextInt(); // operador para switch
            sc.nextLine();

            switch (op){
                case 1:
                    System.out.println("Criando novo personagem à Guilda: ");
                    System.out.print("Nome: ");
                    p.setNome(sc.nextLine());

                    System.out.print("Classe: ");
                    try {
                        String Classe = sc.nextLine(); // Criando a Classe pro Personagem
                        p.setClasse(Classe);

                        if (!Classe.equals("Curandeiro") && !Classe.equals("Feiticeiro") && !Classe.equals("Guerreiro")) {
                            throw new InfoInvalida(Classe);
                        }
                    } catch (InfoInvalida e){ // para o sistema por detectar tipo invalido
                        break;
                    }
                    System.out.println("Pontos de Vida: ");
                    p.setPv(Integer.parseInt(sc.nextLine()));

                    System.out.print("Pontos de Mana: ");
                    p.setMana(Integer.parseInt(sc.nextLine()));

                    System.out.println("Nivel do personagem: ");
                    p.setNivel(Integer.parseInt(sc.nextLine()));

                    a.escrever(p); // escrevendo dados no arquivo
                    break;
                case 2:
                    System.out.println("Lista de personagens: "); // mostrando personagens.txt
                    for (int i = 0; i < personagems.size(); i++){
                    System.out.println("Nome: " + personagems.get(i).getNome());
                    System.out.println("Classe: " + personagems.get(i).getClasse());
                    System.out.println("PV: " + personagems.get(i).getPv());
                    System.out.println("Mana: " + personagems.get(i).getMana());
                    System.out.println("Nivel: " + personagems.get(i).getNivel());
                    }
                    break;
                case 3:
                    int g = 0; // quantidade de guerreiros
                    int c = 0; // quantidade de curandeiros
                    int f = 0; // quantidade de feiticeiros

                    System.out.println("Quantidade de personagens em cada classe: ");
                    for(int i = 0; i < personagems.size(); i++) {
                        if (personagems.get(i).getClasse().equals("Guerreiro")) {
                            g++;
                        }
                        if (personagems.get(i).getClasse().equals("Curandeiro")) {
                            c++;
                        }
                        if (personagems.get(i).getClasse().equals("Feiticeiro")) {
                            f++;
                        }
                    }
                    System.out.println("Guerreiros: " + g);
                    System.out.println("Curandeiros: " + c);
                    System.out.println("Feiticeiros: " + f);
                    break;
                case 4:
                    ArrayList<Personagem> persoNV = a.ler();
                    // ordenando de forma crescente o nivel dos personagens
                    Collections.sort(persoNV);

                    System.out.println("Nivel dos personagens em ordem crescente: ");
                    for(int i = 0; i < persoNV.size(); i++) {
                        System.out.println("Dados do personagem " + (i + 1) + ":");
                        System.out.println("\t" + persoNV.get(i).getNome());
                        System.out.println("\t" + persoNV.get(i).getClasse());
                        System.out.println("\t" + persoNV.get(i).getPv());
                        System.out.println("\t" + persoNV.get(i).getMana());
                        System.out.println("\t" + persoNV.get(i).getNivel());
                    }
                    break;
                case 5:
                    flag = false;
                    break;
            }
        }
    }
}