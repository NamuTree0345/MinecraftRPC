package namuTree0345.MCRPC;

import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class CreditPage extends JFrame {
	
	static String credit = "<html>������<br/>�� ����: ����(redwikitv@gmail.com)<br/>" + 
							"Java: ����Ŭ(Oracle)<br/>java-native-access: JNA(���α׷��� ���������� Ȯ���ϴ� ���̺귯��)" + 
							"<br/>�����: JNA�� �������ִ��� �������� �ڵ�(https://blog.naver.com/bb_/220453438602)<br/>" +
							"MinnDevelopment: java-discord-rpc<br/><br/>�� �ܿ�! �� ���α׷��� ������ֽ� �е� �����մϴ�!</html>";

	public CreditPage() {
		super("MinecraftRPC ũ����");
		
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
