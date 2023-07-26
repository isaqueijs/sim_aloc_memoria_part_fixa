import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static final int NUMERO_PARTICOES = 5;
	public static final int[] VALOR_MAXIMO_PORCENTAGEM = {25, 25, 20, 15, 15};

	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);
		ArrayList<Processo> listaProcessos = new ArrayList<Processo>();

		System.out.println("--------------------------------------------------------------\n"
				+ "Gerenciamento de Memória" + "\n--------------------------------------------------------------");
		System.out.print("Digite o tamanho da memória física (MB): ");
		int tamanhoMemoria = ler.nextInt();
//		int tamanhoParticoes = tamanhoMemoria / 5;
//		System.out.print("O sistema possui 5 partições de " + tamanhoParticoes + "MB cada.\n");
		
		System.out.println("O sistema possui 5 partições!");

		System.out.print("Digite o número de processos que deseja criar: ");
		int qtdProcessos = ler.nextInt();

		for (int i = 0; i < qtdProcessos; i++) {
//			System.out.print("Digite o NOME do processo: ");
			System.out.print("Digite o NOME, PID e TAMANHO (MB) do processo: ");
			String nome = ler.next();
//			System.out.print("Digite o ID do processo: ");
			int id = ler.nextInt();
//			System.out.print("Digite o TAMANHO do processo (MB): ");
			int tamanhoProcesso = ler.nextInt();

			listaProcessos.add(new Processo(nome, id, tamanhoProcesso));
		}
		System.out.println("Pronto, " + qtdProcessos + " processos criados com sucesso!");
		Memoria memoria = new Memoria(tamanhoMemoria, Main.NUMERO_PARTICOES);

		System.out.println("--------------------------------------------------------------\n"
				+ "Agora vamos começar a alocar os processos"
				+ "\n--------------------------------------------------------------");
		FirstFit ffit = new FirstFit(memoria, listaProcessos);
		ffit.alocarProcessos();
		
		ler.close();

	}

	public static void delay(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}


/*
code.exe 1 26
chrome.exe 2 130
explorer.exe 3 88
teams.exe 4 163
sophos.exe 5 140
chrome.exe 6 130
msedge.exe 7 63
MsSense.exe 8 102
McsAgent.exe 9 39
WmiPrvSE.exe 10 48
 */