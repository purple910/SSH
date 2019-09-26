# mybatis 01
mybatis log4j cache

# mybatis  逆向工程
在MyBatis的开发过程中，数据库表、实体类、SQL映射文件以及动态代理接口四者之间有着非常密切的关系。

一般的开发流程是：先设计并创建数据库表（如学生表），再根据数据库表创建对应的实体类（如Student.java），之后再编写SQL映射文件（如studentMapper.xml），最后再根据SQL映射文件编写动态代理接口（如IStudentMapper.java）。

除此之外，我们还可以只设计并创建数据库表，然后利用MyBatis提供的工具来自动生成其他三个（实体类、SQL映射文件和动态代理接口）
