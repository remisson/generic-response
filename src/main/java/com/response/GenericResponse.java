/****************************************************************
 * Response (String) based. Returns 'success', 'info', 'warn'
 * and 'error' lists.
 ***************************************************************/
package com.response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Remisson dos Santos Silva
 * @since 2020-07-01 01:43
 *
 */
public class GenericResponse extends GenericBaseResponse
{
	private Map<String,Object> params;

	private List<String> successList;
	private List<String> errorList;
	private List<String> infoList;
	private List<String> warnList;

	public GenericResponse()
	{
		status = "";

		this.params = new HashMap<String,Object>();

		this.successList = new ArrayList<String>();
		this.errorList   = new ArrayList<String>();
		this.infoList	= new ArrayList<String>();
		this.warnList	= new ArrayList<String>();
	}

	public void addParam(String key,Object value)
	{
		this.params.put(key, value);
	}

	public Object selectParam(String key)
	{
		return this.params.get(key);
	}

	public List<String> getSuccessList()
	{
		return successList;
	}

	public void setSuccessList(List<String> successList)
	{
		this.successList = successList;
	}

	public List<String> getErrorList()
	{
		return errorList;
	}

	public void setErrorList(List<String> errorList)
	{
		this.errorList = errorList;
	}

	public List<String> getInfoList()
	{
		return infoList;
	}

	public void setInfoList(List<String> infoList)
	{
		this.infoList = infoList;
	}

	public List<String> getWarnList()
	{
		return warnList;
	}

	public void setWarnList(List<String> warnList)
	{
		this.warnList = warnList;
	}

	public Map<String, Object> getParams()
	{
		return params;
	}

	public void setParams(Map<String, Object> params)
	{
		this.params = params;
	}

	public String getFirstSuccessMessage()
	{
		if(this.successList == null || this.successList.isEmpty())
			return null;
		return this.successList.get(0);
	}
	
	public String getFirstInfoMessage()
	{
		if(this.infoList == null || this.infoList.isEmpty())
			return null;
		return this.infoList.get(0);
	}
	
	public String getFirstWarnMessage()
	{
		if(this.warnList == null || this.warnList.isEmpty())
			return null;
		return this.warnList.get(0);
	}
	
	public String getFirstErrorMessage()
	{
		if(this.errorList == null || this.errorList.isEmpty())
			return null;
		return this.errorList.get(0);
	}

	public void addFailure(String failure)
	{
		this.errorList.add(failure);
	}
	
	public void addInfo(String info)
	{
		this.infoList.add(info);
	}
	
	public void addSuccess(String success)
	{
		this.successList.add(success);
	}

	public void addWarn(String warn)
	{
		this.warnList.add(warn);
	}

	public Object extractParam(String key)
	{
		if(!this.params.containsKey(key))
			return null;
		return this.params.get(key);
	}
}
