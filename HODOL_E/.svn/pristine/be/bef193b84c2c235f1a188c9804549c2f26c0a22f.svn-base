package com.sist.hd.viw;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.HashMap;

import com.sist.hd.ctrl.UserCtrl;
import com.sist.hd.viw.MainFrame;
import com.sist.hd.vo.UserVO;
import java.awt.Color;
import java.awt.Font;

@SuppressWarnings("serial")
public class SignUpView extends JPanel implements ActionListener {

	private MainFrame win;
	public static HashMap<String, UserVO> map = new HashMap<String, UserVO>();
	public static String filepath = "src\\csv\\user.csv";

	private JLabel Signup_label;
	private JLabel name_label;
	private JLabel id_label;
	private JLabel pw_label;
	private JLabel pwCheck_label;
	private JLabel birth_label;
	private JLabel address_label;
	private JLabel tel_label;
	private JTextField id_textField;
	private JTextField  pw_textField;
	private JTextField pwCheck_textField;
	private JTextField birth_textField;
	private JTextField address_textField;
	private JTextField tel_textField;
	private JButton idCheckBtn;
	private JButton btnSubmit;
	private JTextField name_textField;
	private boolean idCheck;

	public SignUpView(){
		}
	
	public SignUpView(MainFrame win) {
		setBackground(Color.WHITE);
		setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 13));
		this.win = win;
		setLayout(null);
		idCheck = true;
		setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 13));
		
		Signup_label = new JLabel("회원가입");
		Signup_label.setBounds(193, 38, 57, 15);
		add(Signup_label);

		name_label = new JLabel("이름");
		name_label.setBounds(44, 89, 57, 15);
		add(name_label);

		id_label = new JLabel("아이디");
		id_label.setBounds(44, 160, 57, 15);
		add(id_label);

		pw_label = new JLabel("비밀번호");
		pw_label.setBounds(44, 239, 57, 15);
		add(pw_label);

		pwCheck_label = new JLabel("비밀번호확인");
		pwCheck_label.setBounds(44, 316, 111, 15);
		add(pwCheck_label);

		birth_label = new JLabel("생년월일");
		birth_label.setBounds(44, 394, 57, 15);
		add(birth_label);

		address_label = new JLabel("주소");
		address_label.setBounds(44, 447, 57, 15);
		add(address_label);

		tel_label = new JLabel("전화번호");
		tel_label.setBounds(44, 491, 57, 15);
		add(tel_label);

		name_textField = new JTextField();
		name_textField.setColumns(10);
		name_textField.setBounds(167, 86, 116, 21);
		add(name_textField);

		id_textField = new JTextField();
		id_textField.setBounds(167, 157, 116, 21);
		add(id_textField);
		id_textField.setColumns(10);

		pw_textField = new JPasswordField();
		pw_textField.setBounds(167, 236, 116, 21);
		add(pw_textField);
		pw_textField.setColumns(10);

		pwCheck_textField = new JTextField();
		pwCheck_textField.setBounds(167, 313, 116, 21);
		add(pwCheck_textField);

		birth_textField = new JTextField();
		birth_textField.setBounds(167, 391, 116, 21);
		add(birth_textField);
		birth_textField.setColumns(10);

		address_textField = new JTextField();
		address_textField.setBounds(167, 444, 116, 21);
		add(address_textField);
		address_textField.setColumns(10);

		tel_textField = new JTextField();
		tel_textField.setBounds(167, 488, 116, 21);
		add(tel_textField);
		tel_textField.setColumns(10);

		btnSubmit = new JButton("회원가입하기");
		btnSubmit.setBounds(308, 487, 130, 23);
		btnSubmit.setForeground(Color.WHITE);
		btnSubmit.setBackground(Color.DARK_GRAY);
		add(btnSubmit);
		
		idCheckBtn = new JButton("중복체크");
		idCheckBtn.setBounds(341, 156, 97, 23);
		idCheckBtn.setForeground(Color.WHITE);
		idCheckBtn.setBackground(Color.DARK_GRAY);
		add(idCheckBtn);
		
		//Event감지
		idCheckBtn.addActionListener(this);//ID Check
		btnSubmit.addActionListener(this);//회원가입
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == idCheckBtn){//ID Check
			if(id_textField.getText().trim().equals("")){
				id_textField.requestFocus();
				JOptionPane.showMessageDialog(win, "ID를 입력 하세요.","Message",JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			UserVO inVO=new UserVO();
			inVO.setId(id_textField.getText().trim());
			
			UserCtrl UserCtrl=new UserCtrl();
			int flag = UserCtrl.idCheck(inVO);
			
			if(flag == 1){
				id_textField.requestFocus();
				JOptionPane.showMessageDialog(win, "입력하신 ID는 사용중 입니다.\n다시입력해 주세요."
						,"Message",JOptionPane.INFORMATION_MESSAGE);
			}else{
				idCheck = true;//idCheck수행 함.
				JOptionPane.showMessageDialog(win, "사용가능한 ID입니다."
						,"Message",JOptionPane.INFORMATION_MESSAGE);
			}						
		
		}else if(e.getSource()==btnSubmit){//회원가입 
			if(idCheck==false){//ID중복 체크 수행 여부 확인
				JOptionPane.showMessageDialog(this, "ID중복 체크를 해주세요."
						,"Message",JOptionPane.INFORMATION_MESSAGE);
				
				return;
			}
			
			if(id_textField.getText().trim().equals("")){
				id_textField.requestFocus();
				JOptionPane.showMessageDialog(this, "ID를 입력 하세요.","Message",JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			
			if(pw_textField.getText().trim().equals("")){
				pw_textField.requestFocus();
				JOptionPane.showMessageDialog(this, "비번을 입력 하세요.","Message",JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			
			UserVO inVO=new UserVO();
			inVO.setName(name_textField.getText().trim());
			inVO.setId(id_textField.getText().trim());
			inVO.setPassword(pw_textField.getText().trim());
			inVO.setBirth(birth_textField.getText().trim());
			inVO.setAddress(address_textField.getText().trim());
			inVO.setTel(tel_textField.getText().trim());
					
			UserCtrl userCtrl=new UserCtrl();			
			int flag = userCtrl.do_save(inVO);
			
			if(flag==1){//회원가입 성공
				JOptionPane.showMessageDialog(this, "회원가입 성공.","Message",JOptionPane.INFORMATION_MESSAGE);					
				win.change("login");
				
			}else{//회원가입 실패 
				JOptionPane.showMessageDialog(this, "회원가입 실패.","Message",JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
}