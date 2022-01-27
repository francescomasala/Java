package it.tn.buonarroti.masala.quarta.GenericTypes.Example;

import lombok.Getter;
import lombok.Setter;

public class OrderedPair<K, V> implements Pair<K, V> {
	@Getter
	@Setter
	private K key;
	@Getter
	@Setter
	private V value;

	public OrderedPair(K key, V value) {
		this.key = key;
		this.value = value;
	}
	@Override
	public K getKey() { return key; }
	@Override
	public V getValue() { return value; }
}