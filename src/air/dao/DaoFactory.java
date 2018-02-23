package air.dao;

public class DaoFactory {
	public static UserDao getUserDaoInstance() {
		UserDaoFactory userDaoFactory = UserDaoFactory.getUserDaoFactory();
		return userDaoFactory.getUserDao();
	}
	
	/*public static SyllabusDao getSyllabusDaoInstance() {
		return null;
	} */
	
	public static AnncDao getAnncDaoInstance() {
		return new AnncDao();
	}
	
	public static EnrollmentDao getEnrollmentDao(){
		return new EnrollmentDao();
	}
	
	public static CourseDao getCourseDaoInstance(){
		return new CourseDaoImpl();
	}
	
	public static SyllabusDao getSyllabusDaoInstance() {
		SyllabusDaoFactory syllabusDaoFactory = SyllabusDaoFactory.getSyllabusDaoFactory();
		return syllabusDaoFactory.getSyllabusDao();
	}

}
