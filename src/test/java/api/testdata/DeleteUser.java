package api.testdata;

public class DeleteUser {
	private String id;
	private String userid;
	
	public DeleteUser(String id,String userid)
	{
		this.id=id;
		this.userid=userid;
	}
	public String getId()
	{
		return id;
	}
	public String getUserId()
	{
		return userid;
	}

}
