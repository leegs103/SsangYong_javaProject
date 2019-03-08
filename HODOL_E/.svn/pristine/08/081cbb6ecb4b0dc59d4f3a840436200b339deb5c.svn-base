/**
 * @Class Name : MypageDAO.java
 * @Description : 
 * @Modification Information
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2019-02-25           최초생성
 *
 * @author 개발프레임웍크 실행환경 개발팀
 * @since 2019-02-25 
 * @version 1.0
 * @see
 *
 *  Copyright (C) by H.R. KIM All right reserved.
 */
package com.sist.hd.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.sist.hd.viw.MainFrame;
import com.sist.hd.vo.DTO;
import com.sist.hd.vo.PayVO;
import com.sist.hd.vo.UserVO;

/**
 * @author SIST 111
 *
 */
public class MypageDAO {
	private String filePath_user = "src\\csv\\user.csv";
	private String filePath_pay = "src\\csv\\payList.csv";
	//public List<UserVO> list = new ArrayList<>();
	public HashMap<String, UserVO> map = new HashMap();
	public List<PayVO> list = new ArrayList<>();
	
	/**
	 * 내 비밀번호를 수정
	 */
	public DTO do_selectOne(DTO dto) {
		UserVO inVO = (UserVO)dto;
		UserVO outVO = new UserVO();
		
		outVO = MainFrame.session;
		return outVO;
		
	}

	/**
	 * 
	 * @Method Name  : do_create
	 * @작성일   : 2019. 2. 27.
	 * @작성자   : SIST 111
	 * @변경이력  : 0.5
	 * @Method 설명 : 내 현재 비밀번호를 바꿔준다
	 * @param password
	 */
	public void do_create(String password, String address) {
		MainFrame.session.setPassword(password);
		MainFrame.session.setAddress(address);
	}

	/**
	 * user.csv 파일에 새롭게 저장
	 * @throws IOException 
	 */
	public void do_update(){
		BufferedWriter bw;
		try {
			bw = new BufferedWriter(new FileWriter(filePath_user,true));
			StringBuilder sb = new StringBuilder();
			sb.append(MainFrame.session.getName());
			sb.append(",");
			sb.append(MainFrame.session.getId());
			sb.append(",");
			sb.append(MainFrame.session.getPassword());
			sb.append(",");
			sb.append(MainFrame.session.getBirth());
			sb.append(",");
			sb.append(MainFrame.session.getAddress());
			sb.append(",");
			sb.append(MainFrame.session.getTel());
			
			bw.write(sb.toString());
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}//do_update

	/**
	 * 기존 csv 파일에 내 정보를 지움
	 * @throws FileNotFoundException 
	 */
	public void do_delete() {
		File file = new File(filePath_user);
		String dummy = "";
		
		BufferedReader br;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			String line = "";
			
			line = br.readLine();
			//1. 삭제하고자 하는 position 이전까지는 이동하며 dummy에 저장
			while(!(line.contains(","+MainFrame.session.getId()+","))) {
				dummy += (line + "\r\n" );
				line = br.readLine(); //읽으며 이동
			    //dummy += (line + "\r\n" );
			}//while
			
			//2. 삭제하고자 하는 데이터는 건너뛰기
			if(line.contains(","+MainFrame.session.getId()+",")){
			String delData = br.readLine();
			}

			//3. 삭제하고자 하는 position 이후부터 dummy에 저장
			while((line = br.readLine())!=null) {
				dummy += (line + "\r\n" ); 
			}

			//4. FileWriter를 이용해서 덮어쓰기
			FileWriter fw = new FileWriter(filePath_user);
			fw.write(dummy);
			
			fw.close();
			br.close();
		}  catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
			}
		
	}//do_delete
	
}
