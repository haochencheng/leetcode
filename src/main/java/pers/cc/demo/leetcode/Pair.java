package pers.cc.demo.leetcode;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @description:
 * @author: haochencheng
 * @create: 2018-12-08 17:16
 **/
@Data
public class Pair<K, V> {

    K key;
    V value;

    public Pair(){

    }

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}
