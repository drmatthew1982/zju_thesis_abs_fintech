package com.v5ent;


import static spark.Spark.port;

import net.matthew.Static_Value;
/**
 * 
 * @author 浙 江 大 学 经济学院 导师：罗 德 明 作者：朱 逸 清
 * @see 基于国内市场资产证券化风险事件分析与区块链应用的金融科技设计
 * 
 *
 */
public class A_Rank_SparkWeb {
	public static void main(String[] args) {
		port(Static_Value.ABS_A_RANK_CHAIN_PORT);
		CommonMethod.initial();
	}
}
