package air.vo;

public class Enrollment {
	private int courseId;
	private int userId;
	
	public void setCourseId(int courseId){
		this.courseId=courseId;
	}
	
	public void setUserId(int userId){
		this.userId=userId;
	}
	
	public int getUserId(){
		return userId;
	}
	
	public int getCourseId(){
		return courseId;
	}
	
}
