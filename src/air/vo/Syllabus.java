package air.vo;

public class Syllabus {
	public int getSyllabusID() {
		return syllabusID;
	}
	public void setSyllabusID(int syllabusID) {
		this.syllabusID = syllabusID;
	}
	public String getSyllabus() {
		return syllabus;
	}
	public void setSyllabus(String syllabus) {
		this.syllabus = syllabus;
	}
	public int getCourseID() {
		return courseID;
	}
	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public boolean isPublished() {
		return published;
	}
	public void setPublished(boolean published) {
		this.published = published;
	}
	private int syllabusID;
	private String syllabus;
	private int courseID;
	private String type;
	private boolean published;
	
}
