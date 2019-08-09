package mitcscore.compstruct.huffman;

import java.util.List;
import java.util.PriorityQueue;

public class HuffmanTreeBuilder {

	private HuffmanTreeBuilder() {};
	
	public static HuffmanNode build(List<HuffmanNode> nodes) {
		PriorityQueue<HuffmanNode> priorityQueue = new PriorityQueue<>();
		
		for(HuffmanNode node : nodes) {
			priorityQueue.add(node);
		}
		
		HuffmanNode node = null;
		while(priorityQueue.size()>1) {
			node = new HuffmanNode(priorityQueue.poll(), priorityQueue.poll());
			priorityQueue.add(node);
		}
		return node;
	}
	
}
