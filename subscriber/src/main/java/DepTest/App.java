package DepTest;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

/**
 * Hello world!
 *
 */
public class App 
{
    static final String src = "ec2-54-249-140-50.ap-northeast-1.compute.amazonaws.com";

    public static void subscribe_test() {
        Jedis j = new Jedis("localhost");
        class Subscriber extends JedisPubSub {
            @Override
            public void onMessage(String channel, String msg) {
                System.out.println("Got " + msg + " from " + channel);
            }

            @Override
            public void onPMessage(String s, String s2, String s3) { }

            @Override
            public void onSubscribe(String s, int i) { }

            @Override
            public void onUnsubscribe(String s, int i) { }

            @Override
            public void onPUnsubscribe(String s, int i) { }

            @Override
            public void onPSubscribe(String s, int i) { }
        }
        j.subscribe(new Subscriber(), "pubsubtest");
    }

    public static void main( String[] args )
    {
        subscribe_test();
    }
}
