import java.util.*;
public class homework1{
	public static void main(String[] args){
		var mainSet=new TreeSet<>();
		Random rd=new Random();
		System.out.println("電腦從1~100的整數中，亂數取出10個不重複的號碼");
		while(mainSet.size()<10){
			int number=rd.nextInt(101);
			if(number==0||mainSet.contains(number)){
				continue;
			}else{
				mainSet.add(number);
				System.out.println("第"+mainSet.size()+"個數字是:"+number);
			}
		}
		System.out.println("物件內元素個數為:"+mainSet.size());
		System.out.println("物件內元素的內容:"+mainSet);
		System.out.println("第一個元素內容為:"+mainSet.first());
		System.out.println("最後一個元素內容為:"+mainSet.last());
		System.out.println("內容介於30~70者:"+mainSet.subSet(3,71));
	}
    
}