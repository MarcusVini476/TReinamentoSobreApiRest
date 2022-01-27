package passos;

import apis.ApiUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.UtilsCenario;

import java.util.HashMap;

public class Hooks extends ApiUtils {

        @Before
        public void before(Scenario cenario) {
            UtilsCenario.add(cenario);
            headers = new HashMap<>();
            params = new HashMap<>();
        }

        @After
        public void after() {
            UtilsCenario.remove();
        }
    }

