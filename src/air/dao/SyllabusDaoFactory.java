package air.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import air.vo.Syllabus;

public class SyllabusDaoFactory {

	private static SyllabusDao syllabusDao = null;
	private static SyllabusDaoFactory syllabusDaoFactory = new SyllabusDaoFactory();

	private SyllabusDaoFactory() {
		Properties properties = new Properties();
		InputStream inputStream = UserDaoFactory.class.getClassLoader().getResourceAsStream("air/config/daoConfig.properties");
		try {
			properties.load(inputStream);
			String SyllabusDaoImpl = properties.getProperty("syllabusDaoImpl");
			syllabusDao = (SyllabusDao) Class.forName(SyllabusDaoImpl).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | IOException e) {
			e.printStackTrace();
		} finally {
			try {
				inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static SyllabusDaoFactory getSyllabusDaoFactory() {
		return syllabusDaoFactory;
	}

	public SyllabusDao getSyllabusDao() {
		return syllabusDao;
	}
}
