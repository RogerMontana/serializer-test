package com.serialization.benchmark.test.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * Created by Artem Karpov
 */
public class ParamsDto implements Serializable {
	private String param1;
	private String param2;
	private String param3;
	private BigDecimal constant = BigDecimal.TEN;
	private BigDecimal constant2 = BigDecimal.ZERO;

	public ParamsDto() {

	}

	public ParamsDto(String param1, String param2, String param3) {
		this.param1 = param1;
		this.param2 = param2;
		this.param3 = param3;
	}

	public String getParam1() {
		return param1;
	}

	public void setParam1(String param1) {
		this.param1 = param1;
	}

	public String getParam2() {
		return param2;
	}

	public void setParam2(String param2) {
		this.param2 = param2;
	}

	public String getParam3() {
		return param3;
	}

	public void setParam3(String param3) {
		this.param3 = param3;
	}

	public BigDecimal getConstant() {
		return constant;
	}

	public BigDecimal getConstant2() {
		return constant2;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof ParamsDto)) {
			return false;
		}
		ParamsDto paramsDto = (ParamsDto) o;
		return Objects.equals(getParam1(), paramsDto.getParam1()) && Objects.equals(getParam2(), paramsDto.getParam2()) && Objects
				.equals(getParam3(), paramsDto.getParam3()) && Objects.equals(getConstant(), paramsDto.getConstant()) && Objects
				.equals(getConstant2(), paramsDto.getConstant2());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getParam1(), getParam2(), getParam3(), getConstant(), getConstant2());
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("ParamsDto{");
		sb.append("param1='").append(param1).append('\'');
		sb.append(", param2='").append(param2).append('\'');
		sb.append(", param3='").append(param3).append('\'');
		sb.append(", constant=").append(constant);
		sb.append(", constant2=").append(constant2);
		sb.append('}');
		return sb.toString();
	}
}