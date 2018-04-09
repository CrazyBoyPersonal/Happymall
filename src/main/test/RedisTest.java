import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Create with IntelliJ IDEA
 * User : kevin
 * Dare : 2018/4/7
 * Time : 23:22
 * To change this template use File | Setting | File Template.
 * Description :
 */
public class RedisTest {

  @Autowired
  Jedis jedis;

  @Test
  public void redisTest() {
    //Jedis jedis = new Jedis("192.168.42.130");
    System.out.println(jedis.ping());
  }

  @Test
  public void serRedisTest() {
    //Jedis jedis = new Jedis("192.168.42.130");
    jedis.set("token", "123sfq3we342w2343e3d2342536yhg65f54643r78987x");
    jedis.expire("token", 100);
  }

  @Test
  public void getRedisTest() {
    //Jedis jedis = new Jedis("192.168.42.130");
    System.out.println(jedis.get("token"));
  }
}
