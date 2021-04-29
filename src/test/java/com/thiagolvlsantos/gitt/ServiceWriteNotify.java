package com.thiagolvlsantos.gitt;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.thiagolvlsantos.gitt.file.EFileStatus;
import com.thiagolvlsantos.gitt.provider.GitServices;
import com.thiagolvlsantos.gitt.write.GitWrite;

@Component
public class ServiceWriteNotify {

	private static final String GITT_EXAMPLE_PROJECTS = "projects";

	private @Autowired GitServices services;

	@GitWrite(value = GITT_EXAMPLE_PROJECTS, watcher = false)
	public void write() throws IOException {
		File directory = services.writeDirectory(GITT_EXAMPLE_PROJECTS);
		System.out.println("...writeProjects..." + directory);
		File file = new File(directory, "projectA.txt");
		FileOutputStream out = new FileOutputStream(file);
		out.write(("{\"name\": \"projectA\", date: \"" + LocalDateTime.now() + "\"}").getBytes());
		out.close();
		for (File f : directory.listFiles()) {
			System.out.println(f.getName());
		}
		services.notify(this, GITT_EXAMPLE_PROJECTS, EFileStatus.CREATE, file);
	}
}