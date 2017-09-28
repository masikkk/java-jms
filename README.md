# java-jms 
ActiveMQ消息发送和接收实例，及与Spring结合实例。

## 项目介绍
本项目是一个maven多模块项目，简介如下：
- **jms项目**，多模块maven项目的父项目，无任何代码，只在pom中定义spring，activemq和junit的版本号
- **jms-activemq项目**，无spring的activemq实例，包含点对点队列发送和同步、异步接收，主题发送和同步、异步接收。
- **jms-spring-api项目**，activemq与spring整合项目，消息发送接收的接口与实现
- **jms-spring-client项目**，activemq与spring整合项目的调用端，调用jms-spring-api定义的接口进行消息的发送和接收，可直接运行其中的JUnit测试类进行测试。

## 运行方法
首先本地安装并启动ActiveMQ，在控制台http://127.0.0.1:8161/admin/ 查看队列
- jms-activemq项目
  - 队列发送与接收：首先Run As->Java Application运行消息生产者QueueSender向队列发送消息，然后运行消费者QueueReceiverSync或QueueReceiverAsync从队列接收消息，查看控制台输出。
  - 主题订阅与发布：首先Run As->Java Application运行订阅端TopicReceiverSync或TopicReceiverAsync订阅该主题，然后运行发布端TopicSender，查看控制台输出。
- jms-spring-client项目
  - 手动加载Spring上下文进行测试：首先Run As->Java Application运行ProducerMain向目的地发送消息，然后运行ConsumerSyncMain或ConsumerAsyncMain从目的地接收消息，查看控制台输出。
  - JUnit自动测试
    - 测试同步接收：首先Run As->JUnit Test运行ProducerTest向目的地发送消息，然后运行ConsumerSyncTest从目的地接收消息，
    - 测试异步接收：直接Run As->JUnit Test运行ConsumerAsyncTest

## 参考博文
- Java-JMS http://masikkk.com/article/Java-JMS/
- Apache-ActiveMQ http://masikkk.com/article/Apache-ActiveMQ/

