package test.zingfront;

import java.util.ArrayList;
import java.util.List;

/**
 * �����
 * @author chuzhen
 *
 */
public class MultiwayTree {

	/**
	 * ���ڵ����
	 * @author chuzhen
	 */
	static class Node {
		String value;
		List<Node> children;
		
		public Node(String value) {
			this.value = value;
			this.children = new ArrayList<Node>();
		}
		public Node(String value, List<Node> children) {
			this.value = value;
			this.children = children;
		}
		public boolean addChild(Node child) {
			if(child == this) {
				throw new IllegalArgumentException("Ŀ���ӽڵ�͸��ڵ���ͬ");
			}
			//TODO ��������ظ��ڵ�
			return children.add(child);
		}
		@Override
		public String toString() {
			return value/* + "(" + children.size() + ")"*/;
		}
	}
	
	/**
	 * ���ڵ�
	 */
	Node root;
	
	public MultiwayTree(Node root) {
		this.root = root;
	}

	/**
	 * �����·��
	 * @param start
	 * @param end
	 */
	public void showPath(String start, String end) {
		if(root == null) {
			return;
		}
		
		List<Node> startPath = search(root, start);
		List<Node> endPath = search(root, end);
		int limit = Math.min(startPath.size(), endPath.size());
		//��������������ڵ�����
		int parentIndex = 0;
		for(int index = limit - 1; index >= 0; index--) {
			Node startNode = startPath.get(index);
			Node endNode = endPath.get(index);
			
			if(startNode == endNode) {
				parentIndex = index;
				break;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		boolean first = true;
		for(int startIndex = startPath.size()-1; startIndex >= parentIndex; startIndex--) {
			if(!first) {
				sb.append("->");
			}
			sb.append(startPath.get(startIndex));
			first = false;
		}
		for(int endIndex = parentIndex+1; endIndex < endPath.size(); endIndex++) {
			sb.append("->").append(endPath.get(endIndex));
		}
		
		System.out.println(sb.toString());
	}
	
	/**
	 * ���Ҵ�ָ���ڵ㵽Ŀ��ڵ��·��
	 * @param startNode
	 * @param target
	 * @return
	 */
	private List<Node> search(Node startNode, String target) {
		if(startNode == null) {
			return null;
		}
		
		List<Node> path = new ArrayList<Node>();
		path.add(startNode);
		
		List<Node> children = startNode.children;
		for(int index = 0; index < children.size(); index++) {
			Node child = children.get(index);
			if(child.value.equals(target)) {
				path.add(child);
				break;
			} else {
				List<Node> subPath = search(child, target);
				if(subPath == null || subPath.size() < 2) {
//					path.remove(path.size() - 1);
				} else {
					path.addAll(subPath);
					break;
				}
			}
		}
		
		return path;
	}
	
	public static void main(String[] args) {
		Node root = new Node("A");
		Node B = new Node("B");
		Node C = new Node("C");
		Node D = new Node("D");
		root.addChild(B);
		root.addChild(C);
		root.addChild(D);
		
		Node E = new Node("E");
		Node F = new Node("F");
		Node G = new Node("G");
		B.addChild(E);
		B.addChild(F);
		B.addChild(G);
		
		Node H = new Node("H");
		Node I = new Node("I");
		Node J = new Node("J");
		D.addChild(H);
		D.addChild(I);
		D.addChild(J);
		
		Node K = new Node("K");
		Node L = new Node("L");
		Node N = new Node("N");
		F.addChild(K);
		F.addChild(L);
		F.addChild(N);
		
		Node O = new Node("O");
		Node P = new Node("P");
		Node Q = new Node("Q");
		H.addChild(O);
		H.addChild(P);
		H.addChild(Q);
		
		Node R = new Node("R");
		Node S = new Node("S");
		Node T = new Node("T");
		N.addChild(R);
		N.addChild(S);
		N.addChild(T);
		
		//Ϊ�˲��Խ��ֱ�ۣ�ֱ�ӹ����˺�������һ�������ṹ
		MultiwayTree multiwayTree = new MultiwayTree(root);
		
		multiwayTree.showPath("G", "R");
	}
}
