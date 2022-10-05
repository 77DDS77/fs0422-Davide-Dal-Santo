package EsClasse;

public class T1 extends Thread{
	int x, y;
	
	T1(int x, int y, String name){
		this.x = x;
		this.y = y;
		this.setName(name);
	}
	
	@Override
	public void run() {
		for(int i = x; i <= y ; i++) {
			System.out.println(i + " " + getName());
		}
	}
}
