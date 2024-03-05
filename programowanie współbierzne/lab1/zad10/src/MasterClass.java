import java.util.List;

public class MasterClass extends Thread{
    List<Integer> list;

    public MasterClass(List<Integer> list) {
        this.list = list;
    }
    public void setValue(int i)
    {
        list.add(i);
    }

    @Override
    public void run()
    {
        while (list.size()>1)
        {
            System.out.println(list);
            int x1=list.get(list.size()-1);
            list.remove(list.size()-1);
            int x2=list.get(list.size()-1);
            list.remove(list.size()-1);
            Thread slave=new SlaveClass(x1,x2,this);
            slave.start();

            try {
                slave.join();
            } catch (InterruptedException e) {
                System.out.println("Wystąpił problem z slave: "+e);
            }

        }
        System.out.println("Dzielnik: "+ list.get(0));
    }
}
