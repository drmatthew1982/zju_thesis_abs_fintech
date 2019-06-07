package com.v5ent;


import static spark.Spark.port;

import net.matthew.Static_Value;

/**
 * 
 * @author matthew.yiqing.zhu/朱逸清-浙江大学
 * 
 *
 */
public class A_CDO_SparkWeb {
	public static void main(String[] args) {
		port(Static_Value.ABS_A_CDO_CHAIN_PORT);
		CommonMethod.initial();
	}
}
