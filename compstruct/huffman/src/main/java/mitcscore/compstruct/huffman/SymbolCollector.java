package mitcscore.compstruct.huffman;

import java.util.Set;

public class SymbolCollector {

	Set<String> symbols;
	
	public void collect(String sym) {
	
		if(!symbols.contains(sym)) {
			symbols.add(sym);
		}
	}
	
	
}
