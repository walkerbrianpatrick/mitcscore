package mitcscore.compstruct.huffman;

import java.util.Deque;

public class HuffmanNode {
	private String symbol;
	private long count;
	private HuffmanNode left;
	private HuffmanNode right;
	
	public HuffmanNode(HuffmanNode left, HuffmanNode right) {
		this.left = left;
		this.right = right;
		this.count = 0;
	}
	
	public HuffmanNode(String symbol) {
		this.symbol = symbol;
		this.count = 1;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public long getCount() {
		long totalCount = 0;
		
		if(left!=null) {
			totalCount += left.getCount();
		}
		if (right!=null) {
			totalCount += right.getCount();
		}
		
		return count + totalCount;
	}

	public void increment() {
		this.count++;
	}

	public HuffmanNode getLeft() {
		return left;
	}

	public void setLeft(HuffmanNode left) {
		this.left = left;
	}

	public HuffmanNode getRight() {
		return right;
	}

	public void setRight(HuffmanNode right) {
		this.right = right;
	}
	
	public String decode(Deque<String> buffer) {		
		// catch the buffer being empty
		if(buffer.isEmpty() && symbol == null) {
			return null;
		}
		
		if (symbol!=null) {
			return symbol;
		} else if (buffer.peek().equals("0")){
			buffer.remove();
			return left.decode(buffer);
		} else if (buffer.peek().equals("1")){
			buffer.remove();
			return right.decode(buffer);
		}
		return null;
	}

	@Override
	public String toString() {
		return "HuffmanNode [symbol=" + symbol + ", count=" + count + ", left=" + left + ", right=" + right + "]";
	}
	
	
}
