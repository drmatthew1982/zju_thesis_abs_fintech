package net.matthew.app.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.GsonFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import io.netty.handler.codec.http.HttpContentEncoder.Result;

import net.matthew.Static_Value;
import net.matthew.app.data.ABS;
import net.matthew.app.data.CDO;
import net.matthew.app.data.CDOs;

import com.v5ent.entity.Block;
import com.v5ent.entity.ReturnLatest;
import com.v5ent.entity.WrappedChain;
/**
 * 
 * @author  浙江大学 导师：罗德明 作者：朱逸清
 * @see 基于国内市场资产证券化风险事件分析与区块链应用的金融科技设计
 *
 */
@Controller
public class ServerController {
	public static final String API_URL_ADDRANKBLOCK = "http://localhost:8080/addRankBlock";

	private final Logger logger = LoggerFactory.getLogger(getClass());

	private static Block errorblock = Block.createErrorBlock();
	
	final Gson gson = new GsonBuilder().setPrettyPrinting().create();

	private static ABS RETURNED_ABS;
	private static CDO RETURNED_CDO;
	private static CDOs RETURNED_CDOS;

	ABS getAbs() {
		if (RETURNED_ABS == null) {
			RETURNED_ABS = new ABS();
			RETURNED_ABS.setName("abs_a");
			RETURNED_ABS.setLink(Static_Value.HTTP + Static_Value.ABS_A_MASTER_CHAIN_DOMAIN + ":8082");

			CDO cdo = new CDO();
			cdo.setName("CDO_A");
			cdo.setLink(Static_Value.HTTP + Static_Value.ABS_A_MASTER_CHAIN_DOMAIN + ":8082/adminview");
			RETURNED_ABS.setCdo(cdo);

			CDOs cdos = new CDOs();
			cdos.setName("CDOs_A");
			cdos.setLink(Static_Value.HTTP+Static_Value.ABS_A_MASTER_CHAIN_DOMAIN+":8082/adminview");
			RETURNED_ABS.setCdos(cdos);
		}
		return RETURNED_ABS;
	}

	CDO getCDO() {
		if (RETURNED_CDO == null) {
			RETURNED_CDO = new CDO();
			RETURNED_CDO.setName("CDO_A");
			RETURNED_CDO.setLink(Static_Value.HTTP + Static_Value.ABS_A_MASTER_CHAIN_DOMAIN + ":8082/adminview");

			ABS abs = new ABS();
			abs.setName("abs_a");
			abs.setLink(Static_Value.HTTP + Static_Value.ABS_A_MASTER_CHAIN_DOMAIN + ":8082");

			ABS faked_ABS_B = new ABS();
			faked_ABS_B.setName("faked_ABS_B");

			ABS faked_ABS_C = new ABS();
			faked_ABS_C.setName("faked_ABS_C");

			HashMap absmap = new HashMap();
			absmap.put("abs_a", abs);
			absmap.put("faked_ABS_B", faked_ABS_B);
			absmap.put("faked_ABS_C", faked_ABS_C);
			RETURNED_CDO.setAbs(absmap);
			CDOs CDOs = new CDOs();
			CDOs.setName("CDOs_A");
			CDOs.setLink(Static_Value.HTTP+Static_Value.ABS_A_MASTER_CHAIN_DOMAIN+":8082/adminview");
			RETURNED_CDO.setCdos(CDOs);
		}
		return RETURNED_CDO;
	}

