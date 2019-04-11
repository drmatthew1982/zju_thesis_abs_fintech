package com.v5ent;

import static spark.Spark.get;
import static spark.Spark.post;

import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.binary.StringUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.v5ent.entity.Block;
import com.v5ent.entity.Message;

import net.matthew.Static_Value;
import spark.Request;
import spark.Response;
import spark.Route;

public class CommonMethod {
	private static final Logger LOGGER = LoggerFactory.getLogger(CommonMethod.class);
	private static List<Block> blockChain = new LinkedList<Block>();

	/**
	 * 计算区块的hash值
	 * 
	 * @param block
	 *            区块
	 * @return
	 */
	public static String calculateHash(Block block) {
		String record = (block.getIndex()) + block.getTimestamp() + (block.getVac()) + block.getPrevHash();
		MessageDigest digest = DigestUtils.getSha256Digest();
		byte[] hash = digest.digest(StringUtils.getBytesUtf8(record));
		return  Hex.encodeHexString(hash);
	}

	/**
	 * 区块的生成
	 * 
	 * @param oldBlock
	 * @param vac
	 * @return
	 */
	public static Block generateBlock(Block oldBlock, String vac) {
		Block newBlock = new Block();
		newBlock.setIndex(oldBlock.getIndex() + 1);
		newBlock.setTimestamp(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		newBlock.setVac(vac);
		newBlock.setPrevHash(oldBlock.getHash());
		newBlock.setHash(calculateHash(newBlock));
		return newBlock;
	}

	/**
	 * 校验区块的合法性（有效性）
	 * 
	 * @param newBlock
	 * @param oldBlock
	 * @return
	 */
	public static boolean isBlockValid(Block newBlock, Block oldBlock) {
		if (oldBlock.getIndex() + 1 != newBlock.getIndex()) {
			return false;
		}
		if (!oldBlock.getHash().equals(newBlock.getPrevHash())) {
			return false;
		}
		if (!calculateHash(newBlock).equals(newBlock.getHash())) {
			return false;
		}
		return true;
	}

	/**
	 * 如果有别的链比你长，就用比你长的链作为区块链
	 * 
	 * @param oldBlocks
	 * @param newBlocks
	 * @return 结果链
	 */
	public List<Block> replaceChain(List<Block> oldBlocks,List<Block> newBlocks) {
		if (newBlocks.size() > oldBlocks.size()) {
			return newBlocks;
		}else{
			return oldBlocks;
		}
	}
	
	public static void initial() {
		//创世块
		Block genesisBlock = new Block();
		genesisBlock.setIndex(0);
		genesisBlock.setTimestamp(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		genesisBlock.setVac("0");
		genesisBlock.setPrevHash("");
		genesisBlock.setHash(calculateHash(genesisBlock));
		blockChain.add(genesisBlock);

		final Gson gson = new GsonBuilder().setPrettyPrinting().create();
		/**
		 * get /
		 */
		get("/"+Static_Value.ABS_GET_DEFAULT_METHOD, new Route() {
			@Override
			public Object handle(Request request, Response response) throws Exception {
				response.header("content-type","application/json");
				return gson.toJson(blockChain);
			}
		}); 
		get("/"+Static_Value.ABS_GET_ALL_METHOD, new Route() {
			@Override
			public Object handle(Request request, Response response) throws Exception {
				response.header("content-type","application/json");
				return gson.toJson(blockChain);
			}
		}); 
		
		get("/"+Static_Value.ABS_GET_LAST_METHOD, new Route() {
			@Override
			public Object handle(Request request, Response response) throws Exception {
				response.header("content-type","application/json");
				return gson.toJson(blockChain.get(blockChain.size()-1));
			}
		}); 
		get("/"+Static_Value.ABS_GET_BY_INDEX_METHOD+":index", new Route() {
			@Override
			public Object handle(Request request, Response response) throws Exception {
				response.header("content-type","application/json");
				String index=request.params(":index");
				try {
					int int_index=Integer.parseInt(index);
					if(blockChain.size()>0&&blockChain.size()>=int_index) {
						return gson.toJson(blockChain.get(int_index-1));
					}else {
						return "{\"response\":\"index exceeded\"}";
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return "{\"response\":\"error, unknow error\"}";
				}
			}
		}); 

		/***
		 * post / {"vac":75}
		 */
		post("/"+Static_Value.ABS_DEFAULT_POST_METHOD, new Route() {
			@Override
			public Object handle(Request request, Response response) throws Exception {
					response.header("content-type","application/json");
					String body = request.body();
					Message m = gson.fromJson(body, Message.class);
					if (m == null) {
						return "{\"response\":\"vac is NULL\"}";
					}
					String vac = m.getVac();
					Block lastBlock = blockChain.get(blockChain.size() - 1);
					Block newBlock = generateBlock(lastBlock, vac);
					if (isBlockValid(newBlock, lastBlock)) {
						blockChain.add(newBlock);
						LOGGER.debug(gson.toJson(blockChain));
					} else {
						return "{\"response\":\"HTTP 500: Invalid Block Error\"}";
					}
					return  "{\"response\":\"success!\"}";
			}
		});
		
		LOGGER.info(gson.toJson(blockChain));
	}
	
	
}
