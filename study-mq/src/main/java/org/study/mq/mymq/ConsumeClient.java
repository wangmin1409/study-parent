package org.study.mq.mymq;

/**
 * @author wangmin
 * @description 消费者客户端
 * created at 2019/12/12 4:41 下午
 */
public class ConsumeClient {
	public static void main(String[] args) throws Exception {
		String message = MqClient.consume();
		System.out.println("获取的消息为：" + message);
	}
}
