package com.thiagolvlsantos.gitt.provider;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import com.thiagolvlsantos.gitt.file.EFileStatus;
import com.thiagolvlsantos.gitt.file.FileEvent;
import com.thiagolvlsantos.gitt.file.FileItem;

@Component
public class GitServices {

	private @Autowired ApplicationContext context;
	private @Autowired ApplicationEventPublisher publisher;

	public File readDirectory(String group) {
		return context.getBean(IGitProvider.class).directoryRead(group);
	}

	public File writeDirectory(String group) {
		return context.getBean(IGitProvider.class).directoryWrite(group);
	}

	public void notify(Object source, String group, EFileStatus state, File... files) {
		if (group == null) {
			throw new IllegalArgumentException("Group should be not null.");
		}
		if (state == null) {
			throw new IllegalArgumentException("State should be not null.");
		}
		if (files == null) {
			throw new IllegalArgumentException("Files should be not null.");
		}
		List<FileItem> items = Arrays.asList(files).stream().map(f -> new FileItem(f, state))
				.collect(Collectors.toList());
		publisher.publishEvent(new FileEvent(source, group, items));
	}
}