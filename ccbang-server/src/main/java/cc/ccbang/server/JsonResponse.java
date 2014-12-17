package cc.ccbang.server;

public class JsonResponse {
	
	private String state;
	
	private Object data;
	
	public JsonResponse(String state, Object data) {
		this.state = state;
		this.data = data;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
	

}
