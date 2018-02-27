package com.serialization.benchmark.test.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * Created by Artem Karpov
 */
public final class ProgrammingLangDTO implements Serializable {

	private String name;
	private String type;
	private String designedBy;

	public ProgrammingLangDTO(String name, String type, String designedBy) {
		this.name = name;
		this.type = type;
		this.designedBy = designedBy;
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public String getDesignedBy() {
		return designedBy;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof ProgrammingLangDTO)) {
			return false;
		}
		ProgrammingLangDTO that = (ProgrammingLangDTO) o;
		return Objects.equals(getName(), that.getName()) && Objects.equals(getType(), that.getType()) && Objects
				.equals(getDesignedBy(), that.getDesignedBy());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getName(), getType(), getDesignedBy());
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("ProgrammingLangDTO{");
		sb.append("name='").append(name).append('\'');
		sb.append(", type='").append(type).append('\'');
		sb.append(", designedBy='").append(designedBy).append('\'');
		sb.append('}');
		return sb.toString();
	}
}
