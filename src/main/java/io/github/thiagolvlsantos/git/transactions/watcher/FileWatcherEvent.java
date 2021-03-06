package io.github.thiagolvlsantos.git.transactions.watcher;

import java.nio.file.Path;

import org.springframework.context.ApplicationEvent;

import lombok.Getter;

@SuppressWarnings("serial")
@Getter
public class FileWatcherEvent extends ApplicationEvent {

	private EWatcherAction type;
	private String group;
	private transient Path dir;

	public FileWatcherEvent(Object source, EWatcherAction type, String group, Path dir) {
		super(source);
		this.type = type;
		this.group = group;
		this.dir = dir;
	}
}
