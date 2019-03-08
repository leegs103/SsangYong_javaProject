package com.sist.hd.viw;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import com.sist.hd.ctrl.MyPageCtrl;
import com.sist.hd.vo.UserVO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.Font;

public class MypageEditView extends JPanel {
	private JTextField pwChange_textField;
	private JTextField adrChange_textField;
	private MainFrame win;
	private JTextField pwCheckTextField;

	/**
	 * Create the panel.
	 * 
	 * @param win2
	 */
	public MypageEditView(MainFrame win) {
		setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 13));
		setBackground(Color.WHITE);
		this.win = win;
		setLayout(null);

		JLabel mypage_label = new JLabel("마이페이지");
		mypage_label.setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 20));
		mypage_label.setBounds(164, 71, 100, 23);
		add(mypage_label);

		JLabel pwLabel = new JLabel("비밀번호 변경");
		pwLabel.setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 13));
		pwLabel.setBounds(111, 119, 84, 15);
		add(pwLabel);

		pwChange_textField = new JTextField();
		pwChange_textField.setBounds(121, 144, 187, 21);
		add(pwChange_textField);
		pwChange_textField.setColumns(10);

		JLabel adrChange_label = new JLabel("주소지 변경");
		adrChange_label.setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 13));
		adrChange_label.setBounds(111, 247, 84, 15);
		add(adrChange_label);

		adrChange_textField = new JTextField();
		adrChange_textField.setColumns(10);
		adrChange_textField.setBounds(121, 272, 187, 21);
		add(adrChange_textField);

		JButton complete = new JButton("확인");
		complete.setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 13));
		complete.setForeground(Color.WHITE);
		complete.setBackground(Color.DARK_GRAY);
		complete.setBorderPainted(false);
		complete.setBounds(276, 338, 71, 23);
		add(complete);

		JLabel pwCheckLabel = new JLabel("비밀번호 확인");
		pwCheckLabel.setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 13));
		pwCheckLabel.setBounds(111, 182, 84, 15);
		add(pwCheckLabel);

		pwCheckTextField = new JTextField();
		pwCheckTextField.setBounds(121, 207, 187, 21);
		add(pwCheckTextField);
		pwCheckTextField.setColumns(10);

		complete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (pwChange_textField.getText().equals(pwCheckTextField.getText())) {
					UserVO inVO = new UserVO();
					if (pwChange_textField.getText().trim().equals("")) {
						pwChange_textField.setText(MainFrame.session.getPassword());
					}
					if (adrChange_textField.getText().trim().equals("")) {
						adrChange_textField.setText(MainFrame.session.getAddress());
					}
					inVO.setPassword(pwChange_textField.getText().trim());
					inVO.setAddress(adrChange_textField.getText().trim());
					MyPageCtrl m = new MyPageCtrl();
					m.do_update(inVO.getPassword(), inVO.getAddress());
					MypageView mypageView = new MypageView(win);
					win.change("mypage", mypageView);
					pwChange_textField.setText(null);
					adrChange_textField.setText(null);
					pwCheckTextField.setText(null);
				} else {
					pwCheckTextField.requestFocus();
					JOptionPane.showMessageDialog(null, "비밀번호가 서로 일치하지 않습니다 다시 입력해주세요.", "Message",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});

	}
}
