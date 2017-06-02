package test.zingfront;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 * ��������
 * @author chuzhen
 *
 */
public class Cache {

	public static final int MAX_LENGTH = 100;
	public static int id = 0;//����������������ɻ�����id
	
	Item head;	//ͷ���
	int length;	//�������
	
	public static void main(String[] args) {
		final Cache cache = new Cache();
		
		final Timer timer = new Timer();
		System.out.println("ģ����¿�ʼ...");
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				cache.put(id++);
				System.out.println(cache);
				
				if(id > 300) {
					timer.cancel();
				}
			}
		}, 0, 1000);
		
	}
	
	public Cache() {
		System.out.println("��ʼ��50��������...");
		this.head = new Item(0);
		length ++;
		
		Item current = head;
		for(id = 1; id < 50; id++) {
			Item newItem = new Item(id);
			current.next = newItem;
			current = newItem;
			length ++;
		}
		System.out.println(this);
		System.out.println("��ʼ������...");
	}
	
	/**
	 * ������
	 */
	static class Item {
		int id;
		int age;	//���ʱ��
		Item next;	//����������¸�item
		public Item(int id) {
			this.id = id;
		}
		
		@Override
		public String toString() {
			return id + "[age:" + age + "]";
		}
	}
	
	public void put(int id) {
		Item newItem = new Item(id);
		if(this.head == null) {
			System.out.println("��ʼ��ͷ���");
			this.head = newItem;
			length ++;
			return;
		}

		//����λ��
		int insertIndex = new Random().nextInt(length);
		
		boolean deleted = false;//��������ʱ�Ƿ��Ѿ�ִ������̭����
		boolean inserted = false;
		
		Item pre = null;
		Item current = head;
		for(int index = 0; current != null; index++) {
			//1������Ƿ�age����10�������ɾ��һ��
			if(current.age > 10 && !deleted) {
				//1ͷ���
				System.out.println("delete:" + current);
				if(pre == null) {
					this.head = current.next;
				} else {//2���м�ڵ�
					pre.next = current.next;
				}
				current = current.next;
				deleted = true;//�����ɾ��
				//ɾ���󣬽ڵ���������仯
//				if(insertIndex > (length - 1)) {
//					insertIndex = length - 1;
//				}
			}
			//2�����뵽ָ��λ��
			if(index == insertIndex) {
				System.out.println("id:" +id+ ", insertIndex:" + insertIndex);
				if(pre == null) {
					//�޸�ͷָ��
					newItem.next = this.head;
					this.head = newItem;
				} else {
					//pre��current֮�������ָ��
					pre.next = newItem;
					newItem.next = current;
				}
				inserted = true;
			}
			
			if(current == null) {
				break;
			}
//			3��age+1
			current.age ++;
			
			pre = current;
			current = current.next;
		}
		
		//���û��age���ޣ�������������ʱ
		if(!deleted && length >= MAX_LENGTH) {
			//ɾ��ͷ���
			this.head = this.head.next;
			deleted = true;
		}
		
		//����ɾ���������������λ���Ӷ�����û�������ɹ�����׷�ӵ�����ĩβ
		if(!inserted) {
			pre.next = newItem;
		}
		
		//һɾһ��ʱ��length����
		if(!deleted) {
			length ++;
		}
	}
	
	@Override
	public String toString() {
		Item current = head;
		StringBuilder sb = new StringBuilder();
		boolean first = true;
		while(current != null) {
			if(!first) {
				sb.append(", ");
			}
			sb.append(current.toString());
			current = current.next;
			first = false;
		}
		
		return sb.toString();
	}
}