	CDOs getCdos() {
		if (RETURNED_CDOS == null) {
			RETURNED_CDOS = new CDOs();
			RETURNED_CDOS.setName("CDOs_A");
			RETURNED_CDOS.setLink(Static_Value.HTTP+Static_Value.ABS_A_MASTER_CHAIN_DOMAIN+":8082/adminview");
			
			ABS abs = new ABS();
			abs.setName("abs_a");
			abs.setLink(Static_Value.HTTP + Static_Value.ABS_A_MASTER_CHAIN_DOMAIN + ":8082");

			ABS faked_ABS_B = new ABS();
			faked_ABS_B.setName("faked_ABS_B");

			ABS faked_ABS_C = new ABS();
			faked_ABS_C.setName("faked_ABS_C");

			HashMap<String,ABS> absmap = new HashMap<String,ABS>();
			absmap.put("abs_a", abs);
			absmap.put("faked_ABS_B", faked_ABS_B);
			absmap.put("faked_ABS_C", faked_ABS_C);
			
			CDO cdo = new CDO();
			cdo.setName("CDO_A");
			cdo.setLink(Static_Value.HTTP + Static_Value.ABS_A_MASTER_CHAIN_DOMAIN + ":8082/cdo");
			cdo.setAbs(absmap);
			
			ABS faked_ABS_D = new ABS();
			faked_ABS_D.setName("faked_ABS_D");
			ABS faked_ABS_E = new ABS();
			faked_ABS_E.setName("faked_ABS_E");
			HashMap<String,ABS> other_absmap = new HashMap<String,ABS>();
			other_absmap.put("faked_ABS_D", faked_ABS_D);
			other_absmap.put("faked_ABS_E", faked_ABS_E);
			CDO faked_cdo_B = new CDO();
			faked_cdo_B.setName("Faked_CDO_B");
			faked_cdo_B.setAbs(other_absmap);
			
			HashMap<String, CDO> cdomap=new HashMap<String, CDO>();
			cdomap.put("CDO_A", cdo);
			cdomap.put("Faked_CDO_B", faked_cdo_B);
			RETURNED_CDOS.setCdo(cdomap);
		}
		return RETURNED_CDOS;
	}

	@RequestMapping("/")
	@ResponseBody
	String home() {
		return "API Server";
	}

	@RequestMapping("/getAll")
	@ResponseBody
	String getAllBlock(HttpServletRequest request) {
		boolean isAdmin = false;
		// String productCode = request.getParameter("productCode");
		String user = request.getParameter("user");
		if (user != null && "admin".equals(user)) {
			isAdmin = true;
		}

		String type = request.getParameter("type");
		List<Block> chain = getAllBlock(type, isAdmin);
		WrappedChain wrappedChain = new WrappedChain();
		if (type.equals(Static_Value.TYPE_CDO)) {
			wrappedChain.setCdo(getCDO());
		}
		if (type.equals(Static_Value.TYPE_CDOS)) {
			wrappedChain.setCdos(getCdos());
		}
		wrappedChain.setChain(chain);
		return gson.toJson(wrappedChain);

	}

	List<Block> getAllBlock(String type, boolean isAdmin) {
		String url = getUrl(type);
		int port = getPort(type);
		List<Block> chain = getAllValue(Static_Value.HTTP + url, port, Static_Value.ABS_GET_ALL_METHOD, isAdmin);
		return chain;

	}

	@RequestMapping("/addBlock")
	@ResponseBody
	String addBlock(HttpServletRequest request, HttpServletResponse response) {
		String productCode = request.getParameter("productCode");
		String url = Static_Value.ABS_A_MASTER_CHAIN_DOMAIN;
		int port = Static_Value.ABS_A_MASTER_CHAIN_PORT;
		if (productCode == null || "".equals(productCode.trim())) {
			productCode = "a";
		}
		String type = request.getParameter("type");
		url = getUrl(type);
		port = getPort(type);
		String vac = request.getParameter("vac");
		String name = request.getParameter("user");
		Block returnBlock = getPostValue(Static_Value.HTTP + url, port, Static_Value.ABS_DEFAULT_POST_METHOD, vac,
				name);
		// logger.info("Add type===:"+type);
		if (type != null && (type.equals(Static_Value.TYPE_CAPITAL) || type.equals(Static_Value.TYPE_REPUTATION))) {
			String value = caculatedValue(request, response);
			// logger.info("Add value===:"+value);
			getPostValue(Static_Value.HTTP + Static_Value.ABS_A_VALUE_CHAIN_DOMAIN, Static_Value.ABS_A_VALUE_CHAIN_PORT,
					Static_Value.ABS_DEFAULT_POST_METHOD, value, "AUTO_UPDATE");
		}
		return gson.toJson(returnBlock);
	}
	
