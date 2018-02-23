package air.dao;
import java.sql.ResultSet;
import java.util.ArrayList;

public interface CourseDao {
	public void create(int courseId, String courseName, String courseLoc);
	public ArrayList<ArrayList> getCourseList();
	public boolean delete(int courseID);
	public boolean checkCourseExits(int courseID);


}
