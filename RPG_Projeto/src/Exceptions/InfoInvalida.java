package Exceptions;

public class InfoInvalida extends Exception{
    public InfoInvalida(String Classe){ // mostrar essa mensagem caso a classe nao exista no sistema
        System.out.println("A classe: " + Classe + ", não existe!");
    }
}