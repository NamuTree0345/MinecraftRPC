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
	                
	                 //������ �ִ� â�� �����ϰ� ã�´�. �ּ�ȭ �Ǿ��ִ� â�� �����Ѵ�.
	                 //rectangle.left���� -32000�� ��� �ּ�ȭ�Ǿ� �ִ� â�̴�.
	                 if (wText.isEmpty() ||
	                    !(User32.INSTANCE.IsWindowVisible(hWnd))) {
	                    return true;
	                 }
	                
	                 //�ڵ��� Ŭ���� ���� ���
	                 char[] c=new char[512];
	                 User32.INSTANCE.GetClassName(hWnd, c, 512);
	                 String clsName=String.valueOf(c).trim();
	                
	                 //���� �� ���� �����ϸ�, �ڵ��� ������
	                 int check=0;
	                
	                 //����1: ��û Ŭ���������� ���̰ų�, Ŭ�������Ӱ� ��ġ�� ��� üũ�� ����
	                 if(wcls==null){//"IEFrame"
	                  check++;
	                 }
	                 else if(clsName.equals(wcls)){ //&& wcls!=null
	                  check++;
	                 }
	                
	                 //����2: ����ǥ������ ���̰ų�, ���ϴ� ���ڰ� ���ԵǾ� �ִٸ� üũ�� ����
	                 if(wtitle==null){
	                  check++;
	                 }
	                 else if(wText.indexOf(wtitle)>=0){
	                  check++;
	                 }
	                
	                 //����3
	                 if(wx==null){
	                  //���̶�� �������ɷ� ����
	                  check++;
	                 }
	                 else if(wx>0){
	                  if(rectangle.left>=wx){
	                   //wx�� 500�̶��  x��ǥ�� 500 �̻��� â�� �հ�
	                   check++;
	                  }
	                 }
	                 else if(wx<0){
	                  if(rectangle.left<=(-wx)){
	                   //wx�� -500�̶��  x��ǥ�� 500 ������ â�� �հ�
	                   check++;
	                  }
	                 }
	                 //���� 3���� �����ߴٸ� �ڵ��� ������
	                 if(check==3){
	                 res=hWnd;
	                
	                 MCRPC.mc.setHwndNum(hWnd);
	                 MCRPC.mc.setWindowTxt(wText);
	                 
	                 System.out.println(
	                          "hwnd:"+hWnd+","+
	                          "��ȣ:" + (++count) + ",�ؽ�Ʈ:" + wText+","+
	                          "��ġ:("+rectangle.left+","+rectangle.top+")~("+rectangle.right+","+rectangle.bottom+"),"+
	                          "Ŭ��������:"+clsName+","+
	                          "����:"+User32.INSTANCE.IsWindowVisible(hWnd));
	                 }
	                 
	                 return true;
	             }
	         }, null);
	  
	  }catch(Exception ex){System.out.println(ex.getMessage());}
	 
	  return res;
	 
	 }

	}
