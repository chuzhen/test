package test.zingfront;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 缓存容器
 * @author chuzhen
 *
 */
public class Cache {

	public static final int MAX_LENGTH = 100;
	public static int id = 0;//方便起见，用于生成缓存项id
	
	Item head;	//头结点
	int length;	//缓存个数
	
	public static void main(String[] args) {
		final Cache cache = new Cache();
		
		final Timer timer = new Timer();
		System.out.println("模拟更新开始...");
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
		System.out.println("初始化50个缓存项...");
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
		System.out.println("初始化结束...");
	}
	
	/**
	 * 缓存项
	 */
	static class Item {
		int id;
		int age;	//存活时间
		Item next;	//单向链表的下个item
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
			System.out.println("初始化头结点");
			this.head = newItem;
			length ++;
			return;
		}

		//插入位置
		int insertIndex = new Random().nextInt(length);
		
		boolean deleted = false;//增加年龄时是否已经执行了淘汰操作
		boolean inserted = false;
		
		Item pre = null;
		Item current = head;
		for(int index = 0; current != null; index++) {
			//1、检查是否age大于10，如果有删除一个
			if(current.age > 10 && !deleted) {
				//1头结点
				System.out.println("delete:" + current);
				if(pre == null) {
					this.head = current.next;
				} else {//2、中间节点
					pre.next = current.next;
				}
				current = current.next;
				deleted = true;//标记已删除
				//删除后，节点个数发生变化
//				if(insertIndex > (length - 1)) {
//					insertIndex = length - 1;
//				}
			}
			//2、插入到指定位置
			if(index == insertIndex) {
				System.out.println("id:" +id+ ", insertIndex:" + insertIndex);
				if(pre == null) {
					//修改头指针
					newItem.next = this.head;
					this.head = newItem;
				} else {
					//pre和current之间插入新指针
					pre.next = newItem;
					newItem.next = current;
				}
				inserted = true;
			}
			
			if(current == null) {
				break;
			}
//			3、age+1
			current.age ++;
			
			pre = current;
			current = current.next;
		}
		
		//如果没有age超限，但是容器已满时
		if(!deleted && length >= MAX_LENGTH) {
			//删除头结点
			this.head = this.head.next;
			deleted = true;
		}
		
		//由于删除操作造成索引错位，从而导致没有新增成功，则追加到链表末尾
		if(!inserted) {
			pre.next = newItem;
		}
		
		//一删一增时，length不变
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
