class Bucket
{
    int x;
    boolean full=false;
   synchronized void get()
   {
      if(full==false)
      {
          try
          {
          Thread.sleep(500);
          wait();
          }
          catch(InterruptedException e)
          {
              System.out.println(e);
          }
      } 
      System.out.println("Consumed: "+x);
      full=false;
      notify();
  }
 synchronized void put(int n)
 {
       if(full==true)
      {
         try
         {
              wait();
         }
          catch(InterruptedException e)
          {
                System.out.println(e);
          }
       }
        x=n;
        System.out.println("Produced: "+x);
        full=true;
        notify();
 }  
}

class Producer extends Thread
{
    Bucket b;
    Producer(Bucket b)
    {
      this.b=b;
    }
     public void run()
     {
          int i;
          for(i=1;i<=10;i++)
           { 
                  b.put(i);
            }
      }
  }

class Consumer extends Thread
{
          Bucket b;
          Consumer(Bucket b)
          {
                this.b=b;
          }
          public void run()
          {
                int i;
                for(i=1;i<=10;i++)
                { 
                       b.get();
                }
         }	
}

class ITC
{
       public static void main(String args[ ])
        {
               Bucket b=new Bucket();
               Producer p=new Producer(b);
               Consumer c=new Consumer(b);
               c.start();
               p.start(); 
       }
}
