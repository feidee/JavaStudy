package org.andy.song;

import java.util.List;

public class Message {

	private List<Double> geo;
	private long id;
	private String text;
	private User user;

	public Message() {
	}

	@Override
	public String toString() {
		return "{\"id\":" + this.id + ", \"text\": \"" + this.text
				+ "\", \"geo\":"
				+ ((this.geo == null) ? "[]" : this.geo.toString())
				+ ",\"user\": " + this.user.toString() + "}";
	}

	/**
	 * @param id
	 * @param text
	 * @param geo
	 * @param user
	 */
	public Message(long id, String text, User user, List<Double> geo) {
		super();
		this.id = id;
		this.text = text;
		this.geo = geo;
		this.user = user;
	}

	public List<Double> getGeo() {
		return geo;
	}

	public long getId() {
		return id;
	}

	public String getText() {
		return text;
	}

	public User getUser() {
		return user;
	}

	public void setGeo(List<Double> geo) {
		this.geo = geo;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setText(String text) {
		this.text = text;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
