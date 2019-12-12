package org.study.mq.mymq;

/**
 * @author wangmin
 * @description 生产者客户端
 * created at 2019/12/12 4:42 下午
 */
public class ProduceClient {
	public static void main(String[] args) throws Exception {
		MqClient.produce("Hello World");
	}
}
