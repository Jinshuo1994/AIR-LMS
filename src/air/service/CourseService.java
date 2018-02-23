package air.service;
import java.util.ArrayList;
import air.dao.DaoFactory;
import air.dao.CourseDao;
import air.vo.Course;

public class CourseService {
CourseDao courseDao = DaoFactory.getCourseDaoInstance();

    private boolean checkCourseExists(Course course) {
	int courseId = course.getCourse_id();
	return courseDao.checkCourseExits(courseId);
    }
	
    

    public void createCourse(Course course) {
    	String courseName = course.getCourse_name();
    	int courseId = course.getCourse_id();
    	String courseLoc = course.getCourse_loc();
    	courseDao.create(courseId, courseName, courseLoc);
		
	}
	
	public ArrayList<ArrayList> getCourseList() {
		
		return courseDao.getCourseList();
		
	}
	
	public boolean deleteCourse(Course course) {	
		if(checkCourseExists(course)) {
		int courseId = course.getCourse_id();
		return courseDao.delete(courseId);	
		}
		return false;
		
	}
	

}
