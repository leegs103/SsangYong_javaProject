package com.sist.hd.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.sist.hd.ctrl.OrderCtrl;
import com.sist.hd.vo.OrderVO;

public class OrderDAO {
	public static String filepath1 = "src\\csv\\storeList.csv";
	public static String filepath2 = "src\\csv\\cartlist.csv";
	public static String[] data;
	public static List orderList = new ArrayList(); // 결제 완료 후에 초기화 필요
	public static OrderDAO orderDAO = new OrderDAO();

	// cartList의 값을 읽어와 orderList에 저장(계속 담기)
	public static void initList(List orderList) throws FileNotFoundException {
		
		Scanner scan = new Scanner(new File(filepath2));
		String str;
		while (scan.hasNextLine()) {
			str = null;
			String line = scan.nextLine();
			String[] data = line.split(",");
			
			str = toString(data[0], data[1], Integer.parseInt(data[2]));
			orderList.add(str);
			break;
		} //while
		save(OrderCtrl.orderVO, orderList);
	} 

	// cartList의 값을 읽어와 orderList에 저장(삭제)
	public static void initList(List orderList, String path) throws FileNotFoundException {
		initialize(orderList);
		Scanner scan = new Scanner(new File(path));
		String str;
		while (scan.hasNextLine()) {
			str = null;
			String line = scan.nextLine();
			String[] data = line.split(",");
			
			str = toString(data[0], data[1], Integer.parseInt(data[2]));
			orderList.add(str);
			break;
		} //while
		save(OrderCtrl.orderVO, orderList);
	}
	
	// 넘겨받은 key값으로 세탁소 탐색
	public void select(OrderVO orderVO, String[] data) {
		orderVO.setStoreName(data[0]);
		orderVO.setStoreTel(data[1]);
		orderVO.setStoreAddress(data[2]);
	}

	// orderList를 csv파일에 저장
	public static void save(OrderVO orderVO, List orderList) throws FileNotFoundException {
		PrintWriter pw = new PrintWriter(filepath2);
		for (int i = 0; i < orderList.size(); i++) {
			String data = (String) orderList.get(i);
			pw.println(data);
		}
		pw.close();
	}

	// 가격 책정 메서드
	public static int getPrice(String item, String selectItem) {
		int price = 0;
		if (item.equals("교복")) {
			price = 1000;
		} else if (item.equals("정장")) {
			price = 2000;
		} else if (item.equals("코트")) {
			price = 3000;
		} else {
			price = 4000;
		}
		if (selectItem.equals("일반세탁")) {
			price += 300;
		} else if (selectItem.equals("드라이클리닝")) {
			price += 500;
		} else {
			price += 700;
		}
		return price;
	}

	// 주문리스트에 추가할 문자열 생성
	public static String toString(String item, String selectItem, int price) {
		String orderStr;
		orderStr = item.toString() + "," + selectItem.toString() + "," + price;
		return orderStr;
	}

	// 추가된 주문을 주문리스트에 추가
	public static void addList(String order) {
		orderList.add(order);
	}

	// 장바구니에 넘길 주문목록 생성
	public static void create() throws FileNotFoundException {
		save(OrderCtrl.orderVO, OrderDAO.orderList);
		
	}

	// orderList초기화(결제 완료 후)
	public static void initialize(List orderList) {
		orderList.clear();
		
	}
}