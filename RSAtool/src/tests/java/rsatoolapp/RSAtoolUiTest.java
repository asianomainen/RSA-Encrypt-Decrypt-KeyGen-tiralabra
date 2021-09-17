package rsatoolapp;

import org.junit.Before;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;
import rsatoolapp.ui.MainMenuUi;

import static org.junit.Assert.*;

public class RSAtoolUiTest extends ApplicationTest {
    MainMenuUi ui;

    @Before
    public void setUp() {
        ui = new MainMenuUi(960, 720);
    }

    @Test
    public void generateKeysButtonHasCorrectText() {
        assertEquals("Generate keys", ui.btnGenerate.getText());
    }
}
