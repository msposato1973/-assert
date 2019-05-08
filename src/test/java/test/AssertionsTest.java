package test;

import java.util.HashMap;
import java.util.Map;

import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runners.MethodSorters;
import  test.AssertionsTest;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AssertionsTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();
   

    /**
     * Test variables
     */
    private static final String STRING_1 = "1";
    private static final String STRING_1_TWIN = "1";
    private static final String STRING_2 = "2";
    private static final int NUMBER_1 = 1;
    private static final int NUMBER_1_TWIN = 1;
    private static final String NOTHING = null;
    private static final String NOTHING_TWIN = null;
    private static final Map<String, String[]> EMPTY_MAP = new HashMap<String, String[]>();
    private static final Map<String, String[]> EMPTY_MAP_TWIN = new HashMap<String, String[]>();
    private static final int[] EMPTY_ARRAY = new int[]{};
    private static final int[] EMPTY_ARRAY_TWIN = new int[]{};
    private static final Map<String, Object[]> MAP_1      = new HashMap<String, Object[]>();
    private static final Map<String, Object[]> MAP_1_TWIN = new HashMap<String, Object[]>();
    private static final Map<String, Object[]> MAP_2 = new HashMap<String, Object[]>();
    private static final Map<String, Object[]> MAP_3 = new HashMap<String, Object[]>();
    private static final Map<String, Object[]> MAP_4 = new HashMap<String, Object[]>();
    private static final Map<String, Object[]> MAP_5 = new HashMap<String, Object[]>();
    private static final Object[] ARRAY_1      = new Object[]{new Object[]{1, 2, 3}, new Object[]{1, 2, 3}};
    private static final Object[] ARRAY_1_TWIN = new Object[]{new Object[]{1, 2, 3}, new Object[]{1, 2, 3}};
    private static final Object[] ARRAY_2 = new Object[]{new Object[]{1, 2, 3}, new Object[]{1, 2, "3"}};
    private static final Object[] ARRAY_3 = new Object[]{1, 2, 3, 4, 5};
    private static final Object[] ARRAY_4 = new Object[]{1, 2, 3, 4};
    private static final Object[] ARRAY_5 = new Object[]{1, 2, 3, 4, "5"};
    private static final Object[] ARRAY_6 = new Object[]{1, 2, 3, 4, "6"};

    static {
        final Map<String, Object> innerObject1 = new HashMap<String, Object>();
        innerObject1.put("Item1.1", "0");
        final Map<String, Object> innerObject2 = new HashMap<String, Object>();
        innerObject2.put("Item2.1", "Red");
        final Map<String, Object> innerObject3 = new HashMap<String, Object>();
        innerObject3.put("Item1.1", 0);
        final Map<String, Object> innerObject4 = new HashMap<String, Object>();
        innerObject4.put("Item2.1", "Red");

        MAP_1.put("Item1", new Object[]{"A", "B", "C", "D"});
        MAP_1.put("Item2", new Object[]{"A", "B", "C"});
        MAP_1_TWIN.put("Item1", new Object[]{"A", "B", "C", "D"});
        MAP_1_TWIN.put("Item2", new Object[]{"A", "B", "C"});
        MAP_2.put("First", new Object[]{"A", "B", "C", "D"});
        MAP_2.put("Second", new Object[]{"A", "B", "C", "D"});
        MAP_3.put("Item1", new Object[]{"A", "B", "C", "D"});
        MAP_3.put("Item2", new Object[]{"A", "B", "C", "D"});
        MAP_4.put("Item1", new Object[]{innerObject1});
        MAP_4.put("Item2", new Object[]{innerObject2});
        MAP_5.put("Item1", new Object[]{innerObject3});
        MAP_5.put("Item2", new Object[]{innerObject4});
    }

    @Test
	public void equal_001() {
		Assertions.assertEquals("Should be Equal 1: STRING_1 vs STRING_1_TWIN", STRING_1, STRING_1_TWIN);
	}
	
	@Test
	public void equal_002() {
		Assertions.assertEquals("Should be Equal 2: NUMBER_1 vs NUMBER_1_TWIN", NUMBER_1, NUMBER_1_TWIN);
	}
	
	@Test
	public void equal_003() {
		Assertions.assertEquals("Should be Equal 3: NOTHING vs NOTHING_TWIN", NOTHING, NOTHING_TWIN);
	}
	
	@Test
	public void equal_004() {
		Assertions.assertEquals("Should be Equal 4: EMPTY_MAP vs EMPTY_MAP_TWIN", EMPTY_MAP, EMPTY_MAP_TWIN);
	}
	
	@Test
	public void equal_005() {
		Assertions.assertEquals("Should be Equal 5: MAP_1 vs MAP_1_TWIN", MAP_1, MAP_1_TWIN);
	}
		
	@Test
	public void equal_006() {
		Assertions.assertEquals("Should be Equal 6: EMPTY_ARRAY vs EMPTY_ARRAY_TWIN", EMPTY_ARRAY, EMPTY_ARRAY_TWIN);
	}
	
	@Test
	public void equal_007() {
		Assertions.assertEquals("Should be Equal 7: ARRAY_1 vs ARRAY_1_TWIN", ARRAY_1, ARRAY_1_TWIN);
	}

    @Test
    public void not_equal_001() {
        expectedException.expect(AssertionError.class);
        expectedException.expectMessage("TODO: failure message");
        Assertions.assertEquals("Should NOT be Equal 1: STRING_1 vs STRING_2", STRING_1, STRING_2);
    }

    @Test
    public void not_equal_002() {
        expectedException.expect(AssertionError.class);
        expectedException.expectMessage("TODO: failure message");
        Assertions.assertEquals("Should NOT be Equal 2: STRING_1 vs NUMBER_1", STRING_1, NUMBER_1);
    }

    @Test
    public void not_equal_003() {
        expectedException.expect(AssertionError.class);
        expectedException.expectMessage("TODO: failure message");
        Assertions.assertEquals("Should NOT be Equal 3: STRING_1 vs MAP_1", STRING_1, MAP_1);
    }

    @Test
    public void not_equal_004() {
        expectedException.expect(AssertionError.class);
        expectedException.expectMessage("TODO: failure message");
        Assertions.assertEquals("Should NOT be Equal 4: EMPTY_MAP vs MAP_1", EMPTY_MAP, MAP_1);
    }

    @Test
    public void not_equal_005() {
        expectedException.expect(AssertionError.class);
        expectedException.expectMessage("TODO: failure message");
        Assertions.assertEquals("Should NOT be Equal 5: EMPTY_MAP vs EMPTY_ARRAY", EMPTY_MAP, EMPTY_ARRAY);
    }

    @Test
    public void not_equal_006() {
        expectedException.expect(AssertionError.class);
        expectedException.expectMessage("TODO: failure message");
        Assertions.assertEquals("Should NOT be Equal 6: MAP_1 vs NOTHING", MAP_1, NOTHING);
    }

    @Test
    public void not_equal_007() {
        expectedException.expect(AssertionError.class);
        expectedException.expectMessage("TODO: failure message");
        Assertions.assertEquals("Should NOT be Equal 7: ARRAY_1 vs ARRAY_2", ARRAY_1, ARRAY_2);
    }

    @Test
    public void not_equal_008() {
        expectedException.expect(AssertionError.class);
        expectedException.expectMessage("TODO: failure message");
        Assertions.assertEquals("Should NOT be Equal 8: ARRAY_3 vs ARRAY_4", ARRAY_3, ARRAY_4);
    }

    @Test
    public void not_equal_009() {
        expectedException.expect(AssertionError.class);
        expectedException.expectMessage("TODO: failure message");
        Assertions.assertEquals("Should NOT be Equal 9: ARRAY_3 vs ARRAY_5", ARRAY_3, ARRAY_5);
    }

    @Test
    public void not_equal_010() {
        expectedException.expect(AssertionError.class);
        expectedException.expectMessage("TODO: failure message");
        Assertions.assertEquals("Should NOT be Equal 10: ARRAY_5 vs ARRAY_6", ARRAY_5, ARRAY_6);
    }

    @Test
    public void not_equal_011() {
        expectedException.expect(AssertionError.class);
        expectedException.expectMessage("TODO: failure message");
        Assertions.assertEquals("Should NOT be Equal 11: MAP_1 vs MAP_2", MAP_1, MAP_2);
    }

    @Test
    public void not_equal_012() {
        expectedException.expect(AssertionError.class);
        expectedException.expectMessage("TODO: failure message");
        Assertions.assertEquals("Should NOT be Equal 12: MAP_2 vs MAP_3", MAP_2, MAP_3);
    }

    @Test
    public void not_equal_013() {
        expectedException.expect(AssertionError.class);
        expectedException.expectMessage("TODO: failure message");
        Assertions.assertEquals("Should NOT be Equal 13: MAP_4 vs MAP_5", MAP_4, MAP_5);
    }
}
