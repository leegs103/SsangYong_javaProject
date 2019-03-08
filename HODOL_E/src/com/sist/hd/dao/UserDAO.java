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
import java.util.Map.Entry;
import java.util.Set;

import com.sist.hd.vo.UserVO;
import com.sist.hd.vo.DTO;
import com.sist.hd.vo.UserVO;

public class UserDAO {
	private String filePath = "src\\csv\\user.csv";
	public List<UserVO> list = new ArrayList<UserVO>();
	public HashMap<String, UserVO> map = new HashMap<String, UserVO>();

	public UserDAO() {
		readCSV_TO_Map();
	}

	public int idCheck(DTO dto) {
		UserVO inVO = (UserVO) dto;
		int flag = -1;
		if (map.containsKey(inVO.getId()) == true) {
			flag = 1;
		}
		return flag;
	}

	public int passCheck(DTO dto) {
		UserVO inVO = (UserVO) dto;
		int flag = -2;

		UserVO tmpVO = map.get(inVO.getId());
		if (idCheck(tmpVO) > 0) {
			if (tmpVO.getPassword().equals(inVO.getPassword()))
				flag = 1;
		}
		return flag; //msgID = flag;
	}

	public DTO do_selectOne(DTO dto) {
		UserVO inVO = (UserVO) dto; //입력
		UserVO outVO = new UserVO(); //출력

		if (idCheck(dto) != 1) {
			outVO.setId("-1");
			return outVO;
		}

		// 비밀번호 오류
		if (passCheck(inVO) != 1) {
			outVO.setId("-2");
			return outVO;
		}
		
		// 로그인 성공, msg = 1
		outVO = map.get(inVO.getId()); //outVO는 inVO의 id값을 키값으로 하여 출력한 값
		outVO.setMsgId("1");
		return outVO;

	}

	public int do_save(DTO dto) {
		UserVO inVO = (UserVO) dto;
		int flag = -1;
		if (!map.containsKey(inVO.getId())) {
			UserVO tmpVO = map.put(inVO.getId(), inVO);
			int saveFlag = writeMapToFile(map);
			if (saveFlag > 0)
				flag = 1;
		}
		return flag;

	}

	public int writeMapToFile(HashMap<String, UserVO> inMap) {
		FileWriter writer = null;
		BufferedWriter bw = null;
		int writeCnt = 0;
		try {
			writer = new FileWriter(filePath);
			bw = new BufferedWriter(writer);

			Set set = inMap.entrySet();
			Iterator it = set.iterator();

			while (it.hasNext()) {
				Map.Entry e = (Entry) it.next();
				UserVO tmpVO = (UserVO) e.getValue();
				StringBuilder br = new StringBuilder();
				String divStr = ",";

				br.append(tmpVO.getName());
				br.append(divStr);
				br.append(tmpVO.getId());
				br.append(divStr);
				br.append(tmpVO.getPassword());
				br.append(divStr);
				br.append(tmpVO.getBirth());
				br.append(divStr);
				br.append(tmpVO.getAddress());
				br.append(divStr);
				br.append(tmpVO.getTel());
				//컴마를 구분자로 Stringbuilder에  UserVO요소를 저장함
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

		// try with resource
		try (FileReader reader = new FileReader(filePath);
			BufferedReader br = new BufferedReader(reader);) {
			String line = "";
			while ((line = br.readLine()) != null) {
				String[] tmpData = line.split(",");
				UserVO vo = new UserVO(tmpData[0], tmpData[1], tmpData[2], tmpData[3], tmpData[4], tmpData[5]);
				map.put(vo.getId(), vo); // vo의 key값은 ID, value값은 vo로 선언
			} // while

		} catch (IOException e) {
			System.out.println("=IOException=");
			e.printStackTrace();
		}
		return map.size();
	}
}