package com.v5ent;


import static spark.Spark.port;

import net.matthew.Static_Value;

public class A_Bankrecord_SparkWeb {
	public static void main(String[] args) {
		port(Static_Value.ABS_A_BANK_CHAIN_PORT);
		CommonMethod.initial();
	}
}