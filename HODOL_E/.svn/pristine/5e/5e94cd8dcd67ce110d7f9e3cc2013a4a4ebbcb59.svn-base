package com.sist.hd.viw;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.sist.hd.ctrl.OrderCtrl;
import com.sist.hd.ctrl.StoreListCtrl;
import java.awt.Color;

public class StoreListView extends JPanel {

	private MainFrame win;
	public static String value;

	public StoreListView(MainFrame win) {
		setBackground(Color.WHITE);
		setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 13));
		this.win = win;
		setLayout(null);

		JList list = new JList();
		list.setBounds(225, 5, 0, 0);
		add(list);

		JButton btnNewButton = new JButton("선택");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 13));
		btnNewButton.setBounds(174, 420, 78, 35);
		add(btnNewButton);

		ArrayList dataArr = new ArrayList();
		StoreListCtrl sl = new StoreListCtrl();

		try {
			dataArr = sl.read("src\\csv\\storeList.csv");
			Object[][] data = new Object[dataArr.size()][3];

			for (int i = 0; i < dataArr.size(); i++) {
				String[] line = dataArr.get(i).toString().split(",");
				for (int j = 0; j < line.length; j++) {
					data[i][j] = line[j];

				}
			} // for

			String header[] = { "세탁소이름", "전화번호", "주소" };// 배열 생성
			JTable table = new JTable(data, header);// 클래스 객체 생성
			table.setBounds(15, 60, 410, 400);
			table.setFont(new Font("나눔고딕", Font.PLAIN, 13));
			JScrollPane jscrollpane = new JScrollPane(table);

			add(table);
			this.add(jscrollpane);

			this.setVisible(true);

			btnNewButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					int row = table.getSelectedRow();
					int col = table.getSelectedColumn();
					
					if(row==-1){
						JOptionPane.showMessageDialog(win, "세탁소를 선택하세요.", null,JOptionPane.ERROR_MESSAGE);
					}else{
						value = (String) table.getValueAt(row, 1);
						OrderView order = null;
						OrderCtrl.orderVO.setStoreKey(value);
						try {
						order = new OrderView(win);
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					}
						
						win.change("order", order);
					}

				}
			});

		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
	}
}// class