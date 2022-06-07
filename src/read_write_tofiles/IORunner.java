package read_write_tofiles;

import java.io.*;
import java.util.Scanner;

import assign1.HuffmanEncoderDecoder;

public class IORunner
{

	static String IN_FILE_PATH = "Smiley.bmp";
	static String OUT_FILE_PATH = "b.txt";
	static String END_FILE_PATH = "Smileyb.bmp";

	public static void main(String[] args)
	{
		FileInputStream input;
		FileOutputStream output;
		FileOutputStream end;
		try
		{
			input = new FileInputStream(IN_FILE_PATH);	
			output = new FileOutputStream(OUT_FILE_PATH);
			end = new FileOutputStream(END_FILE_PATH);

			String mishpat = "a";
			StringBuilder fb = new StringBuilder();
			int i = 1;
			while (true)				

			{
				int x = input.read();

				if (x != -1) // -1 is EOF
				{


					for (char character : mishpat.toCharArray()) {
						fb.append((char)x);

					}

				}
				else
				{

					break;
				}
			}


			HuffmanEncoderDecoder huffman = new HuffmanEncoderDecoder(fb.toString());
			String encodedData = huffman.encodeData();
			
			byte[] byteArray = encodedData.getBytes();




			for (int j = 0; j < byteArray.length; j++) {
			
				byte a = byteArray[j];
				output.write(a);
			}


			String originalData = huffman.decode(encodedData);
//			System.out.println(originalData);
			for (int j = 0; j < originalData.length(); j++) {
				char b = originalData.charAt(j);
				end.write(b);
			}
			huffman.printCode();
			input.close();
			output.close();

		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
