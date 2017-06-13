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
		for(int i=0; i<4; i++){
			pwd += alpha();
			pwd += number();
		}
		return pwd;
	}
	
	// 숫영숫영숫영숫영
	public String pattern2(){
		String pwd = "";
		for(int i=0; i<4; i++){
			pwd += number();
			pwd += alpha();
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
