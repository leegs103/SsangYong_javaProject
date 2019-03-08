package com.sist.hd.ctrl;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.sist.hd.dao.OrderDAO;
import com.sist.hd.viw.StoreListView;
import com.sist.hd.vo.DTO;
import com.sist.hd.vo.OrderVO;

public class OrderCtrl {
   private static String key; // StoreList에서 넘겨받은 세탁소
   public static OrderVO orderVO = new OrderVO(); // OrderVO 객체 생성

   
   // store.csv파일을 읽어서 해당하는 세탁소를 탐색, storeData배열에 담아 OrderView로 넘김
   public static void read(String path) throws FileNotFoundException {
      Scanner scan = new Scanner(new File(path)); // 세탁소 리스트 파일 스캔

      key = orderVO.getStoreKey();
      while (scan.hasNextLine()) {
         String line = scan.nextLine();// store_sample.csv 파일의 한 줄을 읽어옴
         String[] data = line.split(",");// csv 파일 찢어서 String 배열에 저장

         if (key.equals(data[1])) {// 원하는 세탁소의 전화번호와 키 값이 일치할 경우
            // 해당 데이터를 orderVO에 넣어줍니다
            OrderDAO.orderDAO.select(orderVO, data);
            break;// 원하는 세탁소를 찾았으니 while문 빠져나옴
         } // if
      } // while
   }

   // 주문목록 리스트 생성
   public static void addOrderList(String item, String selectItem) {	  
      OrderDAO.addList(OrderDAO.toString(item, selectItem, OrderDAO.getPrice(item, selectItem)));
   }

   // 장바구니에 넘길 주문목록 생성
   public static void write() throws FileNotFoundException {
      OrderDAO.create();
   }

   public static void main(String[] args) throws FileNotFoundException {
   }
}