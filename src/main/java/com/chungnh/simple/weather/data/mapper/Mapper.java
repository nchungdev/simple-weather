/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.chungnh.simple.weather.data.mapper;

import org.json.simple.JSONObject;

/**
 * @author chungnh
 */
public interface Mapper<T> {
    T fromJSON(JSONObject jo);

    String toJSON(T t);
}
