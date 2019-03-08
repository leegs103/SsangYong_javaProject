package com.sist.hd.ctrl;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class StoreListCtrl {
	//한 줄씩 다 읽어서 리스트에 넣어주는 메서드
	public static ArrayList read(String path) throws FileNotFoundException {

		Scanner scan = new Scanner(new File(path));
		HashMap<String, String> storeMap = new HashMap<String, String>();
		ArrayList arrList = new ArrayList(); 
		while (scan.hasNextLine()) {
			String line = scan.nextLine();
			String[] data = line.split(",");
			arrList.add(line);
		}
		return arrList;
	}

	public static void main(String[] args) throws FileNotFoundException {
		String filepath = "src\\csv\\storeList.csv";
		read(filepath);
	}
}
