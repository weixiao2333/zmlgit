package zju.ccnt;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import zju.ccnt.entity.Student;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CcntApplicationTests {

//    @Autowired
//    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void test() throws Exception {

        // 保存字符串
//        stringRedisTemplate.opsForValue().set("aaa", "111");
//        Assert.assertEquals("111", stringRedisTemplate.opsForValue().get("aaa"));

        Student user = new Student();
        user.setName("微笑");
        user.setAge(21);

        redisTemplate.opsForValue().set("user_1", user);
        Student user1 = (Student) redisTemplate.opsForValue().get("user_1");

        System.out.println(user1.getName());

    }

}

