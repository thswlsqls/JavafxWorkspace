package lambda;

interface Labda_01{
	public void test();
	public void test(Object obj);
}

class Test01 implements Labda_01{
	public void test() {
		System.out.println("실행");
	}

	@Override
	public void test(Object obj) {
		// TODO Auto-generated method stub
		System.out.println("실행"+obj);
	}
}

interface Lambda_02{
	public void test();
}

interface Lambda_04{
	public void test(Object obj, Object obj1, Object obj2);
}


public class MainClass01 {
	public static void main(String[] args) {
			Test01 t01 = new Test01();
			t01.test();
			Lambda_02 lam02 = new Lambda_02()	{
				public void test() {
						System.out.println("lambda02에서 호출");
				}
			};
			lam02.test();
			Lambda_02 lam03 = () -> System.out.println("lam03에서 호출");
			lam03.test();
			
			Lambda_04 lam04 = (a, b, c) -> { 
				System.out.println("넘어온 값 : "+a+b+c); 
			};
			lam04.test("내가 주는 값1", "내가 주는 값2", "내가 주는 값3" );
			
	}
}
