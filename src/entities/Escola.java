package entities;

public class Escola {

    private Classe[] classes;

    public Escola(int quantidadeDeClasses) {
        this.classes = new Classe[quantidadeDeClasses];
        inicializarClasses(quantidadeDeClasses);
    }

    private void inicializarClasses(int  quantidadeDeClasses) {
        int qtdClassesFundI = (int) Math.round(quantidadeDeClasses * 0.25);
        int qtdClassesFundII = (int) Math.round(quantidadeDeClasses * 0.4);
        int qtdClassesEM12 = (int) Math.round(quantidadeDeClasses * 0.1);
        int qtdClassesEM3 = quantidadeDeClasses - qtdClassesFundI - qtdClassesFundII - qtdClassesEM12;

        for (int i = 0; i < qtdClassesFundI; i++) {
            classes[i] = new Classe('1', 1 + i, (char) ('A' + i), 20, 'A');
        }
        for (int i = 0; i < qtdClassesFundII; i++) {
            classes[qtdClassesFundI + i] = new Classe('2', 6 + i, (char) ('A' + i), 30, 'A');
        }
        for (int i = 0; i < qtdClassesEM12; i++) {
            classes[qtdClassesFundI + qtdClassesFundII + i] = new Classe('M', 1 + i, (char) ('A' + i), 40, 'A');
        }
        for (int i = 0; i < qtdClassesEM3; i++) {
            classes[qtdClassesFundI + qtdClassesFundII + qtdClassesEM12 + i] = new Classe('M', 3, (char) ('A' + i), 40, 'A');
        }
    }

    // Métodos para retornar informações sobre as classes

    public int getQuantidadeDeClasses() {
        return classes.length;
    }

    public int getQuantidadeDeClassesPorNivel(char nivel) {
        int qtd = 0;
        for (Classe classe : classes) {
            if (classe.getNivel() == nivel) {
                qtd++;
            }
        }
        return qtd;
    }

    public int getQuantidadeDeAlunosPorNivel(char nivel) {
        int qtdAlunos = 0;
        for (Classe classe : classes) {
            if (classe.getNivel() == nivel) {
                qtdAlunos += classe.getTamanho();
            }
        }
        return qtdAlunos;
    }

    public Classe getClassePorTurma(char nivel, char turma) {
        for (Classe classe : classes) {
            if (classe.getNivel() == nivel && classe.getTurma() == turma) {
                return classe;
            }
        }
        return null;
    }

    // Métodos para alterar as informações sobre as classes

    public void alterarTamanhoDaClasse(char nivel, char turma, int novoTamanho) {
        Classe classe = getClassePorTurma(nivel, turma);
        if (classe != null) {
            classe.setTamanho(novoTamanho);
        }
    }

    public void alterarLocalDaClasse(char nivel, char turma, char novoLocal) {
        Classe classe = getClassePorTurma(nivel, turma);
        if (classe != null) {
            classe.setOnde(novoLocal);
        }
    }

    // Métodos para imprimir informações sobre as classes
    @Override
    public String toString() {
        String result = "";
        for (Classe classe : classes) result += classe.toString() + "\n";
        return result;
    }

    public void setOnde(int nivel) {
        for (Classe c : this.classes) {
            if (c.getNivel() == nivel) {
                c.setOnde('S');
            }
        }
    }

    public char getOnde(int nivel) {
        for (Classe c : this.classes) {
            if (c.getNivel() == nivel) {
                return c.getOnde();
            }
        }
        return 'C';
    }

    public int capacidade() {
        int capacidade = 0;
        for (Classe c : this.classes) {
            capacidade += c.getTamanho();
        }
        return capacidade;
    }

}
