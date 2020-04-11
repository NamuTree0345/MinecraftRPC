package namuTree0345.MCRPC;

import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef.HWND;
import com.sun.jna.platform.win32.WinDef.RECT;
import com.sun.jna.platform.win32.WinUser.WNDENUMPROC;

public class Hwnd {
	
	 public String wcls;
	 public String wtitle;
	 public static Integer wx;
	 public static HWND res;

	 public HWND getHwnd(String cls,String title, Integer x){

	  res=null;
	  wcls=cls;
	  wtitle=title;
	  wx=x;
	 
	  try{
	   User32.INSTANCE.EnumWindows(new WNDENUMPROC() {
	             int count = 0;

	             public boolean callback(HWND hWnd, Pointer arg1) {
	                 char[] windowText = new char[512];
	                 User32.INSTANCE.GetWindowText(hWnd, windowText, 512);
	                 String wText = Native.toString(windowText);
	                 RECT rectangle = new RECT();
	                 User32.INSTANCE.GetWindowRect(hWnd, rectangle);
	                
	                 //숨겨져 있는 창은 제외하고 찾는다. 최소화 되어있는 창은 포함한다.
	                 //rectangle.left값이 -32000일 경우 최소화되어 있는 창이다.
	                 if (wText.isEmpty() ||
	                    !(User32.INSTANCE.IsWindowVisible(hWnd))) {
	                    return true;
	                 }
	                
	                 //핸들의 클래스 네임 얻기
	                 char[] c=new char[512];
	                 User32.INSTANCE.GetClassName(hWnd, c, 512);
	                 String clsName=String.valueOf(c).trim();
	                
	                 //조건 세 개를 만족하면, 핸들을 돌려줌
	                 int check=0;
	                
	                 //조건1: 요청 클래스네임이 널이거나, 클래스네임과 일치할 경우 체크를 증가
	                 if(wcls==null){//"IEFrame"
	                  check++;
	                 }
	                 else if(clsName.equals(wcls)){ //&& wcls!=null
	                  check++;
	                 }
	                
	                 //조건2: 제목표시줄이 널이거나, 원하는 글자가 포함되어 있다면 체크를 증가
	                 if(wtitle==null){
	                  check++;
	                 }
	                 else if(wText.indexOf(wtitle)>=0){
	                  check++;
	                 }
	                
	                 //조건3
	                 if(wx==null){
	                  //널이라면 안적은걸로 간주
	                  check++;
	                 }
	                 else if(wx>0){
	                  if(rectangle.left>=wx){
	                   //wx가 500이라면  x좌표가 500 이상인 창만 합격
	                   check++;
	                  }
	                 }
	                 else if(wx<0){
	                  if(rectangle.left<=(-wx)){
	                   //wx가 -500이라면  x좌표가 500 이하인 창만 합격
	                   check++;
	                  }
	                 }
	                 //조건 3개를 충족했다면 핸들을 돌려줌
	                 if(check==3){
	                 res=hWnd;
	                
	                 MCRPC.mc.setHwndNum(hWnd);
	                 MCRPC.mc.setWindowTxt(wText);
	                 
	                 System.out.println(
	                          "hwnd:"+hWnd+","+
	                          "번호:" + (++count) + ",텍스트:" + wText+","+
	                          "위치:("+rectangle.left+","+rectangle.top+")~("+rectangle.right+","+rectangle.bottom+"),"+
	                          "클래스네임:"+clsName+","+
	                          "상태:"+User32.INSTANCE.IsWindowVisible(hWnd));
	                 }
	                 
	                 return true;
	             }
	         }, null);
	  
	  }catch(Exception ex){System.out.println(ex.getMessage());}
	 
	  return res;
	 
	 }

	}
