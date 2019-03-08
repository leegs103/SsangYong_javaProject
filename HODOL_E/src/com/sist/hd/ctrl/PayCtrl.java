package com.sist.hd.ctrl;

import com.sist.hd.dao.PayDAO;
import com.sist.hd.vo.DTO;
import com.sist.hd.vo.PayVO;


//결제 완료 버튼 액션에서 orderList 초기화 해주세요

public class PayCtrl {
	
	public PayCtrl() {}

	public int do_save(DTO dto) {
		PayVO inVO = (PayVO) dto;
		PayDAO dao = new PayDAO();
		return dao.do_save(inVO);
	}
	
	
}
