package namuTree0345.MCRPC;

import java.util.ArrayList;

import com.sun.jna.platform.win32.WinDef.HWND;

public class MCChecker {
	
	public ArrayList<String> notLegacy = new ArrayList<String>();
	public ArrayList<String> Legacy = new ArrayList<String>();
	
	public MCChecker() {
		// 1.16(��þȵ�)
		notLegacy.add("1.16");
		
		// 1.15
		notLegacy.add("1.15.2");
		notLegacy.add("1.15.1");
		notLegacy.add("1.15");
		// 1.14
		notLegacy.add("1.14.4");
		notLegacy.add("1.14.3");
		notLegacy.add("1.14.2");
		notLegacy.add("1.14.1");
		notLegacy.add("1.14");
		// 1.13
		notLegacy.add("1.13.2");
		notLegacy.add("1.13.1");
		notLegacy.add("1.13");
		
		// 1.12
		Legacy.add("1.12.2");
		Legacy.add("1.12.1");
		Legacy.add("1.12");
		// 1.11
		Legacy.add("1.11.2");
		Legacy.add("1.11.1");
		Legacy.add("1.11");
		// 1.10
		Legacy.add("1.10.2");
		Legacy.add("1.10.1");
		Legacy.add("1.10");
		// 1.9
		Legacy.add("1.9.5");
		Legacy.add("1.9.4");
		Legacy.add("1.9.3");
		Legacy.add("1.9.2");
		Legacy.add("1.9.1");
		Legacy.add("1.9");
		// 1.8
		Legacy.add("1.8.9");
		Legacy.add("1.8.8");
		Legacy.add("1.8.7");
		Legacy.add("1.8.6");
		Legacy.add("1.8.5");
		Legacy.add("1.8.4");
		Legacy.add("1.8.3");
		Legacy.add("1.8.2");
		Legacy.add("1.8.1");
		Legacy.add("1.8");
	}
	
	public boolean checkMC() {
		HWND hwnd = new Hwnd().getHwnd(null, "Minecraft", null);
		HWND hwnd2 = new Hwnd().getHwnd(null, "Badlion", null);
		
		if (hwnd!=null) {
			// �����찡 ������
			MCRPC.label.setText("����ũ����Ʈ�� �������ϴ�!");
			System.out.println("Checked: Minecraft is running!");
			System.out.println("Checked: MC Name is " + MCRPC.mc.getWindowTxt());
			return true;
		} else if(hwnd2!=null) {
			// Badlion �϶�
			MCRPC.label.setText("������̾� Ŭ���̾�Ʈ�� �������ϴ�!");
			System.out.println("Checked: Badlion Client is running!");
			System.out.println("Checked: MC Name is " + MCRPC.mc.getWindowTxt());
			return true;
		} else {
			// �����찡 ������
			System.out.println("Checked: Minecraft is not running!");
			MCRPC.label.setText("����ũ����Ʈ�� ������ �ʾҽ��ϴ�.");
			return false;
		}
		
	}
	
	public MinecraftType getMCType(Minecraft m) {
		
		for(int i = 0; i < this.notLegacy.size() -1; i++) {
			if(m.getWindowTxt().contains(this.notLegacy.get(i))) {
				return MinecraftType.VANILLA;
			}
		}
		
		for(int i = 0; i < this.Legacy.size() -1; i++) {
			if(m.getWindowTxt().contains(this.Legacy.get(i))) {
				return MinecraftType.VANILLA_LEGACY;
			}
		}
		
		return null;
	}
	
}
