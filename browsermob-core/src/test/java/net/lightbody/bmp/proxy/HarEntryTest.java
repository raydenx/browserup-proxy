package net.lightbody.bmp.proxy;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import net.lightbody.bmp.core.har.HarEntry;
import org.junit.Test;

import java.io.StringWriter;
import java.io.Writer;
import java.time.Month;

import static org.junit.Assert.*;

/**
 * Created by ebeland on 2/7/17.
 */
public class HarEntryTest {

  @Test
  public void testTags() throws Exception {
    HarEntry harEntry = new HarEntry();
    harEntry.addTag("_foo", "bar");
    assertEquals("bar", harEntry.get_tags().get("_foo"));
  }

  @Test
  public void testTagSerialization() throws Exception {
    HarEntry harEntry = new HarEntry();

    harEntry.addTag("foo", "bar");
    String json = new ObjectMapper().writeValueAsString(harEntry);

    assertTrue(json.contains("bar"));
    assertTrue(json.contains("_tags"));

  }


}