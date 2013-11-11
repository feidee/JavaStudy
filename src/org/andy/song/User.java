package org.andy.song;

public class User {
	private String name;
	private int followers_count;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @param name
	 * @param followers_count
	 */
	public User(String name, int followers_count) {
		super();
		this.name = name;
		this.followers_count = followers_count;
	}
	public int getFollowers_count() {
		return followers_count;
	}
	public void setFollowers_count(int followers_count) {
		this.followers_count = followers_count;
	}
	
	@Override
	public String toString() {
		return "{\"name\":\""+this.name+"\",\"followers_count\":"+this.followers_count+"}";
	}
}
