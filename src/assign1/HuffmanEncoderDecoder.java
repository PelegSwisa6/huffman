package assign1;

import static java.util.Objects.requireNonNull;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Assignment 1
 * Submitted by: 
 * Student 1. 	ID# XXXXXXXXX
 * Student 2. 	ID# XXXXXXXXX
 */

// Uncomment if you wish to use FileOutputStream and FileInputStream for file access.
//import java.io.FileOutputStream;
//import java.io.FileInputStream;

import base.Compressor;

public class HuffmanEncoderDecoder implements Compressor
{
	private Node root;
	private final String lines;
	private Map<Character, Integer> charFreq;
	private final Map<Character, String> huffmanCode;

	public HuffmanEncoderDecoder(String lines)
	{
		this.lines = lines;
		fillCharFreqMap();
		huffmanCode = new HashMap<>();
	}
	private void fillCharFreqMap() {
		charFreq = new HashMap<>();
		for (char character : lines.toCharArray()) {
			Integer integer = charFreq.get(character);
			charFreq.put(character, integer != null ? integer + 1 : 1);
		}
	}
		
		public String encodeData() {
			Queue<Node> queue = new PriorityQueue<>();
			charFreq.forEach((character, freq) ->
			queue.add(new Node(character, freq)));
			while (queue.size() > 1) {
				queue.add(new Node(queue.poll(), requireNonNull(queue.poll())));
			}
			huffmanOperate(root = queue.poll(), "");
			return getEncodedData();
		}
		
		 private void huffmanOperate(Node node, String code) {
		        if (node.getRightNode() == null && node.getLeftNode() == null) {
		        	huffmanCode.put( node.getCharacter(), code);
		            return;
		        }
		        huffmanOperate(node.getLeftNode(), code.concat("0"));
		        huffmanOperate(node.getRightNode(), code.concat("1"));
		    }
		 private String getEncodedData() {
		        StringBuilder sb = new StringBuilder();
		        for (char character : lines.toCharArray()) {
		            sb.append(huffmanCode.get(character));
		        }
		        return sb.toString();
		    }
		 public String decode(String decodeData) {
		        StringBuilder sBuilder = new StringBuilder();
		        Node current = root;
		        for (char character : decodeData.toCharArray()) {
		            current = character == '0' ? current.getLeftNode() : current.getRightNode();
		            if (current.getRightNode() == null && current.getLeftNode() == null) {
		            	sBuilder.append( current.getCharacter());
		                current = root;
		            }
		        }
		        return sBuilder.toString();
		    }
		 public void printCode() {
			 huffmanCode.forEach((character, code) ->
		                System.out.println(character + ": " + code)
		        );
		    }
		 
		 

		@Override
		public void Compress(String[] input_names, String[] output_names)
		{
			// TODO Auto-generated method stub

		}

		@Override
		public void Decompress(String[] input_names, String[] output_names)
		{
			// TODO Auto-generated method stub

		}

		@Override
		public byte[] CompressWithArray(String[] input_names, String[] output_names)
		{
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public byte[] DecompressWithArray(String[] input_names, String[] output_names)
		{
			// TODO Auto-generated method stub
			return null;
		}

	}
