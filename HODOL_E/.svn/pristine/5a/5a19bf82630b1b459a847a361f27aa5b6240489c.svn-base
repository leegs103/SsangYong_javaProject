package com.sist.hd.viw;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class MainView extends JPanel {
	private MainFrame win;
	/**
	 * Create the panel.
	 * @param win 
	 */
	public MainView(MainFrame win) {
		setBackground(Color.WHITE);
		this.win = win;
		setLayout(null);
		JButton msCloth = new JButton("세탁");
		msCloth.setBackground(Color.DARK_GRAY);
		msCloth.setForeground(Color.WHITE);
		msCloth.setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 20));
		msCloth.setBorderPainted(false);
		msCloth.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				win.change("storeList");
			}
		});

		msCloth.setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 30));
		msCloth.setBounds(97, 164, 255, 206);
		add(msCloth);
		
		JButton msMyPage = new JButton("마이페이지");
		msMyPage.setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 13));
		msMyPage.setBackground(Color.DARK_GRAY);
		msMyPage.setForeground(Color.WHITE);
		msMyPage.setBorderPainted(false);
		msMyPage.setBounds(0, 0, 106, 30);
		add(msMyPage);
		msMyPage.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MypageView mypage = new MypageView(win);
				win.change("mypage", mypage);
			}
		});

	}

}
