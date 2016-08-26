package com.starter.service;

import java.util.Map;

import javax.mail.MessagingException;

public interface MailService {

	public void send(String to, String from, String subject, String text) throws MessagingException;

	public void send(String to, String from, String subject, String template, Map<String, String> data);

}
