package test.datastructure;

import java.util.HashMap;
import java.util.Map;

/**
 * Tries���ݽṹ���ֵ����� ����ֻ���������ʵ��
 * ���ж�ĳ�������Ƿ���ֹ������ʳ���Ƶ���ȣ�������Ҫ����������չ
 * @author chuzhen
 *
 */
public abstract class AbstractTrie {

	/**
	 * �ڲ��ڵ�
	 * @author chuzhen
	 *
	 */
	class TrieNode {
		
		int count;
		char content;
		boolean leaf;//�Ƿ�Ϊ���ʽڵ�
		Map<Character, TrieNode> children;//�ӽڵ�
		
		public TrieNode(char content) {
			this.count = 0;
			this.content = content;
			this.children = new HashMap<Character, TrieNode>();
		}
		
	}
	
	protected TrieNode root;//���ڵ�
	
	public AbstractTrie() {
		root = new TrieNode(' ');
	}
	
	public abstract void insert(String word);
	
	public abstract boolean contain(String word);
	
	public abstract boolean delete(String word);
	
	public abstract void traverse();

}
