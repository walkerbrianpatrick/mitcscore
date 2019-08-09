package mitcscore.compstruct.huffman;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NodeCollector {

	List<HuffmanNode> symbols;
	
	public NodeCollector(){
		symbols = new ArrayList<>();
	}
	
	public void collect(String sym) {
		HuffmanNode nsym =  new HuffmanNode(sym);
		if(!symbols.contains(nsym)) {
			symbols.add(nsym);
		} else {
			symbols.get(symbols.indexOf(nsym)).increment();
		}
	}

	// collect in arbitrary sized units, not quite bi/trigram logic
	// but a step towards it
	public void collectInUnits(String text, int units) {
		Queue<String> symbols = new LinkedList<>();
		int i;
		for(i=0; i<text.length()&& i+units<=text.length();i+=units) {
			symbols.add(text.substring(i, i+units));
		}
		// catch the last bit
		if(i+units>=text.length() && i<text.length()) {
			symbols.add(text.substring(i, text.length()));
		}
		
		while(!symbols.isEmpty()) {
			collect(symbols.poll());
		}
	}
	
	public List<HuffmanNode> getSymbols() {
		return symbols;
	}

	public void setSymbols(List<HuffmanNode> symbols) {
		this.symbols = symbols;
	}
	
	
	
}
