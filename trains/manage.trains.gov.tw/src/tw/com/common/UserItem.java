package tw.com.common;

public class UserItem {
	private String Id;
	private String UserName;
	private String UserKey;
	private String password1;
	private String permission;

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getUserKey() {
		return UserKey;
	}

	public void setUserKey(String userKey) {
		UserKey = userKey;
	}

	public String getPassword1() {
		return password1;
	}

	public void setPassword1(String password1) {
		this.password1 = password1;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	public static void main(String[] args) {

	}

}
