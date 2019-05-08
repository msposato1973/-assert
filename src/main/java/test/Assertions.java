package test;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * 
 * @author maxp
 *
 */
public class Assertions {
	

	/**
	 * Asserts the first thing is equal to the second thing
	 *
	 * @param message
	 *            A message describing the test that will be displayed on failure
	 * @param expected
	 *            The expected object to compare to
	 * @param actual
	 *            The actual object to compare
	 */
	public static void assertEquals(String message, Object expected, Object actual) {

		String failureMessage = "TODO: failure message";
		boolean isFail = false;

		if (actual == null && expected == null) {
			if (actual == null || expected == null) {
				isFail = true;
				System.out.println(failureMessage);
			}
		} else if(actual == null || expected == null) {
			fail(message, failureMessage);	
		} else if (expected instanceof String && actual instanceof String) {
			String sExpected = (String) expected;
			String sActual = (String) actual;
			isFail = (sExpected.equals(sActual) ? false : true);
			if (isFail) fail(message, failureMessage);
		} else if ((expected.getClass() != actual.getClass())) {
			String sexpected = new String(expected.getClass().toString());
			String sactual = new String(actual.getClass().toString());
			isFail = !sexpected.equalsIgnoreCase(sactual);
			if(isFail) {
				System.out.println(failureMessage);
				fail(message, failureMessage);
			}
		} else if ((expected instanceof Map<?,?>) && (actual instanceof Map<?,?>)) {
			Map<String, Object[]> mapExpected = (HashMap<String, Object[]>) expected;
			Map<String, Object[]> mapActual = (HashMap<String, Object[]>) actual;
			isFail = mapsAreEqual(mapExpected, mapActual, message);
			if (isFail==false) fail(message, failureMessage);
		} else if ((expected.getClass().isArray()) && (actual.getClass().isArray())) {
			if(Array.getLength(expected)>0 && Array.getLength(actual)>0) {
				if(((Object[]) actual).length != 0 && (((Object[]) expected)).length != 0) {
					if(((Object[]) actual).length != ((Object[]) expected).length) {
						fail(message, failureMessage);
					}else {
						assertArray((Object[]) actual, (Object[]) expected, message);
					}
					
				}
			}
		}
	}

	/**
	 * Reports a failure
	 *
	 * @param message
	 *            The message passed into the test
	 * @param failureMessage
	 *            The message describing the failure
	 */
	private static void fail(String message, String failureMessage) {
		if (message == null) {
			message = "";
		}
		if (failureMessage != null) {
			message += "; " + failureMessage;
		}
		System.out.println(message);
		throw new AssertionError(message);
	}

	/***
	 * 
	 * @param expected
	 * @param actual
	 * @return
	 */
	private static boolean equalsRegardingNull(Object expected, Object actual) {
		if (actual == expected) {
			return false;
		}

		if (actual == null || expected == null) {
			return false;
		}

		return isEquals(expected, actual);
	}

	/***
	 * 
	 * @param expected
	 * @param actual
	 * @return
	 */
	private static boolean isEquals(Object expected, Object actual) {
		boolean isValid = false;
		if ((expected.getClass() != actual.getClass())) return isValid;
		String sexpected =  expected.toString();
		String sactual =  actual.toString();
		 
		isValid = sexpected.equalsIgnoreCase(sactual);
		System.out.println("isValid : "+isValid);
		
		return isValid;
	}

	/***
	 * 
	 * @param actual
	 * @param expected
	 * @param message
	 */
	private static void assertArray(Object[]  actual, Object[]  expected, String message) {
		String failureMessage = "TODO: failure message";
		boolean isFail = false;
		if (expected == actual) {
			return;
		}

		if (null == expected) {
			fail(message, failureMessage);
		}

		if (null == actual) {
			fail(message, failureMessage);
		}

		int expectedLength = expected.length;
		if (expected.length != actual.length) {
			fail(message, "TODO: failure message");
		}

		for (int i = 0; i < expectedLength; i++) {
			Object _actual = Array.get(actual, i);
			Object _expected = Array.get(expected, i);
			if ((_expected.getClass().isArray()) && (_actual.getClass().isArray())) {
				assertArray((Object[]) _actual, (Object[]) _expected, message);
			}else {
				isFail = isEquals(_expected, _actual);
				if (isFail==false) {
					fail(message, "TODO: failure message");
				}
			}
		}
	}
	
	
	/***
	 * 
	 * @param actual
	 * @param expected
	 * @param message
	 */
	private static boolean assertArray(Object[]  actual, Object[]  expected, String message, boolean isValid) {
		String failureMessage = "Should be Equal 7: ARRAY_1 vs ARRAY_1_TWIN";
		boolean isFail = false;
		 

		if (null == expected) {
			isValid = false;
			fail(message, failureMessage);
		}

		if (null == actual) {
			isValid = false;
			fail(message, failureMessage);
		}

		int expectedLength = expected.length;
		if (expected.length != actual.length) {
			isValid = false;
			fail(message, "TODO: failure message");
		}

		for (int i = 0; i < expectedLength; i++) {
			Object _actual = Array.get(actual, i);
			Object _expected = Array.get(expected, i);
			if ((_expected.getClass().isArray()) && (_actual.getClass().isArray())) {
				assertArray((Object[]) _actual, (Object[]) _expected, message);
			}else {
				isFail = isEquals(_expected, _actual);
				if (isFail==false) {
					isValid = false;
					fail(message, "TODO: failure message");
				}
			}
		}
		return isValid;
	}

	/***
	 * 
	 * @param mapExpected
	 * @param mapActual
	 * @return
	 */
	private static boolean mapsAreEqual(Map<String, Object[]> mapExpected, Map<String, Object[]> mapActual, String message) {
		boolean exsist = true;
		if (mapActual == null || mapExpected == null) {
			fail(message, "TODO: failure message");
		}
		 
		if (mapActual.size() != mapExpected.size()) {
			 fail(message, "TODO: failure message");
		}
		 
		if (mapActual == mapExpected) {
			  return exsist;
		}
		
		try {
			
			for (String key : mapActual.keySet()) {
				exsist = mapExpected.containsKey(key); 
				if (exsist == false) {
					return false;
				}else {
					if(mapActual.get(key)!=mapExpected.get(key)) {
						if(assertArrayMap(mapExpected, mapActual, message)==false) return false;
						else if(assertArray((Object[]) mapActual.get(key), (Object[])  mapExpected.get(key), message, exsist)==false)   return false;
					}
				} 
			}
			 
		} catch (NullPointerException np) {
			return false;
		}
		return true;
	}
	
	/**
	 * 
	 * @param mapExpected
	 * @param mapActual
	 * @param message
	 * @return
	 */
	private static boolean assertArrayMap(Map<String, Object[]> mapExpected, Map<String, Object[]> mapActual, String message) {
		boolean isValid = true;
		String jsonExpected = getJsonFromMap(mapExpected).toString() ;
		String jsonActual = getJsonFromMap(mapActual).toString() ;
		isValid = (jsonExpected.equals(jsonActual)? true :false);
		return isValid;
	}
	
	/**
	 * 
	 * @param map
	 * @return
	 * @throws JSONException
	 */
	private static JSONObject getJsonFromMap(Map<String, Object[]> map ) throws JSONException {
	    JSONObject jsonExpected = new JSONObject();
	    for (String key : map.keySet()) {
	        Object value = map.get(key);
	        if (value instanceof Map<?, ?>) {
	            value = getJsonFromMap((Map<String, Object[]>) value);
	        }
	        jsonExpected.put(key, value);
	    }
	    
	    return jsonExpected;
	}

}
