package mitcscore.compstruct.huffman;

import org.junit.Test;

public class HuffmanTreeBuilderTest {

	@Test
	public void createTree() {
		String text = "abbcddde";

		NodeCollector nc = new NodeCollector();

		nc.collectInUnits(text, 1);
		
		HuffmanNode node = HuffmanTreeBuilder.build(nc.getSymbols());
		
		//TODO: implement a tree print algorithm here for observation
		//     
		System.out.println(node);
		
	}
	
	
}
