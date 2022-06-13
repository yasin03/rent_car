package com.backend.rentcar.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name="fies")
public class FileDB {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name="uuid", strategy = "uuid2")
	private String id;  //automatically generated as UUID
	
	private String name; // name of the file
	
	private String type; // mime type
	
	@JsonIgnore
	@Lob // datatype for storing large object data
	private byte[] data; // array of bytes, map to a BLOB (BLOB is for storing binary data)

	public FileDB(String name, String type, byte[] data) {
		super();
		this.name = name;
		this.type = type;
		this.data = data;
	}
	
	
	
}
