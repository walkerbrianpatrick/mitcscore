package mitcscore.compstruct.huffman;

import java.util.Deque;

public class HuffmanNode implements Comparable<HuffmanNode>{
	private String symbol;
	private Long count;
	private HuffmanNode left;
	private HuffmanNode right;
	
	public HuffmanNode(HuffmanNode left, HuffmanNode right) {
		this.left = left;
		this.right = right;
		this.count = 0L;
	}
	
	public HuffmanNode(String symbol) {
		this.symbol = symbol;
		this.count = 1L;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public Long getCount() {
		Long totalCount = 0L;
		
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((symbol == null) ? 0 : symbol.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (String.class == obj.getClass()) {
			return obj.equals(getSymbol());
		}
		if (getClass() != obj.getClass())
			return false;
		HuffmanNode other = (HuffmanNode) obj;
		if (symbol == null) {
			if (other.symbol != null)
				return false;
		} else if (!symbol.equals(other.symbol))
			return false;
		
		return true;
	}

	@Override
	public int compareTo(HuffmanNode o) {
		// TODO Auto-generated method stub
		return this.getCount().compareTo(o.getCount());
	}
}
