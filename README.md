# interview-demo


***GitHub 地址*
```shell
https://github.com/PoJer-MM/interview-demo.git
```



## 0、前置条件
### DB mysql
```sql
-- 创建主库
CREATE DATABASE p_master;

USE p_master;

CREATE TABLE t_user (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50)
);

INSERT INTO t_user(name) VALUES ('master-user');
```
```sql
-- 创建从库
CREATE DATABASE p_slave;

USE p_slave;

CREATE TABLE t_user (
                        id BIGINT PRIMARY KEY AUTO_INCREMENT,
                        name VARCHAR(50)
);

INSERT INTO t_user(name) VALUES ('slave-user');
```




## 1、在不使用其他第三方包情况下，实现spring读写分离
**实现数据库读写分离**
1. 使用ThreadLocal保存当前线程数据源标识
2. 使用AOP在方法执行前切换主从库
3. 使用Spring提供的AbstractRoutingDataSource实现动态路由
4. 通过以上步骤实现读写分离的目的
使用请求向主库写入数据：
```shell
curl --location --request POST 'http://127.0.0.1:8080/user?name=isjh'
```
使用请求向从库读取数据：
```shell
curl --location 'http://127.0.0.1:8080/user'
```
## 2、实现自定义注解
1. 创建自定义注解
2. @ReadOnly → 标记读操作
   @WriteOnly → 标记写操作
   根据注解 → 动态切换数据源

## 3、使用SQL实现获取上周一日期
```sql
SELECT DATE_SUB(CURDATE(), INTERVAL WEEKDAY(CURDATE()) + 7 DAY) AS last_monday;
```
WEEKDAY 函数以周一为起点返回 0~6，通过 CURDATE() 减去 WEEKDAY() 得到本周一，再减去 7 天即可得到上周一。

## 4、使用SQL实现相似度查询
```sql
SELECT t.id,t.name from t_user where LOCATE('abc', name) > 0;
```
使用 LOCATE 函数实现相似度查询，LOCATE('abc', name) > 0 表示 name 中包含 'abc'。

## 5、任意语言实现斐波那契数列
```java
public static long fib(int n) {

   if (n <= 1) {
      return n;
   }

   long a = 0;
   long b = 1;

   for (int i = 2; i <= n; i++) {

      long c = a + b;

      a = b;
      b = c;
   }

   return b;
}
```

## 6、展示typescript+nodejs作为服务端相关代码
见代码 node-demo

## 7、展示Python工程化相关代码
见代码 python-demo
