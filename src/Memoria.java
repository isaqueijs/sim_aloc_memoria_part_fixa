import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Memoria {
	private int capacidade;
	private int capDisponivel;
	private int qtdParticoes;
	private int qtdPartDisponiveis;
	private ArrayList<Particao> particoes;
	Random random = new Random();

	public Memoria(int capacidade, int qtdParticoes) {
		this.capacidade = capacidade;
		this.capDisponivel = capacidade;
		this.qtdParticoes = qtdParticoes;
		this.qtdPartDisponiveis = qtdParticoes;
		ArrayList<Particao> particoes = new ArrayList<Particao>();

		for (int i = 1; i <= qtdParticoes; i++) {
			int porcentagem = Main.VALOR_MAXIMO_PORCENTAGEM[i - 1];
			int memoriaParticao = (porcentagem * capacidade) / 100;
			particoes.add(new Particao(memoriaParticao, i));

		}

//		for (int i = 1; i <= qtdParticoes; i++) {
//			particoes.add(new Particao(this.capacidade / qtdParticoes, i));
//		}

		this.particoes = particoes;
	}

	public ArrayList<Particao> getParticoes() {
		return particoes;
	}

	public void setParticoes(ArrayList<Particao> particoes) {
		this.particoes = particoes;
	}

	public int getCapacidade() {
		return capacidade;
	}

	public int getCapDisponivel() {
		return capDisponivel;
	}

	public void setCapacidadeAtual() {

		int tamanho = 0, partOcupadas = 0;

		for (Particao particao : getParticoes()) {
			if (particao.getProcesso() != null) {
				tamanho += particao.getProcesso().getTamanho();
				partOcupadas += 1;
			}
		}

		setQtdPartDisponiveis(this.qtdParticoes - partOcupadas);
		this.capDisponivel = this.capacidade - tamanho;
	}

	public int getQtdParticoes() {
		return qtdParticoes;
	}

	public int getQtdPartDisponiveis() {
		return qtdPartDisponiveis;
	}

	public void setQtdPartDisponiveis(int qtdPartDisponiveis) {
		this.qtdPartDisponiveis = qtdPartDisponiveis;
	}

	@Override
	public String toString() {
		return "Memória - Capacidade Total: " + capacidade + "MB, Memória Disponível: " + capDisponivel
				+ "MB, Num. Part Disponíveis: " + qtdPartDisponiveis + ", Particoes:\n" + particoes;
	}

}
