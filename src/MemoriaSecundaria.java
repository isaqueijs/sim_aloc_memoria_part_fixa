import java.util.ArrayList;

public class MemoriaSecundaria {
	private ArrayList<Processo> swap;

	public MemoriaSecundaria() {
		this.swap = new ArrayList<Processo>();
	}

	public ArrayList<Processo> getSwap() {
		return swap;
	}

	public void setSwap(Processo processo) {
		this.swap.add(processo);
	}

	@Override
	public String toString() {
		if (swap.isEmpty()) {
			return "Memoria Secundaria Vazia";
		}
		return "Memoria Secundaria - Processos:\n" + swap;
	}
	
}
