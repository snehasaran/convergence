package beans;

/**
 * Bean class for Post table
 * @author marri.r
 *
 */
public class Post {
	private int id;
	private int groupId;
	private String post;
	private int personId;
	private int likes;
	private boolean endorse;
	public boolean isEndorse() {
		return endorse;
	}
	public void setEndorse(boolean endorse) {
		this.endorse = endorse;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public int getPersonId() {
		return personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
	}
	public int getLikes() {
		return likes;
	}
	public void setLikes(int likes) {
		this.likes = likes;
	}
}
