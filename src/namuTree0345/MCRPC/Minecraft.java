package namuTree0345.MCRPC;

import com.sun.jna.platform.win32.WinDef.HWND;

public class Minecraft {
	
	private boolean isRunning;
	private String mcName;
	private String mcVersion;
	private boolean isAutoCheck;
	
	private HWND hwnd;
	private String windowTxt;
	
	
	public boolean isRunning() {
		return isRunning;
	}
	public void setRunning(boolean isRunning) {
		this.isRunning = isRunning;
	}
	public String getMcName() {
		return mcName;
	}
	public void setMcName(String mcName) {
		this.mcName = mcName;
	}
	public String getMcVersion() {
		return mcVersion;
	}
	public void setMcVersion(String mcVersion) {
		this.mcVersion = mcVersion;
	}
	public boolean isAutoCheck() {
		return isAutoCheck;
	}
	public void setAutoCheck(boolean isAutoCheck) {
		this.isAutoCheck = isAutoCheck;
	}
	public String getWindowTxt() {
		return windowTxt;
	}
	public void setWindowTxt(String windowTxt) {
		this.windowTxt = windowTxt;
	}
	public HWND getHwndNum() {
		return hwnd;
	}
	public void setHwndNum(HWND hWnd) {
		this.hwnd = hWnd;
	}

}
