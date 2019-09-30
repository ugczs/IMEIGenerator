package com.IMEI.Gen;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		PrintStream fileStream = new PrintStream("IMEI.txt");
		System.setOut(fileStream);
        ImeiGenerator iG= new ImeiGenerator();
        iG.calculateIMEI();
	}
}
