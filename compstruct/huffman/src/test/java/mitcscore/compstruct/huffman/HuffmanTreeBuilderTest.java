package mitcscore.compstruct.huffman;

import org.junit.Test;

public class HuffmanTreeBuilderTest {

	@Test
	public void createTree() {
		String text = "abbcddde";

		NodeCollector nc = new NodeCollector();

		nc.collectInUnits(text, 1);
		
		HuffmanNode node = HuffmanTreeBuilder.build(nc.getSymbols());
		
		HuffmanTreeBuilder.print(node);
		
	}
	
	@Test
	public void createBalancedTree() {
		String text = "aabbccdd";

		NodeCollector nc = new NodeCollector();

		nc.collectInUnits(text, 1);
		
		HuffmanNode node = HuffmanTreeBuilder.build(nc.getSymbols());
		
		HuffmanTreeBuilder.print(node);
		
	}

	
	
}
