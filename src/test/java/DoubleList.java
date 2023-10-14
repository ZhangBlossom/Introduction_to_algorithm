import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: 张锦标
 * @date: 2023/10/14 11:17
 * DoubleList类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoubleList {
    int data;
    int length = 0;
    int id = 0;
    DoubleList pre;
    DoubleList next;

    public DoubleList(int data) {
        this.next = null;
        this.data = data;
        this.length = 1;
        this.id = 1;
        this.pre = null;
    }

    public DoubleList(int data, DoubleList next, DoubleList pre) {
        id++;
        length++;
    }

    public void insertAfter(int id, int data, DoubleList head) {
        if (head==null){
            return ;
        }
        DoubleList temp = head;
        // length = 3 id = 1;
        if (id > length) {
            while(temp.next!=null){
                temp = temp.next;
            }
            temp.next = new DoubleList(data,temp.next.next,temp);
            return;
        }
        for (int i = 0; i < id-1; i++) {
            temp = temp.next;
        }
        temp.next = new DoubleList(data,temp.next.next,temp);
    }
    public void print(DoubleList head){
        DoubleList temp = head;
        while(temp!=null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
    public static void main(String[] args) {
        DoubleList doubleList = new DoubleList(1);
        doubleList.insertAfter(1,2,doubleList);
        doubleList.insertAfter(1,3,doubleList);
        doubleList.insertAfter(1,4,doubleList);
        doubleList.print(doubleList);
        //id name score
        //select id,name,score from tableX where name = 'zhangsan'
        //select id,name,score from tableX t1 inner join tableX t2
        //group by id,name having t1.score>60 and t1.id= t2.id and t1.name= t2.name;
        //(name,score)
        // id
        // redis:id\ jianghao
        //hashmap iphash
        //jiqun
        //expire 2024
    }
}
