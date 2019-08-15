package mitcscore.compstruct.huffman;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Test;

public class HuffmanEncoderTest {

	@Test
	public void encodeShortString() {
		String text = "aaabbcddeee";
		HuffmanEncoder encoder = new HuffmanEncoder();
		encoder.analyze(text);
		
		String binary = encoder.encode(text);
		System.out.println(binary);
		System.out.println("Original Size (bits): "+ Integer.toString(text.getBytes().length*8));
		System.out.println("Binary Size (bits): "+ Integer.toString(binary.length()));
		System.out.println("Encoder Set:");
		encoder.printEncoder();	
	}
	
	@Test
	public void encodeBooks() {
		Path text = Paths.get("src/test/resources/sherlockHolmes.txt");
		HuffmanEncoder encoder = new HuffmanEncoder();
		encoder.analyze(text);
		
		String binary = encoder.encode(text);
		//System.out.println(binary);
		Long uncompressed = text.toFile().length()*8;
		Long compressed = (long)binary.length();
		System.out.println("Original Size (bits): "+ Long.toString(uncompressed));
		System.out.println("Binary Size (bits): "+ Long.toString(compressed));
		System.out.println("Compression Ratio: " + ((double)uncompressed)/((double)compressed));
		//System.out.println("Encoder Set:");
		//encoder.printEncoder();
	}
}
