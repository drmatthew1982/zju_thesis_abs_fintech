package com.v5ent;


import static spark.Spark.port;

import net.matthew.Static_Value;

/**
 * 
 * @author 浙江大学 朱逸清 
 * @see 基于国内市场资产证券化风险事件分析与区块链应用的金融科技设计 导师：罗德明 作者：朱逸清 
 * 
 *
 */
public class A_CDO_SparkWeb {
	public static void main(String[] args) {
		port(Static_Value.ABS_A_CDO_CHAIN_PORT);
		CommonMethod.initial();
	}
}
