package lancer.total.util;

public class RandomNum {

	public String start() {

		int num = (int)((Math.random()*2)+1);
		if(num == 1){
			return pattern1();
		}else{
			return pattern2();
		}
	}
	
	// 영숫영숫영숫영숫
	public String pattern1(){
		String pwd = "";
		int i=0;
		while(i < 4){
			char tmp1 = alpha();
			String tmp2 = number();
			
			if(pwd.indexOf(tmp1) == -1 && pwd.indexOf(tmp2) == -1){
				pwd += tmp1;
				pwd += tmp2;
				i++;
			}
		}
		return pwd;
	}
	
	// 숫영숫영숫영숫영
	public String pattern2(){
		String pwd = "";
		int i=0;
		while(i < 4){
			String tmp1 = number();
			char tmp2 = alpha();
			
			if(pwd.indexOf(tmp1) == -1 && pwd.indexOf(tmp2) == -1){
				pwd += tmp1;
				pwd += tmp2;
				i++;
			}
		}
		return pwd;
	}
	
	public char alpha(){
		int num = (int)((Math.random()*2)+1);
		if(num == 1){
			return (char) (Math.random() * 26 + 65);
		}else{
			return (char) (Math.random() * 26 + 97);
		}
		
	}
	
	public String number(){
		return Integer.toString((int) (Math.random() * 10));
	}
}
