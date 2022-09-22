import java.util.*;
public class homework2{
	public static void main(String[] args) {
		HashMap<Integer,String> map=init();
		System.out.print("請輸入1~12?");
		Scanner sc =new Scanner(System.in);
		var input=sc.nextInt();
		if(1<=input&&input<=12){
			System.out.println("第"+input+"月的英文單字為"+map.get(input));
		}else{
			System.out.println("範圍錯誤!");
		}
	}
	public static HashMap<Integer,String> init (){
		HashMap<Integer,String> a=new HashMap<>();
		a.put(1,"January");
		a.put(2,"Febuary");
		a.put(3,"March");
		a.put(4,"April");
		a.put(5,"May");
		a.put(6,"June");
		a.put(7,"July");
		a.put(8,"August");
		a.put(9,"September");
		a.put(10,"October");
		a.put(11,"November");
		a.put(12,"December");
		return a;
	}
}