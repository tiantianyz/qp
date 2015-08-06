package com.qp.basic.util;

import java.io.IOException;
import java.io.StringWriter;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationModule;

/** 
 * Description 简单封装Jackson，实现JSON String<->Java Object的Mapper
 * 
 * 封装不同的输出风格, 使用不同的builder函数创建实例.  
 * 
 * @author Ding Chengyun
 * @version 1.0
 * @date 2014-11-23
 */
public class JsonUtil {

	private static Logger logger = LoggerFactory.getLogger(JsonUtil.class);
	private static JsonUtil instance = null;
	private ObjectMapper mapper;
	
	private JsonUtil() {
		this(null);
	}

	public JsonUtil(Include include) {
		mapper = new ObjectMapper();
		//设置输出时包含属性的风格
		if (include != null) {
			mapper.setSerializationInclusion(include);
		}
		//设置输入时忽略在JSON字符串中存在但Java对象实际没有的属性
		mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
	}

	/**
	 * 创建只输出非Null且非Empty(如List.isEmpty)的属性到Json字符串的Mapper,建议在外部接口中使用.
	 */
	public static JsonUtil nonEmptyInstance() {
		if (instance == null) {
			instance = new JsonUtil(Include.NON_EMPTY);
		}
		return instance;
//		return new JsonUtil(Include.NON_EMPTY);
	}

	/**
	 * 创建只输出初始值被改变的属性到Json字符串的Mapper, 最节约的存储方式，建议在内部接口中使用。
	 */
	public static JsonUtil nonDefaultInstance() {
		if (instance == null) {
			instance = new JsonUtil(Include.NON_DEFAULT);
		}
		return instance;
//		return new JsonUtil(Include.NON_DEFAULT);
	}

	public static JsonUtil getInstance() {
		if (instance == null) {
			instance = new JsonUtil();
		}
		return instance;
	}
	/**
	 * Object可以是POJO，也可以是Collection或数组。
	 * 如果对象为Null, 返回"null".
	 * 如果集合为空集合, 返回"[]".
	 */
	@SuppressWarnings("deprecation")
	public String toJson(Object object) {

		try {
            StringWriter sw = new StringWriter();
            JsonGenerator gen = new JsonFactory().createJsonGenerator(sw);
            mapper.writeValue(gen, object);
            gen.close();
            return sw.toString();
          //  return mapper.writeValueAsString(object);
		} catch (IOException e) {
			logger.warn("write to json string error:" + object, e);
			return null;
		}
	}

	/**
	 * 反序列化POJO或简单Collection如List<String>.
	 * 
	 * 如果JSON字符串为Null或"null"字符串, 返回Null.
	 * 如果JSON字符串为"[]", 返回空集合.
	 * 
	 * 如需反序列化复杂Collection如List<MyBean>, 请使用fromJson(String,JavaType)
	 * @see #fromJson(String, JavaType)
	 */
	public <T> T fromJson(String jsonString, Class<T> clazz) {
		if (StringUtils.isEmpty(jsonString)) {
			return null;
		}

		try {
			return mapper.readValue(jsonString, clazz);
		} catch (IOException e) {
			logger.warn("parse json string error:" + jsonString, e);
			return null;
		}
	}

	/**
	 * 反序列化复杂Collection如List<Bean>, 先使用函數createCollectionType构造类型,然后调用本函数.
	 * @see #createCollectionType(Class, Class...)
	 */
	@SuppressWarnings("unchecked")
	public <T> T fromJson(String jsonString, JavaType javaType) {
		if (StringUtils.isEmpty(jsonString)) {
			return null;
		}

		try {
			return (T) mapper.readValue(jsonString, javaType);
		} catch (IOException e) {
			logger.warn("parse json string error:" + jsonString, e);
			return null;
		}
	}

