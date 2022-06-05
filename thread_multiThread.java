public class MyThread implements Runnable
{
	int a = 20, b = 10;
	public void run()
	{
		addition(); 
		subtraction();
		multiplication();
	}
	void addition()
	{
		int sum = a + b;
		System.out.println("Addition of two numbers: " +sum);
	}
	void subtraction()
	{
		int sub = a - b;
		System.out.println("Subtraction of two numbers: " +sub);
	}
	void multiplication()
	{
		int multiply = a * b;
		System.out.println("Multiplication of two numbers: " +multiply);
	}
	public static void main(String[] args)
	{
		System.out.println("Main thread running");
		MyThread th = new MyThread();
		Thread t = new Thread(th);
		t.start(); 
	}
}



==========MULTI THREAD==========


public class MyThread extends Thread
{
	String task;

	MyThread(String task)
	{
		this.task = task;
	}
	public void run()
	{

		for(int i = 1; i <= 5; i++)
		{
			System.out.println(task+ " : " +i);
			try
			{
				Thread.sleep(1000); 
			}
			catch(InterruptedException ie) {
				System.out.println(ie.getMessage());
			}
		}
	} 
	public static void main(String[] args)
	{
		MyThread th1 = new MyThread("\nCut the ticket"); 
		MyThread th2 = new MyThread("\nShow your seat number");
		Thread t1 = new Thread(th1);
		Thread t2 = new Thread(th2);
		t1.start();
		t2.start();
	}
}


