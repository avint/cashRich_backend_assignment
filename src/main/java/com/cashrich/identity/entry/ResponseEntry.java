package com.cashrich.identity.entry;

import lombok.Data;

@Data
public class ResponseEntry<T> {
    T data;
    StatusEntry statusEntry;
}
