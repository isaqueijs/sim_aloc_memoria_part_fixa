import java.util.ArrayList;
import java.util.Random;

public class FirstFit {

	private Memoria memoria;
	private MemoriaSecundaria memoriaSec;
	private ArrayList<Processo> listaProcessos;
	private Random random = new Random();

	public FirstFit(Memoria memoria, ArrayList<Processo> listaProcessos) {
		this.memoria = memoria;
		this.memoriaSec = new MemoriaSecundaria();
		this.listaProcessos = listaProcessos;
	}

	public void alocarProcessos() {

		System.out.println(memoria.toString());
		int numeroAleatorio = 0;

		for (Processo processo : listaProcessos) {
			boolean alocOuSwap = false;
			System.out.println("\nAlocando Processo : " + processo.toString() + "...");
			System.out.println(memoriaSec.toString());
			
			for (Particao particao : memoria.getParticoes()) {
				if (particao.getProcesso() == null && particao.getTamanho() >= processo.getTamanho()) {
					particao.setProcesso(processo);
					memoria.setCapacidadeAtual();
					alocOuSwap = true;
					break;
				} else if (memoria.getQtdPartDisponiveis() == 0) {
					System.out.println("--------------------------------------------------------------\n"
							+ "Não há partição disponícel, realizando Swapping"
							+ "\n--------------------------------------------------------------");
					numeroAleatorio = random.nextInt(memoria.getQtdParticoes());
					memoriaSec.setSwap(memoria.getParticoes().get(numeroAleatorio).getProcesso());
					memoria.getParticoes().get(numeroAleatorio).setProcesso(null);
					memoria.setCapacidadeAtual();
					alocOuSwap = true;
					System.out.println(memoriaSec.toString());
				}
			}
			
			if (!alocOuSwap) {
				System.out.println("--------------------------------------------------------------\n"
						+ "Não há partição livre com pelo menos "+ processo.getTamanho() +"MB, realizando Swapping"
						+ "\n--------------------------------------------------------------");
				numeroAleatorio = random.nextInt(memoria.getQtdParticoes());
				memoriaSec.setSwap(memoria.getParticoes().get(numeroAleatorio).getProcesso());
				memoria.getParticoes().get(numeroAleatorio).setProcesso(null);
				memoria.setCapacidadeAtual();
				System.out.println(memoriaSec.toString());
			}
			
			System.out.println("--------------------------------------------------------------\n"
					+ memoria.toString());
			Main.delay(1000);
		}

	}

}
