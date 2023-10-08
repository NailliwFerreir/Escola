package entities;

public class Classe {

    private char nivel;
    private int ano;
    private char turma;
    private int tamanho;
    private char onde;

    public Classe(char nivel, int ano, char turma, int tamanho, char onde) {
        this.nivel = nivel;
        this.ano = ano;
        this.turma = turma;
        this.tamanho = tamanho;
        this.onde = onde;
    }

    public char getNivel() {
        return nivel;
    }

    public void setNivel(char nivel) {
        this.nivel = nivel;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public char getTurma() {
        return turma;
    }

    public void setTurma(char turma) {
        this.turma = turma;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public char getOnde() {
        return onde;
    }

    public void setOnde(char onde) {
        this.onde = onde;
    }

    @Override
    public String toString() {
        return "Classe nível: " + this.nivel +", ano: "+this.ano + ", turma: " + this.turma +", local: " +this.onde+", quantidade de alunos: " + this.tamanho;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == null) throw new NullPointerException("obj");
        if(obj.getClass() != this.getClass()) return false;
        Classe other = (Classe) obj;
        if (this.ano!= other.ano) return false;
        if (this.nivel!= other.nivel) return false;
        if (this.turma!= other.turma) return false;
        if (this.onde!= other.onde) return false;
        if (this.tamanho!= other.tamanho) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 777;
        hash = 31 * hash + Integer.valueOf(this.nivel).hashCode();
        hash = 31 * hash + Integer.valueOf(this.turma).hashCode();
        hash = 31 * hash + Integer.valueOf(this.onde).hashCode();
        hash = 31 * hash + Integer.valueOf(this.ano).hashCode();
        hash = 31 * hash + Integer.valueOf(this.tamanho).hashCode();
        if (hash < 0) hash = -hash;
        return hash;
    }

}


