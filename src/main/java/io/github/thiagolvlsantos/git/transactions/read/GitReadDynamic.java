package io.github.thiagolvlsantos.git.transactions.read;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@SuppressWarnings("serial")
public class GitReadDynamic implements Serializable {

	@Builder.Default
	private String value = "";

	@Builder.Default
	private GitReadDirDynamic[] values = new GitReadDirDynamic[0];

	public String value() {
		return getValue();
	}

	public GitReadDirDynamic[] values() {
		return getValues();
	}
}