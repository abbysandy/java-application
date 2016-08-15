package com.starter.dao;

import javax.mail.MessagingException;

public interface MailDAO {

	public void send(String to, String from, String subject, String text) throws MessagingException;

}
