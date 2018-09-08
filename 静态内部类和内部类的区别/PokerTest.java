class Poker{
	private static String[] suites = {"黑桃","红桃","草花","方块"};
	private static int[] faces = {1,2,3,4,5,6,7,8,9,10,11,12,13};
	//静态内部类
	public static class StaticClass{
		String str = "内部静态类";
	}
	//牌类  内部类
	private Card[] cards;
	Poker(){
		cards = new Card[52];
		for(int i = 0; i < suites.length; i++){
			for(int j = 0; j < faces.length; j++){
				cards[i * 13 + j] = new Card(suites[i],faces[j]);
			}
		}
	}
	
	//洗牌
	public void shuffle(){
		for(int i = 0, len = cards.length; i < len; i++){
			int index = (int)(Math.random() * len);
			Card temp = cards[index];
			cards[index] = cards[i];
			cards[i] = temp;
		}
	}
	//发牌
	public Card deal(int index){
		return cards[index];
	}
	public class Card{
		private String suite;  //花色
		private int face;        //点数
		
		//内部类的构造函数
		public Card(String suite, int face){
			this.suite = suite;
			this.face = face;
		}
		@Override
		public String toString(){
			String faceStr = "";
			switch(face){
				case 1 : faceStr = "A";break;
				case 11 : faceStr = "J";break;
				case 12 : faceStr = "Q";break;
				case 13 : faceStr = "K";break;
				default : faceStr = String.valueOf(face);
			}
			return suite + faceStr;
		}
	}
}

public class PokerTest{
	public static void main(String[] args){
		//静态内部类的创建不依赖于外部类对象
		Poker.StaticClass staticClass = new Poker.StaticClass();
		System.out.println(staticClass.str);
		
		//外部类对象这个时候才创建
		Poker poker = new Poker();
		
		Poker.Card c14 = poker.deal(13);    //是红桃A
		System.out.println(c14);
		poker.shuffle();                    //洗牌
		c14 = poker.deal(13);
		System.out.println(c14);
		/*
		对于非静态内部类Card,只有通过其外部类Poker对象才能创建Card对象
		*/
		Poker.Card c1 = poker.new Card("黑桃",1);  //自己创建一张牌
		System.out.println(c1);
		
	}
}













