import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.util.HashMap;

import java.util.Map;

/**
 * Create with IntelliJ IDEA
 * User : kevin
 * Dare : 2018/4/8
 * Time : 15:20
 * To change this template use File | Setting | File Template.
 * Description :
 */
public class JacksonTest {

  @Test
  public void jacksonTest() throws JsonProcessingException {
    Map map = new HashMap();

    map.put("key", "val");
    map.put("1", "2");
    map.put("3", "4");


    ObjectMapper mapper = new ObjectMapper();

    String data = mapper.writeValueAsString(map);
    System.out.println(data);
  }
}
