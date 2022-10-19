
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.lang.Math;
public class calculator extends JFrame implements ActionListener{

	private int size = 20;
	JPanel jp = null;
	JTextField jtf = null;
	JButton []jb = new JButton[size];
	
	JButton jb1 = null,jb2 = null,jb3 = null;
	JPanel jp1 = null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		calculator d = new calculator();
	}

	public calculator()
	{
		jtf = new JTextField();
		jtf.setEditable(false);
		jtf.setPreferredSize(new Dimension(500,100));
		Font font1 = new Font(Font.DIALOG, Font.BOLD, 30);
		jtf.setFont(font1);
		jtf.setHorizontalAlignment(JTextField.RIGHT);
		jp = new JPanel();
		jb[4] = new JButton("7");
		jb[5] = new JButton("8");
		jb[6] = new JButton("9");
		jb[7] = new JButton("/");
		jb[8] = new JButton("4");
		jb[9] = new JButton("5");
		jb[10] = new JButton("6");
		jb[11] = new JButton("*");
		jb[12] = new JButton("1");
		jb[13] = new JButton("2");
		jb[14] = new JButton("3");
		jb[15] = new JButton("+");
		jb[16] = new JButton("0");
		jb[17] = new JButton(".");
		jb[18] = new JButton("=");
		jb[19] = new JButton("-");
		jb[0] = new JButton("CE");
		jb[1] = new JButton("√");
		jb[2] = new JButton("%");
		jb[3] = new JButton("^2");
		
		for(int i = 0;i < size;i ++){
			jp.add(jb[i]);
			jb[i].addActionListener(this);
		}
			
		jp.setLayout(new GridLayout(5,4,10,10));
		this.add(jp);
		
		this.add(jtf,BorderLayout.NORTH);
		
		this.setTitle("計算器");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//設置窗體居中顯示
		this.setLocationRelativeTo(null);
		//禁止改變窗體大小
		this.setResizable(false);
		this.setSize(500,600);
		
		
		this.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == jb[0]){
			//清屏
			jtf.setText("");
		}
		else if(e.getSource() == jb[1]){
			
			String str = jtf.getText();

			double n = Double.parseDouble(str);
			double m = Math.sqrt(n);
			String ss = "√" + String.valueOf(n) + " = " + String.valueOf(m);
			jtf.setText(ss);
		}
		else if(e.getSource() == jb[2]){
			String str = jtf.getText();
			str += "%";
			jtf.setText(str);
		}
		else if(e.getSource() == jb[3]){
			String str = jtf.getText();
			double n = Double.parseDouble(str);
			double m = n * n;
			String ss = String.valueOf(n) + " ^ 2 = " + String.valueOf(m);
			jtf.setText(ss);
		}
		else if(e.getSource() == jb[4]){
			String str = jtf.getText();
			str += "7";
			jtf.setText(str);
		}
		else if(e.getSource() == jb[5]){
			String str = jtf.getText();
			str += "8";
			jtf.setText(str);
		}
		else if(e.getSource() == jb[6]){
			String str = jtf.getText();
			str += "9";
			jtf.setText(str);
		}
		else if(e.getSource() == jb[7]){
			String str = jtf.getText();
			str += "/";
			jtf.setText(str);
		}
		else if(e.getSource() == jb[8]){
			String str = jtf.getText();
			str += "4";
			jtf.setText(str);
		}
		else if(e.getSource() == jb[9]){
			String str = jtf.getText();
			str += "5";
			jtf.setText(str);
		}
		else if(e.getSource() == jb[10]){
			String str = jtf.getText();
			str += "6";
			jtf.setText(str);
		}
		else if(e.getSource() == jb[11]){
			String str = jtf.getText();
			str += "*";
			jtf.setText(str);
		}
		else if(e.getSource() == jb[12]){
			String str = jtf.getText();
			str += "1";
			jtf.setText(str);
		}
		else if(e.getSource() == jb[13]){
			String str = jtf.getText();
			str += "2";
			jtf.setText(str);
		}
		else if(e.getSource() == jb[14]){
			String str = jtf.getText();
			str += "3";
			jtf.setText(str);
		}
		else if(e.getSource() == jb[15]){
			String str = jtf.getText();
			str += "+";
			jtf.setText(str);
		}
		else if(e.getSource() == jb[16]){
			String str = jtf.getText();
			str += "0";
			jtf.setText(str);
		}
		else if(e.getSource() == jb[17]){
			String str = jtf.getText();
			str += ".";
			jtf.setText(str);
		}
		/*
		 * 若為等的時候，計算式子的結果，運算結果為+ - * / %四種方法得到
		 */
		else if(e.getSource() == jb[18]){
			String str = jtf.getText();
			
			char[] ss = str.toCharArray();
			String s1 = "",s2 = "";
			char cc = 0;
			//獲取運算符
			int i;
			for(i = 0;i < ss.length;i ++)
				if(ss[i] =='+'|| ss[i] == '-' || ss[i] == '*' || ss[i] == '/' || ss[i] == '%'){
					cc = ss[i];
					break;
				}
				else
					s1 += String.valueOf(ss[i]);

			for( ++ i;i < ss.length;i ++)
				s2 += String.valueOf(ss[i]);
			
			double[]a = new double[2];
			
			a[0] = Double.parseDouble(s1);
			
			a[1] = Double.parseDouble(s2);
			
			double m = 0.0;
			if(cc == '+')
				m = a[0] + a[1];
			else if(cc == '-')
				m = a[0] - a[1];
			else if(cc == '*')
				m = a[0] * a[1];
			else if(cc == '/' && a[1] != 0)
				m = a[0] / a[1];
			else if(cc == '%')
				m = a[0] % a[1];
			
			str += " = " + String.valueOf(m);
			jtf.setText(str);
		}
		else if(e.getSource() == jb[19]){
			String str = jtf.getText();
			str += "-";
			jtf.setText(str);
		}
	}

}