package com.sunbeam;

public class Marks {
String subject;
int marks;
public Marks(String subject, int marks) {
	super();
	this.subject = subject;
	this.marks = marks;
}
public String getSubject() {
	return subject;
}
public void setSubject(String subject) {
	this.subject = subject;
}
public int getMarks() {
	return marks;
}
public void setMarks(int marks) {
	this.marks = marks;
}
@Override
public String toString() {
	return "Marks [subject=" + subject + ", marks=" + marks + "]";
}


	
	
}
