package api.testdata;

public class UpdateUser {
	private String accountno;
	private String departmentno;
	private String salary;
	private String pincode;
	private String id;
	private String userid;

	public UpdateUser(String accountno,String departmentno,String salary,String pincode,String userid,String id)
	{
		this.accountno=accountno;
		this.departmentno=departmentno;
		this.salary=salary;
		this.pincode=pincode;
		this.userid=userid;
		this.id=id;
		
	}
	public String getAccountno()
	{
		return accountno;
	}
	public String getDepartmentno()
	{
		return departmentno;
	}
	public String getsalary()
	{
		return salary;
	}
	public String getPincode()
	{
		return pincode;
	}
	public String geUsertid()
	{
		return userid;
	}
	public String getid()
	{
		return id;
	}
	
}
