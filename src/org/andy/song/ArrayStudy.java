package org.andy.song;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;

public class ArrayStudy {

	/**
	 * 
	 */
	public ArrayStudy() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String args0[]) {
		
		 testArrays();
		// testJsonJar();
		// testJsonReader();
		// testSimpleGson();
		// testMultiGson();
		testMultiGson1();

	}

	private static void testArrays() {
		String[] arrayString = { "andy", "song" };
		System.out.println(Arrays.toString(arrayString));
		System.out.println(Arrays.asList(arrayString).toString());
		System.out.println(Arrays.asList(arrayString).size());
		System.out.println(Arrays.asList(arrayString).contains("andy"));
	}

	// 用json.jar
	private static void testJsonJar() {
		String simpleJson = "{\"username\":\"andysong\", \"password\":\"123456\"}";
		JSONObject object;
		try {
			object = (JSONObject) new JSONTokener(simpleJson).nextValue();
			System.out.println(object.getString("username"));
			System.out.println(object.getString("password"));
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	// 用gson.jar
	private static void testJsonReader() {
		String jsonData = "[{\"username\":\"arthinking\",\"userId\":001},{\"username\":\"Jason\",\"userId\":002}]";
		try {
			JsonReader reader = new JsonReader(new StringReader(jsonData));
			reader.beginArray();
			while (reader.hasNext()) {
				reader.beginObject();
				while (reader.hasNext()) {
					String tagName = reader.nextName();
					if (tagName.equals("username")) {
						System.out.println(reader.nextString());
					} else if (tagName.equals("userId")) {
						System.out.println(reader.nextString());
					}
				}
				reader.endObject();
			}
			reader.endArray();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void testSimpleGson() {
		// 如果要处理的JSON字符串只包含一个JSON对象，则可以直接使用fromJson获取一个User对象：
		String simpleJson = "{\"username\":\"andysong\", \"password\":\"123456\"}";
		Gson gson = new Gson();
		UserInfo userInfo = gson.fromJson(simpleJson, UserInfo.class);
		System.out.println(userInfo.getUsername());
		System.out.println(userInfo.getPassword());
	}

	private static void testMultiGson() {
		String multiJson = "[{\"username\":\"song\", \"password\":\"123456\"},{\"username\":\"andy\", \"password\":\"456789\"}]";

		Type listType = new TypeToken<LinkedList<UserInfo>>() {
		}.getType();
		Gson gson = new Gson();
		LinkedList<UserInfo> userInfos = gson.fromJson(multiJson, listType);

		for (Iterator<UserInfo> iterator = userInfos.iterator(); iterator
				.hasNext();) {
			UserInfo userInfo = iterator.next();
			System.out.println(userInfo.getUsername());
			System.out.println(userInfo.getPassword());
		}
	}

	private static void testMultiGson1() {
		String multiJson = "[{\"id\":912345678901,\"text\":\"How do I read a JSON stream in Java?\",\"geo\":null,\"user\":{\"name\":\"json_newb\",\"followers_count\":41}},{\"id\":912345678902,\"text\":\"@json_newb just use JsonReader!\",\"geo\":[50.454722,-104.606667],\"user\":{\"name\":\"jesse\",\"followers_count\":2}}]";
		InputStream ins = null;
		try {
			ins = new ByteArrayInputStream(multiJson.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			List<Message> msg = new ArrayStudy().readJsonStream(ins);
			System.out.println(msg.size());
			System.out.println(msg.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Message> readJsonStream(InputStream in) throws IOException {
		JsonReader reader = new JsonReader(new InputStreamReader(in, "UTF-8"));
		try {
			return readMessagesArray(reader);
		} finally {
			reader.close();
		}
	}

	public List<Message> readMessagesArray(JsonReader reader)
			throws IOException {
		List<Message> messages = new ArrayList<Message>();

		reader.beginArray();
		while (reader.hasNext()) {
			messages.add(readMessage(reader));
		}
		reader.endArray();
		return messages;
	}

	public Message readMessage(JsonReader reader) throws IOException {
		long id = -1;
		String text = null;
		User user = null;
		List<Double> geo = null;

		reader.beginObject();
		while (reader.hasNext()) {
			String name = reader.nextName();
			if (name.equals("id")) {
				id = reader.nextLong();
			} else if (name.equals("text")) {
				text = reader.nextString();
			} else if (name.equals("geo") && reader.peek() != JsonToken.NULL) {
				geo = readDoublesArray(reader);
			} else if (name.equals("user")) {
				user = readUser(reader);
			} else {
				reader.skipValue();
			}
		}
		reader.endObject();
		return new Message(id, text, user, geo);
	}

	public List<Double> readDoublesArray(JsonReader reader) throws IOException {
		List<Double> doubles = new ArrayList<Double>();

		reader.beginArray();
		while (reader.hasNext()) {
			doubles.add(reader.nextDouble());
		}
		reader.endArray();
		return doubles;
	}

	public User readUser(JsonReader reader) throws IOException {
		String username = null;
		int followersCount = -1;

		reader.beginObject();
		while (reader.hasNext()) {
			String name = reader.nextName();
			if (name.equals("name")) {
				username = reader.nextString();
			} else if (name.equals("followers_count")) {
				followersCount = reader.nextInt();
			} else {
				reader.skipValue();
			}
		}
		reader.endObject();
		return new User(username, followersCount);
	}

}
