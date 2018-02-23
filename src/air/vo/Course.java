package air.vo;

public class Course {
	public int getCourse_id() {
		return course_id;
	}

	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}

	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

	public String getCourse_loc() {
		return course_loc;
	}

	public void setCourse_loc(String course_loc) {
		this.course_loc = course_loc;
	}

	private int course_id;
	private String course_name;
	private String course_loc;
	
	public Course() {
		
	}
	
	
}
