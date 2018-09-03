import java.awt.*;
import javax.swing.*;

//FlowLayout型布局是JPanel型容器的默认布局
class WindowFlowLayout extends JFrame{
	JButton b[] = new JButton[10];
	WindowFlowLayout(String s){
		super(s);
		setVisible(true);         //可见
		validate();               //有效布局
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    //关闭方式
		setSize(500,500);         //窗口大小
		setLocation(200,200);        //显示位置
		FlowLayout flow = new FlowLayout();
		flow.setAlignment(FlowLayout.CENTER);  //对齐方式
		flow.setHgap(20);       //水平间隙
		flow.setVgap(80);            //垂直间隙
		setLayout(flow);
		for(int i = 0; i < b.length; i++){
			b[i] = new JButton("" + i);
			
			if(i == 7 || i == 9){
				b[i].setPreferredSize(new Dimension(70,70));
			}
			add(b[i]);
		}
	}
}

//BorderLayout布局是window型容器的默认布局
class WindowBorderLayout extends JFrame{
	JButton b[] = new JButton[5];
	WindowBorderLayout(String s){
		super(s);
		setVisible(true);
		validate();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  //这里不用EXIT_ON_CLOSE //避免点击关闭这个窗口时，把之前的窗口也关闭
		setSize(500,500);
		setLocation(300,200);
		//setLayout(border);     这句不用写，默认的，因为JFrame JDialog 默认布局BorderLayout
		b[0] = new JButton("北");
		b[1] = new JButton("南");
		b[2] = new JButton("东");
		b[3] = new JButton("西");
		b[4] = new JButton("中");
		add(b[0],BorderLayout.NORTH);
		add(b[1],BorderLayout.SOUTH);
		add(b[2],BorderLayout.EAST);
		add(b[3],BorderLayout.WEST);
		add(b[4],BorderLayout.CENTER);
	}
}

class WindowCardLayout extends JFrame{
	JButton b[] = new JButton[3];
	String cardName[] = {"1","2","3"};
	WindowCardLayout(String s){
		super(s);
		setVisible(true);
		validate();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(400,200,500,500);  //相当于setLocation(400,200); setSize(500,500)
		CardLayout card = new CardLayout();
		setLayout(card);
		b[0] = new JButton("第一个按钮");
		add(cardName[0],b[0]);
		b[1] = new JButton("第二个按钮");
		add(cardName[1],b[1]);
		b[2] = new JButton("第三个按钮");
		add(cardName[2],b[2]);
		Container container = getContentPane();   //获取当前容器
		card.show(container,cardName[1]);
		//card.last(container);
	}
}
class WindowGridLayout extends JFrame{
	JButton b[] = new JButton[6];
	WindowGridLayout(String s){
		super(s);
		setVisible(true);
		validate();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(500,200,500,500);
		GridLayout grid = new GridLayout(3,2);
		setLayout(grid);
		for(int i = 0; i < 6; i++){
			b[i] = new JButton(i + 1 + "");
			add(b[i]);
		}
	}
}

class WindowBoxLayout extends JFrame{
	Box baseBox, boxV1, boxV2;
	WindowBoxLayout(String s){
		super(s);
		boxV1 = Box.createVerticalBox(); //创建一个列型盒式布局
		boxV1.add(new JLabel("输入您的名字"));
		boxV1.add(Box.createVerticalStrut(8));
		boxV1.add(new JLabel("输入您的email"));
		boxV1.add(Box.createVerticalStrut(8));
		boxV1.add(new JLabel("输入您的职业"));
		
		boxV2 = Box.createVerticalBox();
		boxV2.add(new JTextField(16));
		boxV2.add(Box.createVerticalStrut(8));          //设置垂直间距
		boxV2.add(new JTextField(16));
		boxV2.add(Box.createVerticalStrut(8));
		boxV2.add(new JTextField(16));
		
		baseBox = Box.createHorizontalBox();
		baseBox.add(boxV1);
		baseBox.add(Box.createHorizontalStrut(10));        //设置横向间距
		baseBox.add(boxV2);
		

		setLayout(new FlowLayout());
		add(baseBox);
		setBounds(600,200,300,170);
		setVisible(true);
		validate();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}

class WindowNullLayout extends JFrame{
	JButton b[] = new JButton[2];
	WindowNullLayout(String s){
		super(s);
		setVisible(true);
		validate();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(700,200,500,525);
		setLayout(null);
		b[0] = new JButton("1");
		add(b[0]);
		b[0].setBounds(0,0,250,250);
		b[1] = new JButton("2");
		add(b[1]);
		b[1].setBounds(250,250,250,250);
	}
}

public class Main{
	public static void main(String []args){
		/*
		FlowLayout布局中，组件按照加入的先后顺序从左向右排列，一行排满后就站到下一行继续从左向右排列
		每一行中的组件都居中排列，组件之间的默认水平和垂直间隙是5个像素，组件的大小伟默认的最佳大小
		对于添加到使用FlowLayout布局的容器中的组件，组件调用setSize(int x,int y)设置的大小无效，如需更改大小，
		需要调用setPreferredSize(Dimension preferredSize)
		
		setAlignment(int aligin)可以更改对齐方式
		*/
		WindowFlowLayout w = new WindowFlowLayout("FlowLayout布局");
		
		/*
		BorderLayout是一种简单的布局策略，如果一个容器使用这种布局，那么容器空间简单的划分为东西南北中五个区域
		中间的区域最大，每加入一个组件都应该指明把这个组件加在哪个区域
		每个区域只能放置一个组件，同一个区域放置多个组件，会发生覆盖效果
		*/
		WindowBorderLayout i = new WindowBorderLayout("BorderLayout布局");
		/*
		CardLayout容器可以容纳多个组件，这些组件被层叠放入容器中，最先加入容器的是第一张(在最上面)
		依次向下排序。使用该布局的特点是，同一时刻容器只能从这些组件中选出一个来显示，显示的组件占据容器的全部空间
		*/		
		WindowCardLayout n = new WindowCardLayout("CardLayout布局");
		/*
		GridLayout是使用较多的布局编辑器，基本策略是把容器划分为若干行乘若干列的网格区域
		add方法依次将组件加入第一行第一个，第一行第二个.....
		通常一个容器使用GridLayout之后，假设将容器分为3行1列，那么用户可以把另一个容器添加到网格中，而添加的这个容器又可以
		设置为其他布局
		*/
		WindowGridLayout d = new WindowGridLayout("GridLayout布局");
		/*
		BoxLayout是盒式容器的默认布局，而且不允许更改盒式容器的布局
		因此，盒式布局通常要嵌套
		使用盒式布局的容器将组件排列成一行或一列，这取决于创建盒式布局对象时，是否制定行排序或列排序
		BoxLayout(Container con, int axis);
		和FlowLayout不同的是，盒式布局只有一行或一列，即使组件再多，也不会延伸到下一行
		*/
		
		WindowBoxLayout o = new WindowBoxLayout("BoxLayout布局");
		/*
		该布局需要为每个组件指定大小和位置
		*/
		WindowNullLayout u = new WindowNullLayout("NullLayout布局");
		
	}
}