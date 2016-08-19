package com.starter.service.impl;

import java.io.StringWriter;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.starter.service.MailService;

@Service
public class MailServiceImpl implements MailService {

	@Autowired
	private JavaMailSender	javaMailSender;

	@Autowired
	private VelocityEngine	velocityEngine;

	@Override
	public void send(String to, String from, String subject, String text) throws MessagingException {
		MimeMessage mail = this.javaMailSender.createMimeMessage();
		mail.setContent(text, "text/html");

		MimeMessageHelper helper = new MimeMessageHelper(mail, false, "utf-8");
		helper.setFrom(from);
		helper.setTo(to);
		helper.setSubject(subject);

		this.javaMailSender.send(mail);
	}

	@Override
	public void send(String to, String from, String subject, String file, VelocityContext ctx) throws MessagingException {
		Template template = this.velocityEngine.getTemplate(file);
		StringWriter output = new StringWriter();
		template.merge(ctx, output);

		this.send(to, from, subject, output.toString());

	}

}
