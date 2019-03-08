package com.sist.hd.ctrl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.sist.hd.dao.MypageDAO;
import com.sist.hd.vo.PayVO;

public class MyPageCtrl {
	private String filePath = "src\\csv\\payList.csv";
	public static ArrayList<PayVO> payList = new ArrayList();
	public List<PayVO> list = new ArrayList<>();
	
	
	public void add(PayVO payStr) {
		payList.add(payStr);
	}

	/**
	 * 
	 * @Method Name  : do_update
	 * @작성일   : 2019. 2. 28.
	 * @작성자   : SIST 111
	 * @변경이력  : 0.5
	 * @Method 설명 : 비밀번호를 바꾸고 파일에도 적용시킴
	 * @param password
	 */
	public void do_update(String password, String address) {
		MypageDAO update = new MypageDAO();
		update.do_create(password, address);
		update.do_delete();
		update.do_update();
	}
	
	public int CSV_TO_List(String id) {
		// try catch finally
		FileReader reader = null;
		BufferedReader br = null;
		try {
			reader = new FileReader(filePath);
			br = new BufferedReader(reader);

			String line = "";
			while ((line = br.readLine()) != null) {
				if (line.indexOf(",") != -1) {
					String[] tmpData = line.split(",");
					if(tmpData[1].equals(id)) {
					PayVO vo = new PayVO(tmpData[0], tmpData[1], tmpData[2], tmpData[3], tmpData[4], tmpData[5], tmpData[6], tmpData[7]);
					payList.clear();
					list.add(vo);
					payList.addAll(list);
					}
				}
			} // while
		} catch (IOException e) {
			System.out.println("=IOException=");
			e.printStackTrace();

		} finally {
			try{
				br.close();
			} catch (IOException e) {
				System.out.println("=finally IOException=");
				e.printStackTrace();
			}
		}
		return list.size();
	}//readCSV_TO_List
	
	public Object[][] convertToData() {
		Object[][] data = new Object[payList.size()][4];
		for (int i = 0; i < payList.size(); i++) {
			String[] s = payList.get(i).getLaunList().split("/");
			
			data[i][0] = payList.get(i).getLaunName();
			data[i][1] = payList.get(i).getTotalPrice();
			data[i][2] = payList.get(i).getPickupTime();
			data[i][3] = payList.get(i).getDeliveryTime();
		}
		return data;
	}
	
}//class
	

