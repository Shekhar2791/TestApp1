package com.ex.runner;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="my.app")
public class ConfigurationProps_ValueEx implements CommandLineRunner{

	//@Value("${myid}")
	private int id;
	//@Value("${myname}")
	private String name;
	
	public ConfigurationProps_ValueEx() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ConfigurationProps_ValueEx(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

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

	@Override
	public String toString() {
		return "ConfigurationProps_ValueEx [id=" + id + ", name=" + name + "]";
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("COnfiguration Properties");
		System.out.println(this);
	}
	
	
}
