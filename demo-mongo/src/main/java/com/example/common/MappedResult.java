package com.example.common;

import lombok.Data;

@Data
public class MappedResult<K, V> {
    K id;
    V value;
}
