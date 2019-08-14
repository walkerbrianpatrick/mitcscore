package mitcscore.compstruct.huffman;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Test;

public class HuffmanTreeBuilderTest {
	Path testText = Paths.get("src/test/resources/sherlockHolmes.txt");
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
	
	@Test
	public void createTreeForBigText() {
		NodeCollector nc = new NodeCollector();
		nc.collectFromFile(testText, 1);
		System.out.println("Number of unique symbols in text: "+ Long.toString(nc.getSymbols().size()));
		System.out.println("Number of total symbols in text: " + Long.toString(nc.getCountAllSymbols()));
		
		HuffmanNode node = HuffmanTreeBuilder.build(nc.getSymbols());
		
		HuffmanTreeBuilder.print(node);
	
	}
}
