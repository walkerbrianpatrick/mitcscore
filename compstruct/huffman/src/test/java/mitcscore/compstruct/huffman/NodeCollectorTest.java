package mitcscore.compstruct.huffman;

import org.junit.Test;

public class NodeCollectorTest {

	@Test
	public void collectManySymbols() {

		String text = "abbcddd";

		NodeCollector nc = new NodeCollector();

		for (String t : text.split("")) {
			nc.collect(t);
		}

		assert(nc.getSymbols().size()==4);
		
	}
	
	
	@Test
	public void collectSymbolsInSingleUnits() {
		String text = "abbcddde";

		NodeCollector nc = new NodeCollector();

		nc.collectInUnits(text, 1);
		System.out.println(nc.getSymbols());
		assert(nc.getSymbols().size()==5);
		
	}
	
	@Test
	public void collectSymbolsInDoubleUnits() {
		String text = "abbcddde";

		NodeCollector nc = new NodeCollector();

		nc.collectInUnits(text, 2);
		System.out.println(nc.getSymbols());
		assert(nc.getSymbols().size()==4);
		
	}
	
	@Test
	public void collectSymbolsInDoubleUnitsWithOddInput() {
		String text = "abbcdddef";

		NodeCollector nc = new NodeCollector();

		nc.collectInUnits(text, 2);
		System.out.println(nc.getSymbols());
		assert(nc.getSymbols().size()==5);
		
	}
		
		
	
	
}
