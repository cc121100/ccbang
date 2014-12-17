package cc.ccbang.base.model;

import org.apache.ibatis.type.Alias;

//@Alias("User")
public class User extends BaseModel {

	private String id;
	private String name;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
