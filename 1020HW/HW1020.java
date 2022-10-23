import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Image;
import java.io.InputStream;
import java.net.URL;
import java.util.*;
public class HW1020 extends JFrame{
    private JLabel label;
    private HashMap<Integer,ImageIcon> icon=new HashMap<>();
    private Image image;
    private String[] imageName={"1.jpg","2.jpg","3.jpg"};
    public JLabel title;
    public Integer currentImg=2;
    public static void main(String[]args){
        new HW1020();
    }
    public HW1020(){
        setTitle("PhotoViewer");
        setSize(1350,740);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());
        setResizable(false);
        int i=1;
	    for(String item:imageName) {
            ImageIcon newIcon = new ImageIcon(item);
            image = newIcon.getImage().getScaledInstance(1280, 720,Image.SCALE_DEFAULT);
            //icon.put(i,newIcon);
            icon.put(i,new ImageIcon(image));
            i++;
        }
        label = new JLabel(icon.get(currentImg),SwingConstants.CENTER);
        title=new JLabel("mywife"+currentImg.toString(),SwingConstants.CENTER);
        label.setFont(new Font("細明體", Font.PLAIN, 20));
        title.setFont(new Font("細明體", Font.PLAIN, 20));
        getContentPane().add(title,"North");
        getContentPane().add(label, "Center");

        JButton last=new JButton("last");
        JButton next=new JButton("next");
        last.setBorderPainted(false);
        next.setBorderPainted(false);
        last.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                if(currentImg==1){
                    JOptionPane.showMessageDialog(getContentPane(), "已經最前面啦");
                }else{
                    currentImg--;
                    title.setText("mywife"+currentImg.toString());
                    label.setIcon(icon.get(currentImg));
                    getContentPane().revalidate();
                }
            }
        });
        next.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                if(currentImg==3){
                    JOptionPane.showMessageDialog(getContentPane(), "已經最後面啦");
                }else{
                    currentImg++;
                    title.setText("mywife"+currentImg.toString());
                    label.setIcon(icon.get(currentImg));
                    getContentPane().revalidate();
                }
            }
        });
        last.setPreferredSize(new Dimension(110, 720));
        next.setPreferredSize(new Dimension(110, 720));
        getContentPane().add(last, "West");
        getContentPane().add(next, "East");
        setVisible(true);


    }

}