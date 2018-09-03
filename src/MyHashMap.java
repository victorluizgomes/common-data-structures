import java.util.ArrayList;

class Node<K, V> {
	K key;
	V val;
	
	Node<K, V> next;
	
	public Node(K key, V val) {
		this.key = key;
		this.val = val;
	}
}

public class MyHashMap<K, V> {
	
	private ArrayList<Node<K, V>> array;
	private int capacity;
	private int size;
	
	public MyHashMap() {
		array = new ArrayList<Node<K, V>>();
		capacity = 10;
		size = 0;
		
		for(int i = 0; i < capacity; i++) {
			array.add(null);
		}
	}
	
	// TODO: get(K key)
	// 		 remove()
	// Add documentation
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public int size() {
		return size;
	}
	
	private int hash(K key) {
		int hashIndex = key.hashCode() % capacity;
		return hashIndex;
	}
	
	public void add(K key, V val) {
		
		int hashIndex = hash(key);
		Node<K, V> node = array.get(hashIndex);
		
		// Checking for duplicates
		while(node != null) {
			
			if(node.key.equals(key)) {
				node.val = val;
				return;
			}
			node = node.next;
		}
		
		node = array.get(hashIndex);
		Node<K, V> newNode = new Node<K, V>(key, val);
		newNode.next = node;
		array.set(hashIndex, newNode);
		
		size++;
		
		// TODO: add check for increasing the hash table size??
	}
}

