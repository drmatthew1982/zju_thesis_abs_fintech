package com.v5ent;


import static spark.Spark.port;

import net.matthew.Static_Value;
/**
 * 
 * @author matthew.yiqing.zhu/朱 逸 清 浙 江 大 学
 * 
 *
 */
public class A_Rank_SparkWeb {
	public static void main(String[] args) {
		port(Static_Value.ABS_A_RANK_CHAIN_PORT);
		CommonMethod.initial();
	}
}
