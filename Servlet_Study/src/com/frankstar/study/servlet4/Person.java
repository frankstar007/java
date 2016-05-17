/**
 * 
 */
package com.frankstar.study.servlet4;

/**
 * @author frankstar
 * 设计一个可以被别的对象监听的对象
 * Person类作为事件源 这个类的对象的行为可以被其他对象监听到
 */
public class Person {
	//定义一个PersonListener监听器 记住传递进来的监听器
	private PersonListener listener;
	
	public void eat() {
		if (listener != null) {
			listener.doeat(new Event(this));
		}
	}
	
	public void run() {
		if (listener != null) {
			listener.dorun(new Event(this));
		}
	}
	
	public void registerListener(PersonListener listener) {
		this.listener = listener;
	}
}
interface PersonListener {

	void doeat(Event event);
	
	void dorun(Event event);
	
}
class Event {
	private Person person;
	public Event() {}
	public Event(Person person) {
		this.person = person;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
}
