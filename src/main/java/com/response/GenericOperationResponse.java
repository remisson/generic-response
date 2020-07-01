/****************************************************************
 * Response (String - Object) based. Returns 'success' and 'failure'
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
@SuppressWarnings({"serial","unchecked"})
public class GenericOperationResponse extends GenericBaseResponse
{
	private List<Map<String,Object>> successList;
	private List<Map<String,Object>> failureList;

	public GenericOperationResponse()
	{
		status	  = "";
		successList = new ArrayList<Map<String,Object>>();
		failureList = new ArrayList<Map<String,Object>>();
	}

	public void addSuccessObj(final Object obj, final String description)
	{
		this.successList.add(
			new HashMap<String,Object>()
			{{
				put("OBJECT",obj);
				put("DESCRIPTION",description);
			}}
		);
	}

	public void addSuccessObj(final Object obj)
	{
		this.successList.add(
			new HashMap<String,Object>()
			{{
				put("OBJECT",obj);
				put("DESCRIPTION",null);
			}}
		);
	}

	public void addFailureObj(final Object obj, final String description)
	{
		this.failureList.add(
			new HashMap<String,Object>()
			{{
				put("OBJECT",obj);
				put("DESCRIPTION",description);
			}}
		);
	}

	public void addFailureObj(final Object obj)
	{
		this.failureList.add(
			new HashMap<String,Object>()
			{{
				put("OBJECT",obj);
				put("DESCRIPTION",null);
			}}
		);
	}

	public void cleanSuccessList()
	{
		this.successList = new ArrayList<Map<String,Object>>();
	}
	
	public void cleanFailureList()
	{
		this.failureList = new ArrayList<Map<String,Object>>();
	}

	public List<Map<String, Object>> getSuccessList()
	{
		return successList;
	}

	public void setSuccessList(List<Map<String, Object>> successList)
	{
		this.successList = successList;
	}

	public List<Map<String, Object>> getFailureList()
	{
		return failureList;
	}

	public void setFailureList(List<Map<String, Object>> failureList)
	{
		this.failureList = failureList;
	}

	public Object extractFirstSuccessObject()
	{
		try
		{
			return this.extractList(this.successList,"OBJECT").get(0);
		}
		catch(Exception e)
		{
			return null;
		}
	}

	public Object extractFirstFailureObject()
	{
		try
		{
			return this.extractList(this.failureList,"OBJECT").get(0);
		}
		catch(Exception e)
		{
			return null;
		}
	}

	public List<Object> extractSuccessObjectList()
	{
		return this.extractList(this.successList,"OBJECT");
	}

	public List<Object> extractFailureObjectList()
	{
		return this.extractList(this.failureList,"OBJECT");
	}

	public List<Object> extractSuccessDescriptionList()
	{
		return this.extractList(this.successList,"DESCRIPTION");
	}
	
	public List<Object> extractFailureDescriptionList()
	{
		return this.extractList(this.failureList,"DESCRIPTION");
	}

	public Object extractFirstFailureDescription()
	{
		try
		{
			return this.extractList(this.failureList,"DESCRIPTION").get(0);
		}
		catch(Exception e)
		{
			return null;
		}
	}

	public Object extractFirstSuccessDescription()
	{
		try
		{
			return this.extractList(this.successList,"DESCRIPTION").get(0);
		}
		catch(Exception e)
		{
			return null;
		}
	}
	
	private List<Object> extractList(List<Map<String,Object>> l,String key)
	{
		@SuppressWarnings("rawtypes")
		List _list = new ArrayList<Object>();
		for(Map<String,Object> current : l)
			_list.add(current.get(key));
		return _list;
	}

	public void clean()
	{
		status	  = "";
		successList = new ArrayList<Map<String,Object>>();
		failureList = new ArrayList<Map<String,Object>>();
	}
}
