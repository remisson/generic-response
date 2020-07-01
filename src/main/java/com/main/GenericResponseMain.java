/****************************************************************
 * Response Test
 ***************************************************************/
package com.main;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.response.GenericResponse;

/**
 * @author Remisson dos Santos Silva
 * @since 2020-07-01 01:43
 *
 */
public class GenericResponseMain
{
	public static void main(String[] args)
	{
		GenericResponse genericResponse = new GenericResponse();
		genericResponse.loadFailureStatus();
		genericResponse.addFailure("Error msg!");
		assertTrue(genericResponse.fail());
		assertFalse(genericResponse.success());

		genericResponse = new GenericResponse();
		genericResponse.loadSuccessStatus();
		genericResponse.addFailure("Success msg!");
		assertFalse(genericResponse.fail());
		assertTrue(genericResponse.success());

		genericResponse = new GenericResponse();
		genericResponse.loadSuccessStatus();
		genericResponse.addFailure("Success msg!");
		genericResponse.addParam("SOMETHING", new Double(5.5));
		assertFalse(genericResponse.fail());
		assertTrue(genericResponse.success());
		assertEquals(new Double(5.5), genericResponse.extractParam("SOMETHING"));
	}
}
