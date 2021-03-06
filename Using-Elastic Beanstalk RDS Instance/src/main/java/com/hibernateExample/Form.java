package com.hibernateExample;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@Entity
public class Form {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    
    @Column
    private String name;
    
    @Column
    private String address;
    
    @Column
    private String email;
    
    @Column
    private String sig;
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
   
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSig() {
		return sig;
	}
	public void setSig(String sig) {
		this.sig = sig;
	}
}
