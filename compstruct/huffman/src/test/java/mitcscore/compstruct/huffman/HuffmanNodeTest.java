package mitcscore.compstruct.huffman;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

public class HuffmanNodeTest {

	@Test
	public void singleNode() {
		
		HuffmanNode node = new HuffmanNode("a");
		assert(node.getSymbol().equals("a"));
		assert(node.getCount() == 1);
	}
	
	@Test
	public void threeNodes() {
		HuffmanNode left= new HuffmanNode("a");
		HuffmanNode right= new HuffmanNode("b");
		HuffmanNode center = new HuffmanNode(left, right);
		
		assert(center.getCount()==2);
	}
	
	@Test
	public void decodeSymbolA() {
		HuffmanNode left= new HuffmanNode("a");
		HuffmanNode right= new HuffmanNode("b");
		HuffmanNode center = new HuffmanNode(left, right);
		Deque<String> buffer = new LinkedList<>();
		buffer.add("0");
		String result = center.decode(buffer);
		assert(result.contentEquals("a"));
	}
	
	@Test
	public void decodeSymbolB() {
		HuffmanNode left= new HuffmanNode("a");
		HuffmanNode right= new HuffmanNode("b");
		HuffmanNode center = new HuffmanNode(left, right);
		Deque<String> buffer = new LinkedList<>();
		buffer.add("1");
		String result = center.decode(buffer);
		assert(result.contentEquals("b"));
	}
	
	@Test
	public void decodeBalancedSymbols() {
		
		HuffmanNode node = balancedTree();
		
		Deque<String> buffer = new LinkedList<>();
		
		buffer.add("0");
		buffer.add("0");
		String result = node.decode(buffer);
		System.out.println(result);
		assert(result.equals("a"));
		
		buffer.add("0");
		buffer.add("1");
		result = node.decode(buffer);
		System.out.println(result);
		assert(result.equals("b"));
		
		buffer.add("1");
		buffer.add("0");
		result = node.decode(buffer);
		System.out.println(result);
		assert(result.equals("c"));
		
		buffer.add("1");
		buffer.add("1");
		result = node.decode(buffer);
		System.out.println(result);
		assert(result.equals("d"));
		
	}
	
	
	private HuffmanNode balancedTree() {
		HuffmanNode a= new HuffmanNode("a");
		HuffmanNode b= new HuffmanNode("b");
		HuffmanNode c= new HuffmanNode("c");
		HuffmanNode d= new HuffmanNode("d");
		HuffmanNode ab= new HuffmanNode(a,b);
		HuffmanNode cd= new HuffmanNode(c,d);
		HuffmanNode abcd= new HuffmanNode(ab,cd);
		
		return abcd;
	}
	
	
	
	@Test
	public void sandbox() {
		
	}
}
