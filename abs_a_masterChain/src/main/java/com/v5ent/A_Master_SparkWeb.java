package com.v5ent;


import static spark.Spark.port;

import net.matthew.Static_Value;

/**
 * 
 * @author ZJU 经济学院 导师：罗 德 明 作者：朱 逸 清
 * 
 * 
 */

public class A_Master_SparkWeb {
	public static void main(String[] args) {
		port(Static_Value.ABS_A_MASTER_CHAIN_PORT);
		CommonMethod.initial();
	}
}
