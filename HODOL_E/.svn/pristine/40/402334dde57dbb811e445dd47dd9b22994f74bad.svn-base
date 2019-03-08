package com.sist.hd.viw;

import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.sist.hd.ctrl.CartCtrl;
import com.sist.hd.ctrl.OrderCtrl;
import com.sist.hd.dao.OrderDAO;
import com.sist.hd.vo.OrderVO;
import java.awt.Color;

public class OrderView extends JPanel {
	private JLabel laundryName;
	// private JTextArea laundryData;
	private JLabel laundryAddress;
	private JLabel laundryTel;
	private JLabel labelSch; // school
	private JLabel labelSuit;
	private JLabel labelCoat;
	private JLabel labelEtc;
	private JComboBox comboBoxSch;
	private JComboBox comboBoxSuit;
	private JComboBox comboBoxCoat;
	private JComboBox comboBoxEtc;
	private JButton btnAddSch;
	private JButton btnAddSuit;
	private JButton btnAddCoat;
	private JButton btnAddEtc;
	private JButton btnCart;
	private MainFrame win;
	
	public static String filepath = "src\\csv\\storeList.csv";
	public static String orderStr;
	OrderCtrl ctrl = new OrderCtrl();

	public OrderView(MainFrame win) throws FileNotFoundException {
		setBackground(Color.WHITE);
		setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 13));
		this.win = win;
		setLayout(null);
		OrderCtrl.read(filepath);

		JLabel laundryName = new JLabel(OrderCtrl.orderVO.getStoreName());
		laundryName.setHorizontalAlignment(JLabel.CENTER);
		laundryName.setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 20));
		laundryName.setBounds(0, 30, 450, 40);
		add(laundryName);

		JLabel laundryAddress = new JLabel(OrderCtrl.orderVO.getStoreAddress(), SwingConstants.CENTER);
		laundryAddress.setHorizontalAlignment(JLabel.CENTER);
		laundryAddress.setVerticalAlignment(JLabel.CENTER);
		laundryAddress.setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 15));
		laundryAddress.setBounds(0, 70, 450, 40);
		add(laundryAddress);

		JLabel laundryTel = new JLabel(OrderCtrl.orderVO.getStoreTel(), SwingConstants.CENTER);
		laundryTel.setHorizontalAlignment(JLabel.CENTER);
		laundryTel.setVerticalAlignment(JLabel.CENTER);
		laundryTel.setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 15));
		laundryTel.setBounds(0, 90, 450, 40);
		add(laundryTel);

		JButton btnCart = new JButton("CART");
		btnCart.setForeground(Color.WHITE);
		btnCart.setBackground(Color.DARK_GRAY);
		btnCart.setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 13));
		btnCart.setBorderPainted(false);
		btnCart.setBounds(188, 443, 77, 30);
		add(btnCart);
		btnCart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (OrderDAO.orderList.size() == 0) {
					JOptionPane.showMessageDialog(win, "선택된 품목이 없습니다.", null, JOptionPane.WARNING_MESSAGE);
				} else {
					String str = "";
					for (int i = 0; i < OrderDAO.orderList.size(); i++) {
						str+= OrderDAO.orderList.get(i) + "\n";
					}
					JOptionPane.showMessageDialog(win, str);
				}
				for (int i = 0; i < OrderDAO.orderList.size(); i++) {
					CartCtrl.cartList2.add(OrderDAO.orderList.get(i));
				}
				OrderDAO.initialize(OrderDAO.orderList);

				CartCtrl.saveToCSV(CartCtrl.cartList2, "src\\csv\\cartList.csv");
				CartView cart = new CartView(win);
				win.change("cart", cart);
			}
		});

		JButton btnHome = new JButton("HOME");
		btnHome.setBackground(Color.DARK_GRAY);
		btnHome.setForeground(Color.WHITE);
		btnHome.setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 13));
		btnHome.setBorderPainted(false);
		btnHome.setBounds(361, 0, 77, 30);
		add(btnHome);

		JLabel labelSch = new JLabel("교복");
		labelSch.setBounds(58, 170, 60, 30);
		labelSch.setVerticalAlignment(JLabel.CENTER);
		add(labelSch);
		labelSch.setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 13));

		JComboBox comboBoxSch = new JComboBox();
		comboBoxSch.setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 13));
		comboBoxSch.setBounds(173, 170, 103, 30);
		add(comboBoxSch);
		comboBoxSch.setModel(new DefaultComboBoxModel(new String[] { "일반세탁", "드라이클리닝", "특수세탁" }));

		JButton btnAddSch = new JButton("담기");
		btnAddSch.setForeground(Color.WHITE);
		btnAddSch.setBackground(Color.DARK_GRAY);
		btnAddSch.setBounds(338, 170, 60, 30);
		add(btnAddSch);
		btnAddSch.setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 13));
		btnAddSch.setBorderPainted(false);

		JLabel labelSuit = new JLabel("정장");
		labelSuit.setBounds(58, 240, 60, 30);
		labelSuit.setVerticalAlignment(JLabel.CENTER);
		add(labelSuit);
		labelSuit.setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 13));

		JComboBox comboBoxSuit = new JComboBox();
		comboBoxSuit.setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 13));
		comboBoxSuit.setBounds(173, 240, 103, 30);
		add(comboBoxSuit);
		comboBoxSuit.setModel(new DefaultComboBoxModel(new String[] { "일반세탁", "드라이클리닝", "특수세탁" }));

		JButton btnAddSuit = new JButton("담기");
		btnAddSuit.setForeground(Color.WHITE);
		btnAddSuit.setBackground(Color.DARK_GRAY);
		btnAddSuit.setBounds(338, 240, 60, 30);
		add(btnAddSuit);
		btnAddSuit.setBorderPainted(false);
		btnAddSuit.setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 13));

		JLabel labelCoat = new JLabel("코트");
		labelCoat.setBounds(58, 310, 60, 30);
		labelCoat.setVerticalAlignment(JLabel.CENTER);
		add(labelCoat);
		labelCoat.setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 13));

		JComboBox comboBoxCoat = new JComboBox();
		comboBoxCoat.setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 13));
		comboBoxCoat.setBounds(173, 310, 103, 30);
		add(comboBoxCoat);
		comboBoxCoat.setModel(new DefaultComboBoxModel(new String[] { "일반세탁", "드라이클리닝", "특수세탁" }));

		JButton btnAddCoat = new JButton("담기");
		btnAddCoat.setForeground(Color.WHITE);
		btnAddCoat.setBackground(Color.DARK_GRAY);
		btnAddCoat.setBounds(338, 310, 60, 30);
		btnAddCoat.setBorderPainted(false);
		add(btnAddCoat);
		btnAddCoat.setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 13));

		JLabel labelEtc = new JLabel("특수제작");
		labelEtc.setBounds(58, 380, 60, 30);
		labelEtc.setVerticalAlignment(JLabel.CENTER);
		add(labelEtc);
		labelEtc.setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 13));

		JComboBox comboBoxEtc = new JComboBox();
		comboBoxEtc.setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 13));
		comboBoxEtc.setBounds(173, 380, 103, 30);
		add(comboBoxEtc);
		comboBoxEtc.setModel(new DefaultComboBoxModel(new String[] { "일반세탁", "드라이클리닝", "특수세탁" }));

		JButton btnAddEtc = new JButton("담기");
		btnAddEtc.setForeground(Color.WHITE);
		btnAddEtc.setBackground(Color.DARK_GRAY);
		btnAddEtc.setBounds(338, 380, 60, 30);
		btnAddEtc.setBorderPainted(false);
		add(btnAddEtc);
		btnAddEtc.setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 13));

		btnAddSch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				OrderCtrl.addOrderList(labelSch.getText(), comboBoxSch.getSelectedItem().toString());
			}
		});
		btnAddSuit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				OrderCtrl.addOrderList(labelSuit.getText(), comboBoxSuit.getSelectedItem().toString());
			}
		});
		btnAddCoat.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				OrderCtrl.addOrderList(labelCoat.getText(), comboBoxCoat.getSelectedItem().toString());
			}
		});
		btnAddEtc.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				OrderCtrl.addOrderList(labelEtc.getText(), comboBoxEtc.getSelectedItem().toString());
			}
		});

		btnCart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					OrderCtrl.write();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnHome.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				win.change("main");
			}
		});

	}
}
