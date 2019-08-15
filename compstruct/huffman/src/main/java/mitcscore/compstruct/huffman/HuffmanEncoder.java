package mitcscore.compstruct.huffman;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Map;
import java.util.Map.Entry;

public class HuffmanEncoder {

	private Map<String, String> encoder;
	private HuffmanNode node;

	public HuffmanEncoder() {
	}

	public void analyze(String text) {
		NodeCollector nc = new NodeCollector();
		nc.collectInUnits(text, 1);
		node = HuffmanTreeBuilder.build(nc.getSymbols());

		encoder = HuffmanTreeBuilder.getEncoderFromTree(node);
	}

	public void analyze(Path path) {
		NodeCollector nc = new NodeCollector();
		nc.collectInUnits(path, 1);
		node = HuffmanTreeBuilder.build(nc.getSymbols());
		encoder = HuffmanTreeBuilder.getEncoderFromTree(node);
	}

	// TODO: refactor once bi-trigram support is implemented
	public String encode(String text) {
		if(encoder==null) {
			System.out.println("error, encoder not set. Invoke analyze on "
					+ "some source text before invoking this method.");
			System.exit(1);
		}
		
		return encodeOneLine(text);
	}

	public String encode(Path path) {
		if (encoder == null) {
			System.out.println(
					"error, encoder not set. Invoke analyze on " + "some source text before invoking this method.");
			System.exit(1);
		}
		String binary = "";
		if (path.toFile().exists() && path.toFile().isFile()) {

			String line;
			try (BufferedReader reader = new BufferedReader(new FileReader(path.toString()))) {
				while((line = reader.readLine())!=null) {
				binary = binary + encodeOneLine(line);
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return binary;
	}

	private String encodeOneLine(String text) {
		String binary = "";
		for (int i = 0; i < text.length(); i++) {
			if (encoder.containsKey(text.substring(i, i + 1))) {
				binary = binary + encoder.get(text.substring(i, i + 1));
			} else {
				System.out.println("Unexpected symbol detected. It will" + " be lost from the encoded binary string: "
						+ text.substring(i, i + 1));
			}
		}
		return binary;
	}

	public void printEncoder() {
		for (Entry<String, String> entry : encoder.entrySet()) {
			System.out.println(entry);
		}
	}

}
