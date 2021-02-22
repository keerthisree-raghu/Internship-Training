package day5;

public class Quiz {
	// Q1
	/*
	public static void main(String[] args) {
		float f = 1.3;
		char c = "a";
		byte b = 257;
		boolean b = null;
		int i = 10;
	}
	*/
	
	// Q2
	/*
	public static void main(String arguments[]) {
		amethod(arguments); // Cannot make a static reference to a non-static method
	}
	public void amethod(String[] arguments) {
		System.out.println(arguments);
		System.out.println(arguments[1]);
	}
	*/
	
	// Q5
	/*
	public static void main(String[] args) {
		System.out.println(args[2]);
	}
	*/
	
	// Q8
	/*
	static int i;
	public static void main(String[] args) {
		System.out.println(i);
	}
	*/
	
	// Q11
	/*
	abstract class MineBase {          
		abstract void amethod();          
		static int i;  
	} 
	public class Mine extends MineBase {          
		public static void main(String argv[]){ 
			int[] ar=new int[5];               
			for(i=0;i < ar.length;i++)          
				System.out.println(ar[i]);          
		}  
	}
	*/
	
	// Q15
	/*
	public static void main(String[] args) {
		Quiz q = new Quiz();
		System.out.println(q.amethod());
	}
	public int amethod() {
		 try {     
			 FileInputStream dis=new FileInputStream("Hello.txt");    
			 }catch (FileNotFoundException fne) {   
				 System.out.println("No such file found");    
				 return -1;                      
			}catch(IOException ioe) { 
			} finally{     
				System.out.println("Doing finally");      
			}     
		 return 0;    
		 } 
	*/
	
	// Q17
	/*
	class Base {}  
	class Sub extends Base {}  
	class Sub2 extends Base {} 
	public static void main(String[] args) {
		Base b = new Base();
		Sub s = (Sub) b;
	}
	*/
	
	// Q21
	/*
	public static void main(String argv[]){     
		int i;  
		int j;    
		outer:    
			for (i=1;i <3;i++)      
				inner:        
					for(j=1; j<3; j++) {     
						if (j==2)      
							continue outer;     
						System.out.println("Value for i=" + i + " Value for j=" +j);                   
				}        
		}
		*/
	
	// Q24
	/*
	public static void main(String[] args) {
		System.out.println(Math.ceil(-4.7));
	}
	*/
	
	// Q25
	/*
	public static void main(String[] args) {
		Integer ten=new Integer(10);  
		Long nine=new Long (9); 
		System.out.println(ten + nine);  
		int i=1; 
		System.out.println(i + ten); 
	}
	*/
	
	// Q26
	/*
	public static void main(String[] args) {
		String s = new String("Bicycle");
		int iBegin = 1;
		char iEnd = 3;
		System.out.println(s.substring(iBegin, iEnd));
	}
	*/
	
	// Q29
	/*
	public static void main(String[] args) {
		System.out.println(4 | 3);
	}
	*/
	
	// Q35
	/*
	public static void main(String[] args) {
		Quiz q = new Quiz();
		String s = new String("ello");
		q.amethod(s);
	}
	public void amethod(String s) {
		char c = 'H';
		c += s;
		System.out.println(c);
	}
	*/
	
	// Q41
	/*
	static int j = 20;
	public static void main(String[] args) {
		int i = 10;
		Quiz q = new Quiz();
		q.amethod(i);
		System.out.println(i);
		System.out.println(j);
	}
	public void amethod(int x) {
		x = x * 2;
		j = j * 2;
	}
	*/
	
	// Q44
	/*
	public static void main(String[] args) {
		Quiz q = new Quiz();
		q.amethod();
	}
	public void amethod() {
		int oi = 012;
		System.out.println(oi);
	}
	*/
	
	// Q45
	/*
	public static void main(String[] args) {
		Quiz q = new Quiz();
		q.amethod(q);
	}
	public void amethod(Quiz q) {
		int i = 99;
		multi(q);
		System.out.println(i);
	}
	public void multi(Quiz q) {
		q.i = q.i * 2;
	}
	*/
	
	// Q49
	/*
	public static void main(String[] args) {
		int iRand;
		iRand = Math.random();
		System.out.println(iRand);
	}
	*/
	
	// Q51
	/*
	private int i;
	public static void main(String[] args) {
		Quiz q = new Quiz();
		q.amethod();
	}
	public static void amethod() {
		System.out.println(i);
	}
	*/
	
	// Q58
	/*
	public static void main(String[] args) {
		Base b = new Base();
		b.amethod();
	}
	*/
}

//Q 59
/*
class Base2 {
	private void amethod(int iBase) {
		System.out.println("Base.amethod");
	}
}
public class Quiz extends Base2 {
	public static void main(String[] args) {
		Quiz q = new Quiz();
		int iBase = 0;
		q.amethod(iBase);
	}
	public void amethod(int iOver) {
		System.out.println("Over.amethod");
	}
}
*/
