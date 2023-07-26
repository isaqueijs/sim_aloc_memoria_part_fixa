
public class Processo {

	private String nome;
	private int id;
    private int tamanho;

    public Processo(String nome, int id, int tamanho) {
    	this.nome = nome;
    	this.id = id;
        this.tamanho = tamanho;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

	public int getTamanho() {
		return tamanho;
	}

	@Override
	public String toString() {
		return "Nome:" + nome + ", PID:" + id + ", Tamanho:" + tamanho + "MB\n";
	}
	

   
}