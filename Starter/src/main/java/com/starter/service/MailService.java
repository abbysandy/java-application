package com.starter.service;

import javax.mail.MessagingException;

import org.apache.velocity.VelocityContext;

public interface MailService {

	public void send(String to, String from, String subject, String text) throws MessagingException;

	public void send(String to, String from, String subject, String template, VelocityContext ctx) throws MessagingException;

}
