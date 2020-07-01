/****************************************************************
 * Base Generic Response Class
 * 
 ***************************************************************/
package com.response;
/**
 * @author Remisson dos Santos Silva
 * @since 2020-07-01 01:43
 *
 */
@SuppressWarnings("static-access")
public abstract class GenericBaseResponse
{
	public static final String STATUS_SUCCESS = "SUCCESS";
	public static final String STATUS_FAILURE = "FAILURE";

	protected String status;

	public boolean success()
	{
		return this.status.equalsIgnoreCase(this.STATUS_SUCCESS);
	}

	public boolean fail()
	{
		return this.status.equalsIgnoreCase(this.STATUS_FAILURE);
	}

	public void loadSuccessStatus()
	{
		this.status = this.STATUS_SUCCESS;
	}

	public void loadFailureStatus()
	{
		this.status = this.STATUS_FAILURE;
	}

	public String getStatus()
	{
		return status;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}

	public static GenericResponse appendGenericResponse(
		GenericResponse toReceiveResp,
		GenericResponse toExtractResp)
	{
		for(String c : toExtractResp.getErrorList())
		{
			toReceiveResp.addFailure(c);
		}
		for(String c : toExtractResp.getSuccessList())
		{
			toReceiveResp.addSuccess(c);
		}
		for(String c : toExtractResp.getWarnList())
		{
			toReceiveResp.addWarn(c);
		}
		for(String c : toExtractResp.getInfoList())
		{
			toReceiveResp.addInfo(c);
		}
		toReceiveResp.getParams().putAll(toExtractResp.getParams());
		toReceiveResp.setStatus(toExtractResp.getStatus());
		return toReceiveResp;
	}

	public static GenericResponse appendGenericResponse(
		GenericResponse toReceiveResp,
		GenericSingleOperationResponse toExtractResp)
	{
		for(String c : toExtractResp.getFailureList())
		{
			toReceiveResp.addFailure(c);
		}
		for(String c : toExtractResp.getSuccessList())
		{
			toReceiveResp.addSuccess(c);
		}
		toReceiveResp.getParams().putAll(toExtractResp.getParams());
		toReceiveResp.setStatus(toExtractResp.getStatus());
		return toReceiveResp;
	}

	public static GenericSingleOperationResponse appendGenericResponse(
		GenericSingleOperationResponse toReceiveResp,
		GenericResponse toExtractResp)
	{
		for(String c : toExtractResp.getErrorList())
		{
			toReceiveResp.addFailure(c);
		}
		for(String c : toExtractResp.getSuccessList())
		{
			toReceiveResp.addSuccess(c);
		}
		for(String c : toExtractResp.getWarnList())
		{
			toReceiveResp.addFailure(c);
		}
		for(String c : toExtractResp.getInfoList())
		{
			toReceiveResp.addSuccess(c);
		}
		toReceiveResp.getParams().putAll(toExtractResp.getParams());
		toReceiveResp.setStatus(toExtractResp.getStatus());
		return toReceiveResp;
	}

	public static GenericSingleOperationResponse appendGenericResponse(
		GenericSingleOperationResponse toReceiveResp,
		GenericSingleOperationResponse toExtractResp)
	{
		for(String c : toExtractResp.getFailureList())
		{
			toReceiveResp.addFailure(c);
		}
		for(String c : toExtractResp.getSuccessList())
		{
			toReceiveResp.addSuccess(c);
		}
		toReceiveResp.getParams().putAll(toExtractResp.getParams());
		toReceiveResp.setStatus(toExtractResp.getStatus());
		return toReceiveResp;
	}
}
