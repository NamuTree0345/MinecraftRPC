package namuTree0345.MCRPC;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class MCRPC extends JFrame {
	
	public static Minecraft mc = new Minecraft();
	public static Font font = new Font("CookieRun Bold", 0, 24);
	public static MCChecker checker = new MCChecker();
	public static JLabel label;
	public static JButton credit;
	public static JCheckBox loopCheck;
	public static boolean isRPCCreated = false;
	
    public MCRPC()
    {
    	
    	super("����ũ����Ʈ ���ڵ� RPC ���� / Made by NamuTree0345");
    	
        // ��ư�� �ֱ����� �г� ����
        label = new JLabel("�ν���...");
        credit = new JButton("ũ����");
        loopCheck = new JCheckBox("", true);
        label.setLocation(1, 100);
        label.setSize(1000,300);
        credit.setSize(300,30);
        credit.setLocation(1, 1);
        setLayout(null);
        credit.setFont(font);
        label.setFont(font);
        
        loopCheck.setText("����ũ����Ʈ ���� �ִ��� Ȯ���ϱ�(���� ������)");
        loopCheck.setFont(font);
        loopCheck.setEnabled(true);
        loopCheck.setLocation(1, 100);
        loopCheck.setSize(1000, 30);
        
        credit.addActionListener(new ActionListener(){ //�͸�Ŭ������ ������ �ۼ�
			public void actionPerformed(ActionEvent e){
				new CreditPage();
			}
		});
        
        add(loopCheck);
        add(label);
        add(credit);
        
        setSize(579, 310);
        setVisible(true);
        
        mc.setRunning(false);
        System.out.println("Initiallized!");
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        try {
        	System.out.println(checker.getMCType(mc));
        } catch(NullPointerException ex) {
        	System.out.println("Minecraft is not detected!");
        	label.setText("����ũ����Ʈ�� ������ �ʾҽ��ϴ�.");
        }
        
        while(true) {
        	
        	if (loopCheck.isSelected()) {
        		
        		//boolean check = checker.checkMC();
        		//boolean cn = mc.getGLClassName() == "GLFW30";
        		
        		if(checker.checkMC() && mc.getGLClassName() == "GLFW30") {
        			
        			
		        	if (!isRPCCreated) {
		        		System.out.println("Playing New MC.");
		        		MCDiscord.RpcCreate("698421368684937237", "����ũ����Ʈ �÷�����!", mc.getWindowTxt(), "bigimg", "smallimg", "����ũ����Ʈ �÷�����", mc.getWindowTxt());
		        		isRPCCreated = true;
		        		System.out.println("CN: " + mc.getGLClassName());
		    		} else {}
		        			
		        			/*switch(checker.getMCType(mc)) {
		        			case VANILLA:
		        				if (!isRPCCreated) {
			        				System.out.println("Playing New MC.");
			        				MCDiscord.RpcCreate("698421368684937237", "����ũ����Ʈ �÷�����!", mc.getWindowTxt(), "bigimg", "smallimg", "����ũ����Ʈ �÷�����", mc.getWindowTxt());
			        				isRPCCreated = true;
		        				} else {}
		        			case VANILLA_LEGACY:
		        				if (!isRPCCreated) {
			        				System.out.println("Playing Old MC.");
			        				MCDiscord.RpcCreate("698421368684937237", "����ũ����Ʈ �÷�����!", mc.getWindowTxt(), "bigimg", "smallimg", "����ũ����Ʈ �÷�����", mc.getWindowTxt());
			        				isRPCCreated = true;
		        				} else {}
		        			}*/
		        			
		        	System.out.println("CN: " + mc.getGLClassName());
		     	} else {
		        	if(isRPCCreated) {
		        		MCDiscord.RpcClear();
		        		isRPCCreated = false;
		        	}
		        }
        	}
        	
        }
        
        
    }
	
	public static void main(String[] args) {
		new MCRPC();
	}

}
