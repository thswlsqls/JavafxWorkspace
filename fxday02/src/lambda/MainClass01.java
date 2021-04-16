package lambda;

interface Labda_01{
	public void test();
	public void test(Object obj);
}

class Test01 implements Labda_01{
	public void test() {
		System.out.println("����");
	}

	@Override
	public void test(Object obj) {
		// TODO Auto-generated method stub
		System.out.println("����"+obj);
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
						System.out.println("lambda02���� ȣ��");
				}
			};
			lam02.test();
			Lambda_02 lam03 = () -> System.out.println("lam03���� ȣ��");
			lam03.test();
			
			Lambda_04 lam04 = (a, b, c) -> { 
				System.out.println("�Ѿ�� �� : "+a+b+c); 
			};
			lam04.test("���� �ִ� ��1", "���� �ִ� ��2", "���� �ִ� ��3" );
			
	}
}
