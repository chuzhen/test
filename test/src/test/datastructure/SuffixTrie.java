package test.datastructure;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 后缀树
 * @author chuzhen
 *
 */
public class SuffixTrie extends AbstractTrie {

	public SuffixTrie() {
		super();
	}
	
	@Override
	public void insert(String word) {
		root.count ++;
		
		TrieNode current = root;
		word = word.trim();
		
		char[] charArray = word.toCharArray();
		for(int i = charArray.length-1; i >= 0; i--) {
			char element = charArray[i];
			Map<Character, TrieNode> currentChildren = current.children;
			if(!currentChildren.containsKey(element)) {
				currentChildren.put(element, new TrieNode(element));
			}
			current = currentChildren.get(element);
			current.count ++;
		}
		
		current.leaf = true;
	}
	
	@Override
	public boolean contain(String word) {
		TrieNode current = root;
		
		char[] charArray = word.toCharArray();
		for(int i = charArray.length-1; i >= 0; i--) {
			char element = charArray[i];
			Map<Character, TrieNode> children = current.children;
			current = children.get(element);
			if(current == null)
				return false;
		}
		
		return current.leaf;
	}
	
	public boolean containSuffix(String preffix) {
		TrieNode current = root;
		
		char[] charArray = preffix.toCharArray();
		for(int i = charArray.length-1; i >= 0; i--) {
			char element = charArray[i];
			Map<Character, TrieNode> children = current.children;
			current = children.get(element);
			if(current == null)
				return false;
		}
		
		return true;
	}
	
	@Override
	public boolean delete(String word) {
		//从某节点（key）中移除指定key（value）的子节点
		Map<TrieNode, Character> toDelete = new HashMap<TrieNode, Character>();
		
		TrieNode current = root;
		
		char[] charArray = word.toCharArray();
		for(int i = charArray.length-1; i >= 0; i--) {
			char element = charArray[i];
			toDelete.put(current, element);
			
			Map<Character, TrieNode> children = current.children;
			current = children.get(element);
			if(current == null)
				return false;
		}
		
		if(current.leaf) {
			for(Entry<TrieNode, Character> entry:toDelete.entrySet()) {
				TrieNode parent = entry.getKey();
				parent.count --;
				parent.children.remove(entry.getValue());
			}
			return true;
		}
		
		return false;
	}
	
	@Override
	public void traverse() {
		StringBuffer wordBuffer = new StringBuffer();
		traverse(root, wordBuffer);
	}

	private void traverse(TrieNode node, StringBuffer wordBuffer) {
		Map<Character, TrieNode> children = node.children;
		for(Entry<Character, TrieNode> entry:children.entrySet()) {
			wordBuffer.insert(0, entry.getKey());
			TrieNode value = entry.getValue();
			if(value.leaf) {
				System.out.println(wordBuffer + "：" + value.count);
			} else {
				traverse(value, wordBuffer);
			}
			wordBuffer.deleteCharAt(0);
		}
	}
	
	public static void main(String[] args) {
		SuffixTrie trie = new SuffixTrie();
		trie.insert("chuzhen");
		trie.insert("lvbin");
		trie.insert("zhangjie");
		trie.insert("liweiii");
		trie.insert("liweiii");
		trie.insert("liweiii");
		trie.insert("chenjianbin");
		
		boolean contain = trie.contain("liweiii");
		System.out.println(contain);
		
//		trie.delete("zhangjie");

		contain = trie.contain("zhangjie");
		System.out.println(contain);
		
		System.out.println("containSuffix：" + trie.containSuffix("zhen"));
		
		trie.traverse();
	
	}
}
