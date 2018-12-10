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
}