	/**
	 * 構造泛型的Collection Type如:
	 * ArrayList<MyBean>, 则调用constructCollectionType(ArrayList.class,MyBean.class)
	 * HashMap<String,MyBean>, 则调用(HashMap.class,String.class, MyBean.class)
	 */
	public JavaType createCollectionType(Class<?> collectionClass, Class<?>... elementClasses) {
		return mapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);
	}

	/**
	 * 當JSON裡只含有Bean的部分屬性時，更新一個已存在Bean，只覆蓋該部分的屬性.
	 */
	@SuppressWarnings("unchecked")
	public <T> T update(String jsonString, T object) {
		try {
			return (T) mapper.readerForUpdating(object).readValue(jsonString);
		} catch (JsonProcessingException e) {
			logger.warn("update json string:" + jsonString + " to object:" + object + " error.", e);
		} catch (IOException e) {
			logger.warn("update json string:" + jsonString + " to object:" + object + " error.", e);
		}
		return null;
	}

	/**
	 * 輸出JSONP格式數據.
	 */
	public String toJsonP(String functionName, Object object) {
		return toJson(new JSONPObject(functionName, object));
	}
	
	/**
	 * json串中根目录下根据key读取对应value
	 * @param json
	 * @param key
	 * @return
	 */
	public String getRootValueByKey(String json, String key) {
		if (StringUtils.isEmpty(json) || StringUtils.isEmpty(key)) {
			return null;
		}
		JsonNode rootNode;
		try {
			rootNode = mapper.readTree(json);
			// path与get作用相同,但是当找不到该节点的时候,返回missing node而不是Null.
			String rootNodeValue =rootNode.get(key).asText();
//			String rootNodeValue = rootNode.path(key).textValue();
			return rootNodeValue;
		} catch (JsonProcessingException e) {
			logger.error("getRootValueByKey error:" + e.getMessage());
			return null;
		} catch (IOException e) {
			logger.error("getRootValueByKey error:" + e.getMessage());
			return null;
		}
	}

	/**
	 * 設定是否使用Enum的toString函數來讀寫Enum,
	 * 為False時時使用Enum的name()函數來讀寫Enum, 默認為False.
	 * 注意本函數一定要在Mapper創建後, 所有的讀寫動作之前調用.
	 */
	public void enableEnumUseToString() {
		mapper.enable(SerializationFeature.WRITE_ENUMS_USING_TO_STRING);
		mapper.enable(DeserializationFeature.READ_ENUMS_USING_TO_STRING);
	}

	/**
	 * 支持使用Jaxb的Annotation，使得POJO上的annotation不用与Jackson耦合。
	 * 默认会先查找jaxb的annotation，如果找不到再找jackson的。
	 */
	public void enableJaxbAnnotation() {
		JaxbAnnotationModule module = new JaxbAnnotationModule();
		mapper.registerModule(module);
	}

	/**
	 * 取出Mapper做进一步的设置或使用其他序列化API.
	 */
	public ObjectMapper getMapper() {
		return mapper;
	}
	
	public static void main(String[] args) throws JsonProcessingException, IOException {
		String GENERIC_BINDING = "{\"key1\":{\"name\":\"name2\",\"type\":2},\"key2\":{\"name\":\"name3\",\"type\":3}}";
		String TREE_MODEL_BINDING = "{\"treekey1\":\"treevalue1\",\"treekey2\":\"treevalue2\",\"children\":[{\"childkey1\":\"childkey1\"}]}";
		ObjectMapper mapper = new ObjectMapper();
		JsonNode rootNode = mapper.readTree(TREE_MODEL_BINDING);
		// path与get作用相同,但是当找不到该节点的时候,返回missing node而不是Null.
		String treekey2value = rootNode.path("treekey2").textValue();
		System.out.println("treekey2value:" + treekey2value);
		JsonNode childrenNode = rootNode.path("children");
		String childkey1Value = childrenNode.get(0).path("childkey1")
				.textValue();
		System.out.println("childkey1Value:" + childkey1Value);

		// 创建根节点
		ObjectNode root = mapper.createObjectNode();
		// 创建子节点1
		ObjectNode node1 = mapper.createObjectNode();
		node1.put("nodekey1", 1);
		node1.put("nodekey2", 2);
		// 绑定子节点1
		root.put("child", node1);
		// 数组节点
		ArrayNode arrayNode = mapper.createArrayNode();
		arrayNode.add(node1);
		arrayNode.add(1);
		// 绑定数组节点
		root.put("arraynode", arrayNode);
		// JSON读到树节点
		JsonNode valueToTreeNode = mapper.valueToTree(TREE_MODEL_BINDING);
		// 绑定JSON节点
		root.put("valuetotreenode", valueToTreeNode);
		// JSON绑定到JSON节点对象
		JsonNode bindJsonNode = mapper.readValue(GENERIC_BINDING,
				JsonNode.class);// 绑定JSON到JSON节点对象.
		// 绑定JSON节点
		root.put("bindJsonNode", bindJsonNode);
		System.out.println(mapper.writeValueAsString(root));
	}
}
