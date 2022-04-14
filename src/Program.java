import java.util.Locale;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("Qual a quantidade de atletas? ");
		int quantidade = sc.nextInt();
		sc.nextLine();
		System.out.println("");

		int qtdHomens = 0, qtdMulheres = 0;
		String name, higherName = "a";
		char sex;
		double totalWeight = 0.0, weight, avgWeight, height, higher = 0.0,
				totalHeightFemale = 0.0, porcentagemHomens, avgHeightFemale;

		for (int i = 1; i <= quantidade; i++) {
			System.out.println("Digite os dados do atleta numero " + i);
			System.out.print("Nome: ");
			name = sc.nextLine();
			System.out.print("Sexo: ");
			sex = sc.next().charAt(0);
			sc.nextLine();
			while (sex != 'F' & sex != 'M') {
				System.out.print("Digite F ou M! ");
				sex = sc.next().charAt(0);
				sc.nextLine();
			}
			System.out.print("Altura: ");
			height = sc.nextDouble();
			sc.nextLine();
			while (height <= 0) {
				System.out.print("Valor inválido! Favor digitar um valor positivo");
				height = sc.nextDouble();
				sc.nextLine();
			}
			// Definindo maior atleta
			if (height > higher) {
				higher = height;
				higherName = name;
			}
			System.out.print("Peso: ");
			weight = sc.nextDouble();
			sc.nextLine();
			   while (weight <= 0) {
				   System.out.print("Valor invalido! Favor digitar um valor positivo: ");
				   weight = sc.nextDouble();
				   sc.nextLine();
			   }
			// Calculo da média dos pesos dos atletas
			totalWeight += weight;
			// Média altura das mulheres
			if (sex == 'F') {
				totalHeightFemale += height;
				qtdMulheres++;
			}

			if (sex == 'M') {
				qtdHomens += 1;
			}
			System.out.println();
		}
		//Calculo peso médio dos atletas
		avgWeight = totalWeight/quantidade;
		// Calculo porcentagem de homens
		porcentagemHomens = (double) qtdHomens / quantidade * 100.0;
		// Calculo porcentagem peso das mulheres
		avgHeightFemale = totalHeightFemale / qtdMulheres;

		System.out.println("Relatório:");
		System.out.printf("Peso médio dos atletas: %.2f %%%n", avgWeight);
		System.out.println("Atleta mais alto: " + higherName);
		System.out.printf("Porcentagem de homens: %.1f %%%n", porcentagemHomens);
		if (avgHeightFemale > 0) {
			System.out.println("Altura média das mulheres: " + avgHeightFemale);
		} else {
			System.out.println("Não há mulheres cadastradas!");
		}

		sc.close();
	}

}
