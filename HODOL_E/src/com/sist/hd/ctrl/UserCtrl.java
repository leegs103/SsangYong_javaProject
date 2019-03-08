package com.sist.hd.ctrl;

import com.sist.hd.vo.DTO;
import com.sist.hd.vo.UserVO;
import com.sist.hd.dao.UserDAO;

public class UserCtrl {

	public int idCheck(DTO dto) {
		UserVO inVO = (UserVO) dto;
		UserDAO dao = new UserDAO();
		return dao.idCheck(inVO);
	}

	public DTO do_selectOne(DTO dto) {
		// 화면인자 : id/password
		UserVO inVO = (UserVO) dto;
		UserDAO dao = new UserDAO();

		return dao.do_selectOne(inVO);
	}

	public int do_save(DTO dto) {
		UserVO inVO = (UserVO) dto;
		UserDAO dao = new UserDAO();
		return dao.do_save(inVO);
	}
}