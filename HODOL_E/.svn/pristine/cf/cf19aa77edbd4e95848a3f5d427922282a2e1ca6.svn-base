package com.sist.hd.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import com.sist.hd.vo.DTO;
import com.sist.hd.vo.PayVO;

public class PayDAO {
	private String filePath_pay = "src\\csv\\payList.csv";
	public List<PayVO> list = new ArrayList<PayVO>();
	public HashMap<String, PayVO> map2 = new HashMap<String, PayVO>();

	public PayDAO(){		
		readCSV_TO_Map();
	}
	
	public int do_save(DTO dto) {
		PayVO inVO = (PayVO) dto;
		int flag = -1;
		if (!map2.containsKey(inVO.getPayId())) {
			map2.put(inVO.getPayId(), inVO);
			int saveFlag = writeMapToFile(map2);
			if (saveFlag > 0)
				flag = 1;
		}
		return flag;
	}
	
	public int writeMapToFile(HashMap<String, PayVO> inMap) {
		FileWriter writer = null;
		BufferedWriter bw = null;
		
		int writeCnt = 0;
		
		try {
			writer = new FileWriter(filePath_pay);
			bw = new BufferedWriter(writer);
			Set set = inMap.entrySet();
			Iterator it = set.iterator();

			while (it.hasNext()) {
				Map.Entry e = (Entry) it.next();
				PayVO tmpVO = (PayVO) e.getValue();
				StringBuilder br = new StringBuilder();
				String divStr = ",";
				br.append(tmpVO.getLaunName());
				br.append(divStr);
				br.append(tmpVO.getUserId());
				br.append(divStr);
				br.append(tmpVO.getPayId());
				br.append(divStr);
				br.append(tmpVO.getLaunList());
				br.append(divStr);
				br.append(tmpVO.getUserAddress());
				br.append(divStr);
				br.append(tmpVO.getTotalPrice());
				br.append(divStr);
				br.append(tmpVO.getPickupTime());
				br.append(divStr);
				br.append(tmpVO.getDeliveryTime());

				bw.write(br.toString());
				bw.newLine();
				writeCnt++;
				bw.flush();// Buffer비우기
			} // while

		} catch (IOException e) {
			System.out.println("=IOException=");
			e.printStackTrace();

		} finally {
			if (null != bw) {
				try {
					bw.close();
				} catch (IOException e) {
					System.out.println("=finally IOException=");
					e.printStackTrace();
				}
			}
		}
		return writeCnt;
	}// writeMapTOFile
	
	
	public int readCSV_TO_Map() {
		try (FileReader reader = new FileReader(filePath_pay);
			BufferedReader br = new BufferedReader(reader);) {
			String line = "";
			while ((line = br.readLine()) != null) {
				if(! line.equals("") && !(line.indexOf(",")>-1))continue;
				String[] tmpData = line.split(",");
				if(null== tmpData || tmpData.length !=8)continue;
				PayVO vo = new PayVO(tmpData[0], tmpData[1], tmpData[2], tmpData[3], tmpData[4], tmpData[5],tmpData[6], tmpData[7]);
				map2.put(vo.getPayId(), vo); // vo의 key값은 ID, value값은 vo로 선언
			} // while

		} catch (IOException e) {
			System.out.println("=IOException=");
			e.printStackTrace();
		}
		return map2.size();
	}
}