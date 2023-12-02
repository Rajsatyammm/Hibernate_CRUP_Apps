package com.satyam.Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ProjectInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "pId")
	private Integer pId;

	@Column(name = "pgmId")
	private String pgmId;

	public ProjectInfo(Integer pId, String pgmId) {
		super();
		this.pId = pId;
		this.pgmId = pgmId;
	}

}
