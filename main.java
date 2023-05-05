import java.util.Random;



public class main {

   public static void main(String[] args) {

       Random random = new Random();

       Funcionario[] funcionarios = new Funcionario[10];



       // Criação dos funcionários com informações aleatórias

for (int i = 0; i < funcionarios.length; i++) {

   String nome = "Funcionário " + (i + 1);

   int escolaridade;

   if (i < funcionarios.length * 0.4) {

       escolaridade = 1; // 40% com ensino básico

   } else if (i < funcionarios.length * 0.8) {

       escolaridade = 2; // 40% com ensino médio

   } else {

       escolaridade = 4; // 20% com nível superior

   }

   if (escolaridade < 4) {

       funcionarios[i] = new Funcionario(nome, escolaridade, null);

   } else {

       funcionarios[i] = new Funcionario(nome, escolaridade, "Universidade " + (i + 1));

   }

}





       // Cálculo dos custos da empresa

       double totalSalarios = 0.0;

       double salariosEnsinoBasico = 0.0;

       double salariosEnsinoMedio = 0.0;

       double salariosNivelSuperior = 0.0;

       for (Funcionario funcionario : funcionarios) {

           totalSalarios += funcionario.getRendaTotal();

           switch (funcionario.getEscolaridade()) {

               case 1:

                   salariosEnsinoBasico += funcionario.getRendaTotal();

                   break;

               case 2:

               case 3:

                   salariosEnsinoMedio += funcionario.getRendaTotal();

                   break;

               case 4:

                   salariosNivelSuperior += funcionario.getRendaTotal();

                   break;

               default:

                   break;

           }

       }



       // Impressão dos resultados

       System.out.println("Custos da empresa:");

       System.out.printf("- Salários totais: R$ %.2f%n", totalSalarios);

       System.out.printf("- Salários por nível de escolaridade:%n");

       System.out.printf(" * Ensino básico: R$ %.2f (%.1f%%)%n", salariosEnsinoBasico, salariosEnsinoBasico / totalSalarios * 100.0);

       System.out.printf(" * Ensino médio: R$ %.2f (%.1f%%)%n", salariosEnsinoMedio, salariosEnsinoMedio / totalSalarios * 100.0);

       System.out.printf(" * Nível superior: R$ %.2f (%.1f%%)%n", salariosNivelSuperior, salariosNivelSuperior / totalSalarios * 100.0);

   }



   static class Funcionario {

       private final String nome;

       private final int escolaridade;

       private final String instituicao;

       private double rendaTotal;



       public Funcionario(String nome, int escolaridade, String instituicao) {

           this.nome = nome;

           this.escolaridade = escolaridade;

           this.instituicao = instituicao;

           this.rendaTotal = 1000.0;

       switch (escolaridade) {

           case 2:

               this.rendaTotal *= 1.1;

               break;

           case 3:

               this.rendaTotal *= 1.5;

               break;

           case 4:

               this.rendaTotal *= 2.0;

               break;

           default:

               break;

       }

   }



   public String getNome() {

       return nome;

   }



   public int getEscolaridade() {

       return escolaridade;

   }



   public String getInstituicao() {

       return instituicao;

   }



   public double getRendaTotal() {

       return rendaTotal;

   }



   public void setRendaTotal(double rendaTotal) {

       this.rendaTotal = rendaTotal;

   }

}

}