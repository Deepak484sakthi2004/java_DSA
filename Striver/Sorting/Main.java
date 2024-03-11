import java.util.Scanner;
class Main{

    static class node{
        int val;
        node next;
        node(int x)
        {
            this.val=x;
        }
    }

    node head=null;
    public static void main(String[] args) {
        Scanner z=new Scanner(System.in);
        Main m=new Main();
        int n=z.nextInt();

        for(int i=0;i<n;i++)
        {
            m.insert(z.nextInt());
        }
        m.display(m.head);
        System.out.println("insert the pos");
        int pos=z.nextInt();
        m.pop_ele(pos);
//        m.sort(m.head);

        m.display(m.head);
    }

    void pop_ele(int pos)
    {
        int l=length(head);
        node temp=head;
        int v=l- pos-1;
        while(v-->0)
        {
  temp=temp.next;
        }
        node x=temp.next.next;
        temp.next=x;
    }
    void insert(int x)
    {
        node a=new node(x);
        if(head==null)
        {
            head=a;
        }
        else {
            node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = a;
        }
    }

    void display(node head)
    {
        node temp=head;
        while(temp.next!=null)
        {
            System.out.print(temp.val+"->");
            temp=temp.next;
        }
        System.out.println(temp.val);

    }

    void sort(node head)
    {
        int n=length(head);

            for(node i=head;i.next!=null;i=i.next)
            {
                for(node j=i.next;j!=null;j=j.next)
                {
                    if(i.val>j.val)
                    {
                        int temp=i.val;
                        i.val=j.val;
                        j.val=temp;
                    }
                }
            }


    }


    static int length(node head)
    {
        node temp=head;
        int c=0;
        while(temp!=null)
        {
            c++;
            temp=temp.next;
        }
        return c;
    }

}