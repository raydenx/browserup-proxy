package net.lightbody.bmp.proxy;

/**
 * Created by ebeland on 2/8/17.
 */

import com.fasterxml.jackson.databind.ObjectMapper;
import net.lightbody.bmp.core.har.HarPage;
import org.junit.Test;
import static org.junit.Assert.*;

public class HarPageTest {

  @Test
  public void testTags() throws Exception {
    HarPage harPage = new HarPage();
    harPage.addTag("_foo", "bar");
    assertEquals("bar", harPage.get_tags().get("_foo"));
  }

  @Test
  public void testTagSerialization() throws Exception {
    HarPage harPage = new HarPage();

    harPage.addTag("foo", "bar");
    String json = new ObjectMapper().writeValueAsString(harPage);

    assertTrue(json.contains("bar"));
    assertTrue(json.contains("_tags"));
  }

  @Test
  public void testMetricSerialization() throws Exception {
    HarPage harPage = new HarPage();

    harPage.addMetric("boo", 4);
    String json = new ObjectMapper().writeValueAsString(harPage);

    assertTrue(json.contains("_metrics"));
    assertTrue(json.contains("boo"));
    assertTrue(json.contains("4"));
  }

}
