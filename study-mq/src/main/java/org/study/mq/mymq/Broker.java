package org.study.mq.mymq;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author wangmin
 * @description ��Ϣ����
 * created at 2019/12/12 4:40 ����
 */
public class Broker {
	//���д洢��Ϣ���������
	private final static int MAX_SIZE  = 3;

	//������Ϣ���ݵ�����
	private static ArrayBlockingQueue<String> messageQueue = new ArrayBlockingQueue<>(MAX_SIZE);

	//������Ϣ
	public static void produce(String msg) {
		if (messageQueue.offer(msg)) {
			System.out.println("�ɹ�����Ϣ��������Ͷ����Ϣ��" + msg + "����ǰ�ݴ����Ϣ�����ǣ�" + messageQueue.size());
		} else {
			System.out.println("��Ϣ�����������ݴ����Ϣ�ﵽ��󸺺ɣ����ܼ���������Ϣ��");
		}
		System.out.println("======================");
	}

	//������Ϣ
	public static String consume() {
		String msg = messageQueue.poll();
		if (msg != null) {
			//���������������������Ϣ������ȡ��һ����Ϣ
			System.out.println("�Ѿ�������Ϣ��" + msg + "����ǰ�ݴ����Ϣ�����ǣ�" + messageQueue.size());
		} else {
			System.out.println("��Ϣ����������û����Ϣ�ɹ����ѣ�");
		}
		System.out.println("===================");
		return msg;
	}
}
