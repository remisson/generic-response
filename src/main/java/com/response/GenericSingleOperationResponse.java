/****************************************************************
 * Response (String) based. Returns 'success' and 'failure'
 * lists.
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
public class GenericSingleOperationResponse extends GenericBaseResponse
{
	private Map<String,Object> params;
	private List<String> successList;
	private List<String> failureList;

	public GenericSingleOperationResponse()
	{
		this.status	  = "";
		this.params	 = new HashMap<String,Object>();
		this.successList = new ArrayList<String>();
		this.failureList = new ArrayList<String>();
	}

	public void addSuccess(final String description)
	{
		this.successList.add(description);
	}

	public void addFailure(final String description)
	{
		this.failureList.add(description);
	}

	public void cleanSuccessList()
	{
		successList = new ArrayList<String>();
	}

	public void cleanFailureList()
	{
		failureList = new ArrayList<String>();
	}

	public List<String> getSuccessList()
	{
		return successList;
	}

	public void setSuccessList(List<String> successList)
	{
		this.successList = successList;
	}

	public List<String> getFailureList()
	{
		return failureList;
	}

	public void setFailureList(List<String> failureList)
	{
		this.failureList = failureList;
	}

	public String getFirstSuccessString()
	{
		if(this.successList != null && !this.successList.isEmpty())
			return this.successList.get(0);
		return null;
	}

	public String getFirstFailureString()
	{
		if(this.failureList != null && !this.failureList.isEmpty())
			return this.failureList.get(0);
		return null;
	}

	public void setParams(Map<String,Object> params)
	{
		this.params = params;
	}

	public void addParam(String key,Object value)
	{
		this.params.put(key, value);
	}

	public Object extractParam(String key)
	{
		if(!this.params.containsKey(key))
			return null;
		return this.params.get(key);
	}

	public Map<String, Object> getParams() {
		return params;
	}
}
