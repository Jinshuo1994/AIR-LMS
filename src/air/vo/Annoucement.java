package air.vo;

public class Annoucement {
	private int anncId;
	private String anncTitle;
	private String annc;
	private int courseId;
	private boolean anncPublish;
	
	public void setAnncId(int anncId){
		this.anncId=anncId;
	}
	
	public void setAnncTitle(String title){
		this.anncTitle=title;
	}
	
	public void setAnnc(String annc){
		this.annc=annc;
	}
	
	public void setCourseId(int courseId){
		this.courseId=courseId;
	}
	
	public void setCoursePublish(Boolean anncPublish){
		this.anncPublish=anncPublish;
	}
	
	public int getAnncId(){
		return anncId;
	}
	
	public String getAnncTitle(){
		return anncTitle;
	}
	
	public String getAnnc(){
		return annc;
	}
	
	public int getCourseId(){
		return courseId;
	}
	
	public Boolean getAnncPublish(){
		return anncPublish;
	}
}
