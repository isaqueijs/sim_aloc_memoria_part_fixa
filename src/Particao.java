
public class Particao {
	private int tamanho;
	private int posicao;
	private Processo processo;
	
	public Particao(int tamanho, int posicao) {
		this.tamanho = tamanho;
		this.posicao = posicao;
		this.processo = null;
	}
	
	public int getTamanho() {
		return tamanho;
	}
	

	public int getPosicao() {
		return posicao;
	}

	public Processo getProcesso() {
		return processo;
	}

	public void setProcesso(Processo processo) {
		this.processo = processo;
	}

	@Override
	public String toString() {
		if (processo == null) return "Particao " + posicao + ", Tamanho: " + tamanho + "MB, " + " Disponível\n";
		return "Particao " + posicao + ", Tamanho: " + tamanho + "MB, " + " Processo: " + processo;
	}
	
	
}
