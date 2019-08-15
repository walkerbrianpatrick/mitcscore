package mitcscore.compstruct.huffman;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
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
	
	
	public void collectInUnits(Path path, int units) {
		if(path.toFile().exists() && path.toFile().isFile()) {
			
			String line;
			try(BufferedReader reader = new BufferedReader(new FileReader(path.toString()))){
				while((line=reader.readLine())!=null) {
					collectInUnits(line, units);
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	public List<HuffmanNode> getSymbols() {
		return symbols;
	}

	public void setSymbols(List<HuffmanNode> symbols) {
		this.symbols = symbols;
	}
	
	public long getCountAllSymbols() {
		long result = 0;
		for(HuffmanNode symbol: symbols) {
			result += symbol.getCount();
		}
		return result;
	}
	
}
