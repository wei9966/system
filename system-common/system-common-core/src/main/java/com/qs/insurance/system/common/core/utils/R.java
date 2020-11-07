package com.qs.insurance.system.common.core.utils;

import com.qs.insurance.system.common.core.constant.CommonConstants;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 响应信息主体
 *
 * @param <T>
 * @author jhy
 */
@Builder
@ToString
@Accessors(chain = true)
@AllArgsConstructor
public class R<T> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Getter
	@Setter
	private int code = CommonConstants.SUCCESS;

	@Getter
	@Setter
	private String msg = "操作成功";


	@Getter
	@Setter
	private T data;

	public R() {
		super();
	}

	public R(T data) {
		super();
		this.data = data;
	}

	public R(T data, String msg) {
		super();
		this.data = data;
		this.msg = msg;
	}

	public R success(T data, String msg) {
		return R.builder().code(CommonConstants.SUCCESS).data(data).msg(msg).build();
	}

	public R success(T data) {
		return R.builder().code(CommonConstants.SUCCESS).data(data).msg("操作成功").build();
	}

	public R wxSuccess(T data, String msg) {
		return R.builder().code(CommonConstants.WX_SUCCESS).data(data).msg(msg).build();
	}

	public R wxSuccess(T data) {
		return R.builder().code(CommonConstants.SUCCESS).data(data).msg("操作成功").build();
	}

	public R error(String msg) {
		return this.error(null, msg);
	}

	public R error(T data, String msg) {
		return R.builder().code(CommonConstants.FAIL).data(data).msg("操作失败：" + msg).build();
	}
	public R wxError(String msg) {
		return this.error(null, msg);
	}
	public R wxError(T data, String msg) {
		return R.builder().code(CommonConstants.WX_FAIL).data(data).msg("操作失败：" + msg).build();
	}

	public R(Throwable e) {
		super();
		this.msg = e.getMessage();
		this.code = CommonConstants.FAIL;
	}
}
