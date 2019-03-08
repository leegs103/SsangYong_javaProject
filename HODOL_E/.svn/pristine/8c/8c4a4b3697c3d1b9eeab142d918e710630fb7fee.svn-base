package com.sist.hd.ctrl;

//File,FileReader,FileNotFoundException,BufferedReader,IOException
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import java.util.Locale;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.TableModel;

import com.sist.hd.dao.OrderDAO;
import com.sist.hd.vo.CartVO;
import com.sist.hd.vo.OrderVO;

public class CartCtrl {
	public static ArrayList<CartVO> cartList;
	public static OrderVO orderVO = new OrderVO(); // OrderVO 객체 생성
	public static OrderDAO orderDAO = new OrderDAO();
	public static List cartList2 = new ArrayList();
	public static Object combo;

	public CartCtrl() {
		cartList = new ArrayList<CartVO>();
	}

	public void add(CartVO cartStr) {
		cartList.add(cartStr);
	}

	public static void readFromCSV(String filename) {
		File file = new File(filename);
		FileReader reader = null;
		try {
			reader = new FileReader(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		}
		BufferedReader infile = new BufferedReader(reader);
		String line = "";

		try {
			boolean done = false;
			while (!done) {
				line = infile.readLine();
				if (line == null) {
					done = true;
				} else {
					String[] tokens = line.trim().split(",");
					String item = tokens[0].trim();
					String method = tokens[1].trim();
					String price = tokens[2].trim();
					CartVO sb = new CartVO(item, method, price);
					cartList.add(sb);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	public static void initCSV(String path) throws FileNotFoundException {
		PrintWriter pw = new PrintWriter(path);
		pw.println("");

		pw.close();
	}

	public static boolean saveToCSV(List list, String pathToExportTo) {
		try {
			FileWriter csv = new FileWriter(new File(pathToExportTo));

			// for (int i = 0; i < model.getColumnCount(); i++) {
			// csv.write(model.getColumnName(i) + ",");
			// }
			//
			// csv.write("\n");
			String str = null;
			for (int i = 0; i < cartList2.size(); i++) {
				str = (String) cartList2.get(i);
				csv.write(str);
				csv.write("\n");
			}

			csv.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		}

		return false;
	}

	public static boolean saveToCSV(JTable tableToExport, String pathToExportTo) {
		try {
			TableModel model = tableToExport.getModel();
			FileWriter csv = new FileWriter(new File(pathToExportTo));

			// for (int i = 0; i < model.getColumnCount(); i++) {
			// csv.write(model.getColumnName(i) + ",");
			// }
			//
			// csv.write("\n");
			for (int i = 0; i < model.getRowCount(); i++) {
				for (int j = 0; j < model.getColumnCount(); j++) {
					csv.write(model.getValueAt(i, j).toString() + ",");
				}
				csv.write("\n");
			}

			csv.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		}

		return false;
	}

	public static boolean saveToCSV2(JTable tableToExport, JComboBox combo, JComboBox combo2, String pathToExportTo) {
		try {
			TableModel model = tableToExport.getModel();
			FileWriter csv = new FileWriter(new File(pathToExportTo));

			// for (int i = 0; i < model.getColumnCount(); i++) {
			// csv.write(model.getColumnName(i) + ",");
			// }
			//
			// csv.write("\n");
			for (int i = 0; i < model.getRowCount(); i++) {
				for (int j = 0; j < model.getColumnCount(); j++) {
					csv.write(model.getValueAt(i, j).toString() + ",");

				}
				csv.write(combo.getSelectedItem().toString() + ",");
				csv.write(combo2.getSelectedItem().toString());
				csv.write("\n");
			}

			csv.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		}

		return false;
	}

	// public static void write() throws FileNotFoundException {
	// orderDAO.insert(orderVO, cartList);
	// System.out.println("결제페이지에 넘길 리스트 : " + cartList);
	// System.out.println("cartList는 결제 완료 후에 초기화 필요");
	// }
	public Object[][] convert2Data() {
		Object[][] data = new Object[cartList.size()][3];
		for (int i = 0; i < cartList.size(); i++) {
			data[i][0] = cartList.get(i).getItem();
			data[i][1] = cartList.get(i).getMethod();
			data[i][2] = cartList.get(i).getPrice();
		}
		return data;
	}

	public static String totalprice(JTable table) {
		int sum = 0;
		for (int i = 0; i < table.getRowCount(); i++) {
			sum = sum + Integer.parseInt((String) table.getValueAt(i, 2));
		}
		return Integer.toString(sum);
	}

	public static String tableValues(JTable table) {
		String values = "";
		for (int i = 0; i < table.getRowCount(); i++) {
			for (int j = 0; j < table.getColumnCount(); j++) {
				values = values + ((String) table.getValueAt(i, j)) + "/";
			}
			values = values + "-";
		}
		return values;
	}

}