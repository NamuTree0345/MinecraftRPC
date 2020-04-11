package namuTree0345.MCRPC;

import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class CreditPage extends JFrame {
	
	static String credit = "<html>개발자<br/>총 개발: 나무(redwikitv@gmail.com)<br/>" + 
							"Java: 오라클(Oracle)<br/>java-native-access: JNA(프로그램이 실행중인지 확인하는 라이브러리)" + 
							"<br/>흑곰님: JNA로 윈도우있는지 가져오는 코드(https://blog.naver.com/bb_/220453438602)<br/>" +
							"MinnDevelopment: java-discord-rpc<br/><br/>이 외에! 이 프로그램을 사용해주신 분들 감사합니다!</html>";

	public CreditPage() {
		super("MinecraftRPC 크레딧");
		
		setLayout(null);
		
		JLabel cr = new JLabel(credit);
		
		cr.setFont(MCRPC.font);
		cr.setSize(1000,300);
		cr.setText(credit);
		
		add(cr);
		setSize(1000, 500);
		setVisible(true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		
		System.out.println("Initiallized CreditPage.");
	}
	
}
