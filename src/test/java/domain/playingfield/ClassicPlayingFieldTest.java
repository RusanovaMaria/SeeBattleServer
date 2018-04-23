package domain.playingfield;

import org.junit.Test;

import static org.junit.Assert.*;

public class ClassicPlayingFieldTest {

    @Test
    public void isEmpty() {
        ClassicPlayingField playingField = new ClassicPlayingField();
        boolean empty  = playingField.isEmpty();
        assertFalse(empty);
    }
}