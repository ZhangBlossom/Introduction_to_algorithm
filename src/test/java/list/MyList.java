package test.java.list;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Scanner;

/**
 * @author: Zhangjinbiao
 * @Date: 2023/2/21 19:30
 * Description:
 * Version: 1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class MyList {
    private int id;
    private String name;
    private MyList next;
    private int length;

    public MyList addLast(MyList head, MyList node) {
        MyList p = head;
        while (p.next != null) {
            p = p.next;
        }
        p.next = node;
        head.length++;
        return head;
    }

    public MyList addFirst(MyList head, MyList node) {
        node.next = head;
        head = node;
        head.length++;
        return head;
    }

    public MyList remove(MyList head, int n) {
        MyList p = head;
        MyList pre=p;
        if (n==1){ //删除头节点
            return head=head.next;
        }
        for (int i=0;i<n-1;i++){
            pre=p;
            p=p.next;
        }
        pre.next=p.next;
        return head;
    }
    public void print(MyList head){
        while (head!=null){
            System.out.println(head);
            head=head.next;
        }
    }
    public static void main(String[] args) {
        MyList head, tail, p;//创建一些节点
        head = new MyList(1, "头节点", null, 1);
        head=head.addFirst(head,new MyList(2,"2",null,1));
        head=head.addLast(head,new MyList(3,"3",null,2));
        //head.print(head);
        System.out.println(head);
        head=head.remove(head,2);
        System.out.println(head);
        //Scanner in = new Scanner(System.in);
        //while (true) {
        //    System.out.println("请输入你的选择");
        //    System.out.println("1：头插2：尾插3：删除");
        //    switch ()
        //}
    }
}
