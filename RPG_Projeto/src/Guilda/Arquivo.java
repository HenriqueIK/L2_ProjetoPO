package Guilda;

import java.util.ArrayList;
import java.io.*;

public class Arquivo{
    public void escrever(Personagem a){

        OutputStream os = null; // fluxo de entrada
        OutputStreamWriter osw = null; //leitor de fluxo de entrada
        BufferedWriter bw = null; //buffer entrada

        try{
            os = new FileOutputStream("Personagens.txt", true); // abrindo saida de dados
            osw = new OutputStreamWriter(os);
            bw = new BufferedWriter(osw);

            bw.write("======= PERSONAGENS =======\n"); // escrevendo no arquivo texto nome, classe, pv, mana e nivel
            bw.write(a.getNome() + "\n");
            bw.write(a.getClasse() + "\n");
            bw.write(a.getPv() + "\n");
            bw.write(a.getMana() + "\n");
            bw.write(a.getNivel() + "\n");

        }catch (Exception e){
            System.out.println("erro " + e);
        }finally{
            try{
                bw.close();
            }catch (Exception e){
            }
        }
    }
    public ArrayList<Personagem> ler(){

        ArrayList<Personagem> listando = new ArrayList<>();

        InputStream is = null; //fluxo saida
        InputStreamReader isr = null; //gerador de fluxo de saida
        BufferedReader br = null; // buffer de saida

        String aux; // variavel auxiliar

        try{
            // instanciando os objetos
            is = new FileInputStream("Personagens.txt");
            isr = new InputStreamReader(is);
            br = new BufferedReader(isr);

            // colocando o cursor no inicio do arquivo
            aux = br.readLine();

            while (aux != null){
                if (aux.contains("======= PERSONAGENS =======")){
                    Personagem p1 = new Personagem();

                    p1.setNome(br.readLine());
                    p1.setClasse(br.readLine());
                    p1.setPv(Integer.parseInt(br.readLine()));
                    p1.setMana(Integer.parseInt(br.readLine()));
                    p1.setNivel(Integer.parseInt(br.readLine()));
                    listando.add(p1); // adicionando personagem  na lista
                }
                aux = br.readLine();
            }
        }catch (Exception e){
        } finally{
            try{
                br.close();
            }catch (Exception e){
            }
        }
        return listando;
    }
}
