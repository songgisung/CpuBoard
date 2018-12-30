package board.vo;

import java.util.Date;

public class Board {
	
	//boardbase
	private int idx;
	private String name;
	private String pass;
	private String subject;
	private String content;
	private int readCount;
	private Date wdate; 
	private String filePath;
	private String [] filename = new String[2];;	

	
	//cpu base
	private String enterprise;
	private String cpuName;
	private String socket;
	private String speed;
	private int core;
	private int thread;
	private String graphis;

	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getReadCount() {
		return readCount;
	}
	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}
	public Date getWdate() {
		return wdate;
	}
	public void setWdate(Date wdate) {
		this.wdate = wdate;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	//==============================
	public String getFileName(int num) {
		return this.filename[num];
	}
	public void setFileName(int num,String fileName) {
		this.filename[num] = fileName;
	}
	//============================

	public String getEnterprise() {
		return enterprise;
	}
	public void setEnterprise(String enterprise) {
		this.enterprise = enterprise;
	}
	public String getCpuName() {
		return cpuName;
	}
	public void setCpuName(String cpuName) {
		this.cpuName = cpuName;
	}
	public String getSocket() {
		return socket;
	}
	public void setSocket(String socket) {
		this.socket = socket;
	}
	public String getSpeed() {
		return speed;
	}
	public void setSpeed(String speed) {
		this.speed = speed;
	}
	public int getCore() {
		return core;
	}
	public void setCore(int core) {
		this.core = core;
	}
	public int getThread() {
		return thread;
	}
	public void setThread(int thread) {
		this.thread = thread;
	}
	public String getGraphis() {
		return graphis;
	}
	public void setGraphis(String graphis) {
		this.graphis = graphis;
	}


	
}
