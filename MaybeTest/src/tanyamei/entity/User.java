package tanyamei.entity;

public class User {
	private int user_id;
	private String username;
	private String password;
	private int userpower;
	
	public User(){}
	public User(int id,String username,String password,int power){
		this.user_id=id;
		this.username=username;
		this.password=password;
		this.userpower=power;
	}
	public User(String username,String password,int power){
		this.username=username;
		this.password=password;
		this.userpower=power;
	}
	public int getUser_id(){
		return user_id;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public int getUserpower(){
		return userpower;
	}
}
