package com.v5ent;


import static spark.Spark.port;

import net.matthew.Static_Value;

/**
 * 
 * @author matthew.yiqing.zhu/朱逸清 ZJU
 * 
 *
 */
public class A_Value_SparkWeb {
	public static void main(String[] args) {
		port(Static_Value.ABS_A_VALUE_CHAIN_PORT);
		CommonMethod.initial();
	}
}
