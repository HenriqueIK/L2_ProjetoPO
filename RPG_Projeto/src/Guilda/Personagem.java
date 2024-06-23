package Guilda;

public class Personagem implements Comparable<Personagem>{
    private String Nome; // nome do personagem
    private int Pv; // pontos de vida do personagem
    private String Classe; // classe do personagem
    private int Mana; // pontos de magia do personagem
    private int Nivel; // nivel do personagem
    public String getNome(){
        return Nome;
    }
    public void setNome(String nome){
        Nome = nome;
    }
    public int getPv(){
        return Pv;
    }
    public void setPv(int pv){
        Pv = pv;
    }
    public String getClasse(){
        return Classe;
    }
    public void setClasse(String classe){
        Classe = classe;
    }
    public int getMana(){
        return Mana;
    }
    public void setMana(int mana){
        Mana = mana;
    }
    public int getNivel(){
        return Nivel;
    }
    public void setNivel(int nivel){
        this.Nivel = nivel;
    }
    @Override
    public int compareTo(Personagem e){
        return Integer.compare(Nivel, e.Nivel);
    }
}