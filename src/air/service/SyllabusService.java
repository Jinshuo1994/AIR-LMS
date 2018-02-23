package air.service;

import air.dao.DaoFactory;
import air.dao.SyllabusDao;
import air.dao.UserDao;
import air.vo.Syllabus;

public class SyllabusService {
	
	SyllabusDao syllabusDao = DaoFactory.getSyllabusDaoInstance();
	private boolean checkSyllabusExists(int courseID) {
		syllabusDao.checkSyllabusExists(courseID);
		return false;
		
	}

	public void uploadSyllabus(Syllabus syllabus) {
		
	}

	public void deleteSyllabus(int courseID) {
		syllabusDao.delete(courseID);
	}

	public String getSyllabusType(int courseID) {
		return syllabusDao.getSyllabusType(courseID);
	}

	public String getSyllabusContent(int courseID) {
		return syllabusDao.getSyllabusContent(courseID);
	}

	public void createSyllabus(Syllabus syllabus, int courseID) {
		String syllabusContent = syllabus.getSyllabus();
		String type = syllabus.getType();
		boolean published = syllabus.isPublished();
		syllabusDao.create(syllabusContent, courseID, type, published);
	}
	
	public void editSyllabus(Syllabus syllabus, int courseID) {
		String content = syllabus.getSyllabus();
		syllabusDao.editSyllabus(courseID, content);
	}

	public void publishSyllabus(int courseID) {
		syllabusDao.editSyllabus(courseID, true);
	}

	public void unpublishSyllabus(int courseID) {
		syllabusDao.editSyllabus(courseID, false);
	}
}
