package com.sist.hd.viw;

import java.awt.Container;
import java.io.FileNotFoundException;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import com.sist.hd.vo.UserVO;

public class MainFrame extends JFrame {
	public CartView cart = null;
	public LoginView login = null;
	public MainView main = null;
	public MypageEditView mypageEdit = null;
	public MypageView mypage = null;
	//public OrderView order = null;
	public PayView pay = null;
	public SignUpView signUp = null;
	public StoreListView storeList = null;
	public static MainFrame win = new MainFrame();
	
	public static UserVO session  = null;

	public void change(String panelName) {
		switch (panelName) {
		case "cart":
			getContentPane().removeAll();
			getContentPane().add(cart);
			revalidate();
			repaint();
			break;

		case "login":
			getContentPane().removeAll();
			getContentPane().add(login);
			revalidate();
			repaint();
			break;

		case "main":
			getContentPane().removeAll();
			getContentPane().add(main);
			revalidate();
			repaint();
			break;

		case "mypageEdit":
			getContentPane().removeAll();
			getContentPane().add(mypageEdit);
			revalidate();
			repaint();
			break;

		case "mypage":
			getContentPane().removeAll();
			getContentPane().add(mypage);
			revalidate();
			repaint();
			break;

		case "order":
			getContentPane().removeAll();
			//getContentPane().add(order);
			revalidate();
			repaint();
			break;

		case "pay":
			getContentPane().removeAll();
			getContentPane().add(pay);
			revalidate();
			repaint();
			break;

		case "signUp":
			getContentPane().removeAll();
			getContentPane().add(signUp);
			revalidate();
			repaint();
			break;

		case "storeList":
			getContentPane().removeAll();
			getContentPane().add(storeList);
			revalidate();
			repaint();
			break;
		}
	}
	public void change(String panelName,Container con) {
		switch (panelName) {
		case "cart":
			getContentPane().removeAll();
			getContentPane().add(con);
			revalidate();
			repaint();
			break;

		case "login":
			getContentPane().removeAll();
			getContentPane().add(con);
			revalidate();
			repaint();
			break;

		case "main":
			getContentPane().removeAll();
			getContentPane().add(con);
			revalidate();
			repaint();
			break;

		case "mypageEdit":
			getContentPane().removeAll();
			getContentPane().add(con);
			revalidate();
			repaint();
			break;

		case "mypage":
			getContentPane().removeAll();
			getContentPane().add(con);
			revalidate();
			repaint();
			break;

		case "order":
			getContentPane().removeAll();
			getContentPane().add(con);
			revalidate();
			repaint();
			break;

		case "pay":
			getContentPane().removeAll();
			getContentPane().add(con);
			revalidate();
			repaint();
			break;

		case "signUp":
			getContentPane().removeAll();
			getContentPane().add(con);
			revalidate();
			repaint();
			break;

		case "storeList":
			getContentPane().removeAll();
			getContentPane().add(storeList);
			revalidate();
			repaint();
			break;
		}
	}
	public static void main(String[] args) throws FileNotFoundException {
		MainFrame win = new MainFrame();
		
		win.setTitle("세탁왕");
		//win.cart = new CartView(win);
		win.login = new LoginView(win);
		win.main = new MainView(win);
		//win.mypage = new MypageView(win);
		win.mypageEdit = new MypageEditView(win);
		//win.order = new OrderView(win);
		//win.pay = new PayView(win);
		win.signUp = new SignUpView(win);
		win.storeList = new StoreListView(win);

		win.add(win.login);		
	
		
		win.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		win.setSize(455, 555);
		win.setVisible(true);
	}
}
