package lambda;
interface Lambda_01{
	public void test();
}
class Test01 implements Lambda_01{
	public void test() {
		System.out.println("실행");
	}
}
interface Lambda_02{
	public void test();
}
interface Lambda_04{
	public void test(Object obj,Object obj1,Object obj2);
}
public class MainClass01 {
	public static void main(String[] args) {
		
		Test01 t01 = new Test01();
		
		Lambda_02 lam02 = new Lambda_02() {
			public void test() {
				System.out.println("lam02에서 호출");
			}
		};
		
		lam02.test();
		Lambda_02 lam03 = () -> System.out.println("lam0333에서 호출");
		lam03.test();
		
		Lambda_04 lam04 = (aaaa,a,b) -> {
			System.out.println("넘어온 값 : "+aaaa);
		};
		lam04.test("내가주는값",1,1);
		
	}
}





