package com.sist.hd.viw;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextArea;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.sist.hd.ctrl.CartCtrl;
import com.sist.hd.ctrl.OrderCtrl;
import com.sist.hd.ctrl.PayCtrl;
import com.sist.hd.vo.PayVO;
import java.awt.Color;
import java.awt.Font;


@SuppressWarnings("serial")
public class PayView extends JPanel {	
	private MainFrame win;

	private JLabel PayInfo_label;
	private JLabel userAddress_label;
	private JLabel luanList_label;
	private JLabel pickTime_label;
	private JLabel deliveryTime_label;
	private JLabel totalPrice_label;
	
	private JTextArea userAddress_txtArea;	
	private JTextArea launList_txtArea;
	private JTextArea pickTime_txtArea;	
	private JTextArea deliveryTime_txtArea;	
	private JTextArea totalPrice_txtArea;
	
	private JButton submit_btn;
	private JButton btnHome;
	
	public PayView(){
		setBackground(Color.WHITE);}
	
	public PayView(MainFrame win) {
		this.win = win;
		setLayout(null);
		setBackground(Color.WHITE);
		setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 13));
		
		PayInfo_label = new JLabel(MainFrame.session.getName() +"님의 결제정보");
		PayInfo_label.setBounds(49, 30, 200, 20);
		PayInfo_label.setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 20));
		add(PayInfo_label);
		
		userAddress_label = new JLabel("주문자 주소지");
		userAddress_label.setBounds(49, 60, 112, 15);
		userAddress_label.setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 15));
		add(userAddress_label);
		
		
		userAddress_txtArea = new JTextArea();
		userAddress_txtArea.setText(MainFrame.session.getAddress());
		userAddress_txtArea.setBounds(49, 83, 303, 39);
		userAddress_txtArea.setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 13));
		add(userAddress_txtArea);
		
		luanList_label = new JLabel("세탁목록");
		luanList_label.setBounds(49, 137, 100, 15);
		luanList_label.setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 15));
		add(luanList_label);
		
		launList_txtArea = new JTextArea();
		launList_txtArea.add(CartView.table);
		launList_txtArea.setBounds(49, 162, 303, 99);
		add(launList_txtArea);
		
		pickTime_label = new JLabel("픽업시간");
		pickTime_label.setBounds(49, 271, 100, 15);
		pickTime_label.setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 15));
		add(pickTime_label);
		
		pickTime_txtArea = new JTextArea();
		pickTime_txtArea.setText(CartView.cartStr1);
		pickTime_txtArea.setBounds(49, 296, 303, 30);
		pickTime_txtArea.setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 13));
		add(pickTime_txtArea);
		
		deliveryTime_label = new JLabel("배달시간");
		deliveryTime_label.setBounds(49, 336, 100, 15);
		deliveryTime_label.setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 15));
		add(deliveryTime_label);
		
		deliveryTime_txtArea = new JTextArea();
		deliveryTime_txtArea.setText(CartView.cartStr2);
		deliveryTime_txtArea.setBounds(49, 361, 303, 30);
		deliveryTime_txtArea.setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 13));
		add(deliveryTime_txtArea);
		
		totalPrice_label = new JLabel("총 금액");
		totalPrice_label.setBounds(49, 401, 57, 15);
		totalPrice_label.setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 15));
		add(totalPrice_label);
		
		totalPrice_txtArea = new JTextArea();
		totalPrice_txtArea.setText(CartCtrl.totalprice(CartView.table));
		totalPrice_txtArea.setBounds(49, 426, 303, 30);
		totalPrice_txtArea.setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 13));
		add(totalPrice_txtArea);
		
		submit_btn = new JButton("완료");
		submit_btn.setBounds(299, 476, 97, 23);
		submit_btn.setForeground(Color.WHITE);
		submit_btn.setBackground(Color.DARK_GRAY);
		submit_btn.setBorderPainted(false);
		submit_btn.setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 13));
		add(submit_btn);
		
		submit_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				PayVO inVO=new PayVO();
				
				inVO.setLaunName(OrderCtrl.orderVO.getStoreName());
				inVO.setUserId(MainFrame.session.getId());
				inVO.setPayId(MainFrame.session.getId()+(int)(Math.random()*100));			
				inVO.setLaunList(CartCtrl.tableValues(CartView.table));
				inVO.setUserAddress(userAddress_txtArea.getText().trim());
				inVO.setTotalPrice(CartCtrl.totalprice(CartView.table));
				inVO.setPickupTime(pickTime_txtArea.getText().trim());
				inVO.setDeliveryTime(deliveryTime_txtArea.getText().trim());
				PayCtrl payCtrl=new PayCtrl();
				int flag = payCtrl.do_save(inVO);//inVO를 csv에 저장
				CartCtrl.cartList2.clear();
				
				if(flag==1){//결제 성공
					JOptionPane.showMessageDialog(win, "결제되었습니다.","Message",JOptionPane.INFORMATION_MESSAGE);					
					win.change("main");
					
				}else{//결제오류
					JOptionPane.showMessageDialog(win, "","결제 오류",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});

		JButton btnHome = new JButton("HOME");
		btnHome.setBounds(361, 0, 77, 30);
		btnHome.setForeground(Color.WHITE);
		btnHome.setBackground(Color.DARK_GRAY);
		btnHome.setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 13));
		add(btnHome);
		
		btnHome.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				win.change("main");
			}
		});
	}
}
