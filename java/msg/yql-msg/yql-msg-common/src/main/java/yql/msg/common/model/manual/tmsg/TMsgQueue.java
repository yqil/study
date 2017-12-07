package yql.msg.common.model.manual.tmsg;

import java.util.concurrent.ConcurrentLinkedQueue;

import yql.msg.common.model.auto.tmsg.TMsg;

public class TMsgQueue {
	/**
	 * 需要重发消息的队列
	 */
	public static final ConcurrentLinkedQueue<TMsg> list = new ConcurrentLinkedQueue<TMsg>();
}
