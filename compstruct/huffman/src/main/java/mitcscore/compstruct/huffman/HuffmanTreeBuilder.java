package mitcscore.compstruct.huffman;


import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

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
	
	// TODO: fix the alignment here due to symbol size
	//       This gets close enough to validate the concept
	//       but it could be better
	public static void print(HuffmanNode node) {
		Queue<HuffmanNode> nodes = new LinkedList<>();
		HuffmanNode current;
		nodes.add(node);
		String line;
		
		// start with knowing the number of symbols
		long printWidth = node.numNodes();
		
		while(!nodes.isEmpty()) {
			int nodesize = nodes.size();
			String fullline = "";
			for(int i =0; i<nodesize; i++) {
				current = nodes.poll();
				line = current.toString();
				if(current.getLeft()!=null) {
					line = " ".repeat(current.getLeft().numNodes()) + line;
					nodes.add(current.getLeft());
				}
				if(current.getRight()!=null) {
					line = line + " ".repeat(current.getRight().numNodes());
					nodes.add(current.getRight());
				}
				
				
				fullline = fullline+line;
			}
			if(fullline.length()<printWidth) {
				fullline = " ".repeat((int)printWidth-fullline.length()) + fullline;
			}
			System.out.println(fullline);
		}
		
	}
	
}
