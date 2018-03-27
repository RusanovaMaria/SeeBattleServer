package domain.rule;

import domain.gameobject.Kind;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ClassicRuleTest {

    @Test
    public void countNumberOfObjects() {
        Rule rule = new ClassicRule();
        int number = rule.countNumberOfObjects(Kind.SINGLE_DECKED);
        assertEquals(4, number);
    }
}