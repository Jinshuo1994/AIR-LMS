package air.dao;

public interface SyllabusDao {
	public String getSyllabusType(int courseID);
	public String getSyllabusContent(int courseID);
	public void delete(int courseID);
	public void editSyllabus(int courseID, boolean published);
	public void create(String syllabus, int courseID, String type, boolean published);
	public boolean checkSyllabusExists(int courseID);
	void editSyllabus(int courseID, String content);
}