	@RequestMapping("/addRankBlock")
	@ResponseBody
	String addRankBlock(HttpServletRequest request, HttpServletResponse response) {
		HttpPost httpPost = null;
		String productCode = request.getParameter("productCode");
		String url = Static_Value.ABS_A_MASTER_CHAIN_DOMAIN;
		int port = Static_Value.ABS_A_MASTER_CHAIN_PORT;
		if (productCode == null || "".equals(productCode.trim())) {
			productCode = "a";
		}
		String type = request.getParameter("type");
		url = getUrl(type);
		port = getPort(type);
		String vac = request.getParameter("vac");
		String name = request.getParameter("user");
		String rank = request.getParameter("rank");
		Block returnBlock = getPostValue(Static_Value.HTTP + url, port, Static_Value.ABS_DEFAULT_POST_METHOD, vac,
				name);
		// logger.info("Add type===:"+type);
		if (type != null && (type.equals(Static_Value.TYPE_RANK))) {
			String value = "Rank: "+rank+ ", Because ABS: ABS_"+productCode.toUpperCase()+" ranked as " +rank;
			// logger.info("Add value===:"+value);
			try {
				addRankBlock( httpPost,  "AUTO_UPDATED", Static_Value.TYPE_CDO, value, rank,productCode);
			} catch (URISyntaxException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return gson.toJson(returnBlock);
	}

	@RequestMapping("/caculateValue")
	@ResponseBody
	String caculatedValue(HttpServletRequest request, HttpServletResponse response) {
		String latestValue = getLatest(request, response);
		ReturnLatest returnObject = gson.fromJson(latestValue, ReturnLatest.class);
		Block captialBlock = returnObject.getCapital();
		Block reputationBlock = returnObject.getReputation();
		int captivalValue = letterToNumber(captialBlock.getVac());
		// logger.info("===captial"+captivalValue);
		int reputationValue = letterToNumber(reputationBlock.getVac());
		// logger.info("===reputationValue"+reputationValue);
		BigDecimal resultValue = BigDecimal.valueOf(captivalValue * 0.7).add(BigDecimal.valueOf(reputationValue * 0.3));
		return String.valueOf(resultValue);
	}
	
	private int getPort(String type) {
		int port = Static_Value.ABS_A_MASTER_CHAIN_PORT;
		if (type == null || "".equals(type.trim())) {
			port = Static_Value.ABS_A_MASTER_CHAIN_PORT;
		}
		if (Static_Value.TYPE_CAPITAL.equals(type)) {
			port = Static_Value.ABS_A_CAPITAL_CHAIN_PORT;
		}
		if (Static_Value.TYPE_REPUTATION.equals(type)) {
			port = Static_Value.ABS_A_REPUTATIONL_CHAIN_PORT;
		}
		if (Static_Value.TYPE_VALUE.equals(type)) {
			port = Static_Value.ABS_A_VALUE_CHAIN_PORT;
		}
		if (Static_Value.TYPE_BANK.equals(type)) {
			port = Static_Value.ABS_A_BANK_CHAIN_PORT;
		}
		if (Static_Value.TYPE_RANK.equals(type)) {
			port = Static_Value.ABS_A_RANK_CHAIN_PORT;
		}
		if (Static_Value.TYPE_CDO.equals(type)) {
			port = Static_Value.ABS_A_CDO_CHAIN_PORT;
		}
		if (Static_Value.TYPE_CDOS.equals(type)) {
			port = Static_Value.ABS_A_CDOS_CHAIN_PORT;
		}
		return port;
	}

	private String getUrl(String type) {
		String url = Static_Value.ABS_A_MASTER_CHAIN_DOMAIN;
		if (type == null || "".equals(type.trim())) {
			url = Static_Value.ABS_A_MASTER_CHAIN_DOMAIN;
		}
		if (Static_Value.TYPE_CAPITAL.equals(type)) {
			url = Static_Value.ABS_A_CAPITAL_CHAIN_DOMAIN;
		}
		if (Static_Value.TYPE_REPUTATION.equals(type)) {
			url = Static_Value.ABS_A_REPUTATION_CHAIN_DOMAIN;
		}
		if (Static_Value.TYPE_VALUE.equals(type)) {
			url = Static_Value.ABS_A_VALUE_CHAIN_DOMAIN;
		}
		if (Static_Value.TYPE_BANK.equals(type)) {
			url = Static_Value.ABS_A_BANK_CHAIN_DOMAIN;
		}
		if (Static_Value.TYPE_RANK.equals(type)) {
			url = Static_Value.ABS_A_RANK_CHAIN_DOMAIN;
		}
		if (Static_Value.TYPE_CDO.equals(type)) {
			url = Static_Value.ABS_A_CDO_CHAIN_DOMAIN;
		}
		if (Static_Value.TYPE_CDOS.equals(type)) {
			url = Static_Value.ABS_A_CDOS_CHAIN_DOMAIN;
		}
		return url;
	}

	@RequestMapping("/getlatest")
	@ResponseBody
	String getLatest(HttpServletRequest request, HttpServletResponse response) {
		boolean isAdmin = false;
		boolean isTransferToWrongAccount = false;
		String productCode = request.getParameter("productCode");
		String user = request.getParameter("user");
		if (user != null && "admin".equals(user)) {
			isAdmin = true;
		}
		response.addHeader("content-type", "application/json");
		ReturnLatest returnObject = new ReturnLatest();
		if (productCode == null || "".equals(productCode.trim())) {
			productCode = "a";
		}
		if ("a".equals(productCode)) {
			Block productCaptialBlock = getGetValue(Static_Value.HTTP + Static_Value.ABS_A_CAPITAL_CHAIN_DOMAIN,
					Static_Value.ABS_A_CAPITAL_CHAIN_PORT, Static_Value.ABS_GET_LAST_METHOD, isAdmin);
			Block productReputationBlock = getGetValue(Static_Value.HTTP + Static_Value.ABS_A_REPUTATION_CHAIN_DOMAIN,
					Static_Value.ABS_A_REPUTATIONL_CHAIN_PORT, Static_Value.ABS_GET_LAST_METHOD, isAdmin);
			Block valueBlock = getGetValue(Static_Value.HTTP + Static_Value.ABS_A_VALUE_CHAIN_DOMAIN,
					Static_Value.ABS_A_VALUE_CHAIN_PORT, Static_Value.ABS_GET_LAST_METHOD, isAdmin);
			Block bankBlock = getGetValue(Static_Value.HTTP + Static_Value.ABS_A_BANK_CHAIN_DOMAIN,
					Static_Value.ABS_A_BANK_CHAIN_PORT, Static_Value.ABS_GET_LAST_METHOD, isAdmin);
			Block rankBlock = getGetValue(Static_Value.HTTP + Static_Value.ABS_A_RANK_CHAIN_DOMAIN,
					Static_Value.ABS_A_RANK_CHAIN_PORT, Static_Value.ABS_GET_LAST_METHOD, isAdmin);
			List<Block> chain = getAllBlock(Static_Value.TYPE_BANK, isAdmin);
			for (Block block : chain) {
				String vac = block.getVac();
				if (vac.startsWith("Out") && !vac.endsWith("10000")) {
					bankBlock.setComments("Wrong Transaction is detected.");
					isTransferToWrongAccount = true;
					break;
				}
			}
			// logger.info("======:"+productCaptialBlock.toString());
			returnObject.setCode(productCode);
			returnObject.setCapital(productCaptialBlock);
			returnObject.setReputation(productReputationBlock);
			returnObject.setValue(valueBlock);
			returnObject.setBank(bankBlock);
			returnObject.setRank(rankBlock);
			returnObject.setTransferToWrongAccount(isTransferToWrongAccount);
			returnObject.setAbs(getAbs());
			// returnObject.set
		}
		return gson.toJson(returnObject);
	}

	synchronized Block getGetValue(String url, int port, String method, boolean isAdmin) {
		HttpGet httpGet = new HttpGet(url + ":" + port + "/" + method);
		try {
			DefaultHttpClient client = new DefaultHttpClient();
			HttpResponse response = client.execute(httpGet);
			response.addHeader("content-type", "application/json");
			HttpEntity entity = response.getEntity();
			String string = EntityUtils.toString(entity);
			Block returnBlock = gson.fromJson(string, Block.class);
			boolean illegalContent = false;
			int index = -1;
			String hash = "";
			if (!isAdmin) {
				if (returnBlock.getVac().contains("illegalContent")) {
					illegalContent = true;
					index = returnBlock.getIndex();
					hash = returnBlock.getHash();
					returnBlock = getGetValue(url, port,
							Static_Value.ABS_GET_BY_INDEX_METHOD + "/" + (returnBlock.getIndex()), isAdmin);

				}
				if (illegalContent) {
					returnBlock.setComments(
							"The content you visit is has illegalContent in the latestblock, so we show older one to you.\n"
									+ "Please contact Admin to fix it, \n the index is " + index
									+ ", \n nand the hash code is \n" + hash);
				}
			}
			return returnBlock;
		} catch (ClientProtocolException e) {
			e.printStackTrace();
			return errorblock;
		} catch (IOException e) {
			e.printStackTrace();
			return errorblock;
		} finally {
			if (httpGet != null) {
				httpGet.releaseConnection();
			}
		}

	}

	List<Block> getAllValue(String url, int port, String method, boolean isAdmin) {
		HttpGet httpGet = new HttpGet(url + ":" + port + "/" + method);
		try {
			//logger.info("==:"+url+"=="+port);
			DefaultHttpClient client = new DefaultHttpClient();
			HttpResponse response = client.execute(httpGet);
			response.addHeader("content-type", "application/json");
			HttpEntity entity = response.getEntity();
			String string = EntityUtils.toString(entity);
			List<Block> returnChain = gson.fromJson(string, new TypeToken<List<Block>>() {
			}.getType());
			boolean illegalContent = false;
			int index = -1;
			String hash = "";

			return returnChain;
		} catch (ClientProtocolException e) {
			e.printStackTrace();
			return new LinkedList<Block>();
		} catch (IOException e) {
			e.printStackTrace();
			return new LinkedList<Block>();
		} finally {
			if (httpGet != null) {
				httpGet.releaseConnection();
			}
		}
	}

	Block getPostValue(String url, int port, String method, String vac, String name) {
		HttpPost httpPost = new HttpPost(url + ":" + port + "/" + method);
		JSONObject jsonParam = new JSONObject();
		jsonParam.put("vac", vac);
		jsonParam.put("user", name);
		StringEntity postEntity = new StringEntity(jsonParam.toString(), "utf-8");// 解决中文乱码问题
		postEntity.setContentEncoding("UTF-8");
		postEntity.setContentType("application/json");
		httpPost.setEntity(postEntity);
		// httpPost.setEntity(postEntity);
		try {
			DefaultHttpClient client = new DefaultHttpClient();
			HttpResponse response = client.execute(httpPost);
			response.addHeader("content-type", "application/json");
			HttpEntity entity = response.getEntity();
			String string = EntityUtils.toString(entity);
			Block returnBlock = gson.fromJson(string, Block.class);
			return returnBlock;
		} catch (ClientProtocolException e) {

			e.printStackTrace();
			return errorblock;
		} catch (IOException e) {

			e.printStackTrace();
			return errorblock;
		} finally {
			if (httpPost != null) {
				httpPost.releaseConnection();
			}
		}

	}
	String addRankBlock(HttpPost httpPost, String username, String type, String vac, String rank,String productCode )
			throws URISyntaxException, ClientProtocolException, IOException {
		URIBuilder uriBuilder = new URIBuilder(API_URL_ADDRANKBLOCK);
		List<NameValuePair> list = new LinkedList<>();
		BasicNameValuePair param1 = new BasicNameValuePair("user", username);
		BasicNameValuePair param2 = new BasicNameValuePair("type", type);
		BasicNameValuePair param3 = new BasicNameValuePair("vac", vac);
		BasicNameValuePair param4 = new BasicNameValuePair("rank", rank);
		list.add(param1);
		list.add(param2);
		list.add(param3);
		list.add(param4);
		uriBuilder.addParameters(list);
		httpPost = new HttpPost(uriBuilder.build());
		DefaultHttpClient client = new DefaultHttpClient();
		HttpResponse response = client.execute(httpPost);
		response.addHeader("content-type", "application/json");
		HttpEntity entity = response.getEntity();
		if(Static_Value.TYPE_CDO.equals(type)) {
			String value = "Rank: "+rank+ ", Because CDO: CDO_"+productCode.toUpperCase()+" ranked as " +rank;
			addRankBlock(new HttpPost(API_URL_ADDRANKBLOCK), username,Static_Value.TYPE_CDOS, value, rank,productCode);
		}
		httpPost.releaseConnection();
		return EntityUtils.toString(entity);
	}

	private int letterToNumber(String letter) {
		int length = letter.length();
		int num = 0;
		int number = 0;
		for (int i = 0; i < length; i++) {
			char ch = letter.charAt(length - i - 1);
			num = (int) (ch - 'A' + 1);
			num *= Math.pow(26, i);
			number += num;
		}
		return number;
	}

}