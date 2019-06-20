package com.v5ent;


import static spark.Spark.port;

import net.matthew.Static_Value;

/**
 * 
 * @author 浙江大学 基于国内市场资产证券化风险事件分析与区块链应用的金融科技设计
 * 
 *
 */

public class A_Master_SparkWeb {
	public static void main(String[] args) {
		port(Static_Value.ABS_A_MASTER_CHAIN_PORT);
		CommonMethod.initial();
	}
}
