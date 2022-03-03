package com.poc.logger.entity;

import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "loggertable")
public class LoggerEntity {
	@Id
	private String logId;

	@CreatedDate
	private Date logDate;

	private String logData;

	public LoggerEntity(String logId, Date logDate, String logData) {
		super();
		this.logId = logId;
		this.logDate = logDate;
		this.logData = logData;
	}

	public LoggerEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getLogId() {
		return logId;
	}

	public void setLogId(String logId) {
		this.logId = logId;
	}

	public Date getLogDate() {
		return logDate;
	}

	public void setLogDate(Date logDate) {
		this.logDate = logDate;
	}

	public String getLogData() {
		return logData;
	}

	public void setLogData(String logData) {
		this.logData = logData;
	}

}
