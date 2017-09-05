ActiveMQ消息发送和接收实例，及与Spring结合实例。

项目介绍：
- jms项目，多模块maven项目的父项目，无任何代码，只在pom中定义spring，activemq和junit的版本号
- jms-activemq项目，无spring的activemq实例，包含点对点队列发送和同步、异步接收，主题发送和同步、异步接收。
- jms-spring-api项目，activemq与spring整合项目，消息发送接收的接口与实现
- jms-spring-client项目，activemq与spring整合项目的调用端，调用jms-spring-api定义的接口进行消息的发送和接收，可直接调用其中的JUnit测试类进行测试。

参考博文：
- Java-JMS http://masikkk.com/article/Java-JMS/
- Apache-ActiveMQ http://masikkk.com/article/Apache-ActiveMQ/

