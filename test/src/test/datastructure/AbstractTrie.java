package test.datastructure;

import java.util.HashMap;
import java.util.Map;

/**
 * Tries数据结构（字典树） 这里只是最基本的实现
 * 可判断某个单词是否出现过，单词出现频数等，根据需要可做其它扩展
 * @author chuzhen
 *
 */
public abstract class AbstractTrie {

	/**
	 * 内部节点
	 * @author chuzhen
	 *
	 */
	class TrieNode {
		
		int count;
		char content;
		boolean leaf;//是否为单词节点
		Map<Character, TrieNode> children;//子节点
		
		public TrieNode(char content) {
			this.count = 0;
			this.content = content;
			this.children = new HashMap<Character, TrieNode>();
		}
		
	}
	
	protected TrieNode root;//根节点
	
	public AbstractTrie() {
		root = new TrieNode(' ');
	}
	
	public abstract void insert(String word);
	
	public abstract boolean contain(String word);
	
	public abstract boolean delete(String word);
	
	public abstract void traverse();

}
