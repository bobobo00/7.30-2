package cn.list;

import java.util.LinkedList;

/**
 * @ClassName Queen
 * @Description 自定义实现队列
 * @Auther danni
 * @Date 2019/7/30 10:13]
 * @Version 1.0
 **/

public class Queen {
      private Qnode front;
      private Qnode rear;
      private int size=0;
      //入队列
      public void push(int x){
          Qnode temp=new Qnode(x);
          if (front==null){
              front=temp;
          }else{
              rear.next=temp;
          }
          rear=temp;
          size++;
      }
      //出队头元素
      public int pop(){
          if(front==null){
              System.err.println("队列为空");
              return -1;
          }
          int val=front.data;
          front=front.next;
          if(front==null){
              rear=null;
          }
          size--;
          return val;
      }
      //查看队头元素
    public int peek(){
        if(front==null){
            System.err.println("队列为空");
            return -1;
        }
        int val=front.data;
        return val;
    }
      //判空
      public boolean isEmpty(){
          return size==0;
      }
      //返回队列长度
    public int size(){
          return size;
    }
    //利用一个队列来实现栈
    public void pushStack(int x){
      this.push(x);
    }

    public int popStack() {
        if (this.isEmpty()) {
            System.err.println("栈为空");
            return -1;
        }
        for (int i = 0; i < size-1; i++){
            this.push(this.pop());
        }
        return this.pop();
    }

    public static void main(String[] args) {
        Queen queen=new Queen();
        /*queen.push(1);
        queen.push(2);
        queen.push(3);
        queen.push(4);
        queen.push(5);
        System.out.println(queen.pop());
        System.out.println(queen.size());
        System.out.println(queen.peek());
        System.out.println(queen.size());*/
        queen.pushStack(1);
        queen.pushStack(2);
        queen.pushStack(3);
        queen.pushStack(4);
        System.out.println(queen.popStack());
    }
}

class Qnode{
    int data;
    Qnode next=null;


    public Qnode() {
    }

    public Qnode(int data) {
        this.data = data;
    }
    public String toString(String s){
        return String.format("%d",data);
    }
}
