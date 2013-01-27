package com.autohouse.domain;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="body")
public class Body_VouchakIM implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="BODY_ID", unique=true, nullable=false)
	private int bodyId;

	@Column(name="BODY_NAME", length=20)
	private String bodyName;

    public Body_VouchakIM() {
    }

	public int getBodyId() {
		return this.bodyId;
	}

	public void setBodyId(int bodyId) {
		this.bodyId = bodyId;
	}

	public String getBodyName() {
		return this.bodyName;
	}

	public void setBodyName(String bodyName) {
		this.bodyName = bodyName;
	}
}